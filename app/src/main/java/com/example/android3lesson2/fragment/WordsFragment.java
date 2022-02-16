package com.example.android3lesson2.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
    private  AdapterWords adapterWords = new AdapterWords();


    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getImages();

    }

    private void getImages() {
        binding.btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.retrofitClient.providePixabayApi().getImages("25685068-7116e7d30f855f738b052fb93",
                        binding.etWords.getText().toString()).enqueue(new Callback<PixabayResponce>() {
                    @Override
                    public void onResponse(Call<PixabayResponce> call, Response<PixabayResponce> response) {
                        if (response.isSuccessful()) {
                            adapterWords.setList(response.body().getHits());
                            binding.recyclerView.setAdapter(adapterWords);

                        }
                    }

                    @Override
                    public void onFailure(Call<PixabayResponce> call, Throwable t) {
                        Toast.makeText(getContext(), "asema pasema", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }


}
