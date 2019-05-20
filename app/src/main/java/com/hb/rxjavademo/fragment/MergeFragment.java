package com.hb.rxjavademo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.MergedDataBinderMapper;
import androidx.lifecycle.ViewModelProviders;

import com.hb.rxjavademo.R;
import com.hb.rxjavademo.databinding.FragmentCreateOperatorBinding;
import com.hb.rxjavademo.databinding.FragmentMergeOperatorBinding;
import com.hb.rxjavademo.viewmodel.CreateOperatorViewModel;
import com.hb.rxjavademo.viewmodel.MergeOperatorViewModel;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 12:38
 */
public class MergeFragment extends BaseFragment {

    private MergeOperatorViewModel mMergeOperatorViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentMergeOperatorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_merge_operator, container, false);
        initViewModel();
        binding.setViewmodel(mMergeOperatorViewModel);
        return binding.getRoot();
    }

    private void initViewModel() {
        mMergeOperatorViewModel = ViewModelProviders.of(this).get(MergeOperatorViewModel.class);
    }
}
