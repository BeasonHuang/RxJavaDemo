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
import com.hb.rxjavademo.databinding.FragmentCreateOperatorBinding;
import com.hb.rxjavademo.viewmodel.CreateOperatorViewModel;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 12:38
 */
public class CreateFragment extends BaseFragment {

    private CreateOperatorViewModel mCreateOperatorViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentCreateOperatorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_operator, container, false);
        initViewModel();
        binding.setViewmodel(mCreateOperatorViewModel);
        return binding.getRoot();
    }

    private void initViewModel() {
        mCreateOperatorViewModel = ViewModelProviders.of(this).get(CreateOperatorViewModel.class);
    }
}
