package com.example.core.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.core.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class BaseViewModel extends ViewModel implements LifecycleObserver {
    protected Map<String, Repository> repositoryMap;

    public BaseViewModel() {
        repositoryMap = new HashMap<>();
    }

    /**
     * 注册数据仓库
     * @param key  数据仓库的标识
     * @param value 数据仓库的实例
     */
    protected void registerRepository(String key, Repository value) {
        if (repositoryMap.containsKey(key)) {
            return;
        }

        repositoryMap.put(key, value);
    }

    /**
     * 注销数据仓库
     * @param key
     */
    protected void unRepository(String key) {
        if (repositoryMap.containsKey(key)) {
            repositoryMap.remove(key);
        }
    }

    /**
     * 根据key获取具体的数据仓库
     * @param key 数据仓库的标识
     * @param <SubRepository> 具体的数据仓库
     * @return
     */
    protected <SubRepository> SubRepository getRepository(String key) {
        if (repositoryMap.containsKey(key)) {
            return (SubRepository) repositoryMap.get(key);
        } else {
            return null;
        }
    }

    /**
     * 让GC清除数据
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnectOwner(){
        repositoryMap.clear();
        repositoryMap=null;
    }

}
