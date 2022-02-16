package com.example.android3lesson2.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.android3lesson2.App;
import com.example.android3lesson2.adapter.AdapterWords;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;
import com.example.android3lesson2.network.model.PixabayResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WordsFragment extends BaseFragment<FragmentWordsBinding> {
    private final AdapterWords adapterWords = new AdapterWords();


    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapterWords);
        getImages();

    }

    private void getImages() {
        binding.etWords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                App.api.getImages("25685068-7116e7d30f855f738b052fb93", binding.etWords.getText().toString()).enqueue(new Callback<PixabayResponce>() {
                    @Override
                    public void onResponse(Call<PixabayResponce> call, Response<PixabayResponce> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapterWords.setList(response.body().getHits());
                        }
                    }

                    @Override
                    public void onFailure(Call<PixabayResponce> call, Throwable t) {

                    }
                });
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}