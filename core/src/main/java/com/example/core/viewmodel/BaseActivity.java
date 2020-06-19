package com.example.core.viewmodel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 基础的activit
 * @param <Binding>
 * @param <VM>
 */
public abstract class BaseActivity<Binding extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected Binding binding;
    protected VM vm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        vm=createVM();
    }

    /**
     * 创建VM
     * @return
     */
    protected abstract VM createVM();

    /**
     * 设置布局id
     * @return
     */
    protected abstract int getLayoutId();
}
