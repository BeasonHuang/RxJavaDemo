package com.hb.rxjavademo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.hb.rxjavademo.R;
import com.hb.rxjavademo.databinding.ActivityOperatorBinding;
import com.hb.rxjavademo.viewmodel.OperatorViewModel;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 09:32
 * 基本操作符Demo
 */
public class OperatorActivity extends BaseActivity {

    private OperatorViewModel mOperatorViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOperatorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_operator);
        initViewModel();
        binding.setViewmodel(mOperatorViewModel);
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        mOperatorViewModel = ViewModelProviders.of(this).get(OperatorViewModel.class);
    }
}
