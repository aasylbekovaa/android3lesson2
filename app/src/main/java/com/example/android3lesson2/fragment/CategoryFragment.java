package com.example.android3lesson2.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentCategoryBinding;


public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {

    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}