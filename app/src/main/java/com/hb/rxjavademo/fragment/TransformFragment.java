package com.hb.rxjavademo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.hb.rxjavademo.R;
import com.hb.rxjavademo.databinding.FragmentTransformOperatorBinding;
import com.hb.rxjavademo.viewmodel.TransformOperatorViewModel;

/**
 * @author huangbiao
 * @data 2019 2019-05-19 22:51
 */
public class TransformFragment extends BaseFragment {

    private TransformOperatorViewModel mOperatorViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentTransformOperatorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_transform_operator, container, false);
        initViewModel();
        binding.setViewmodel(mOperatorViewModel);
        return binding.getRoot();
    }

    private void initViewModel() {
        mOperatorViewModel = ViewModelProviders.of(this).get(TransformOperatorViewModel.class);
    }
}
