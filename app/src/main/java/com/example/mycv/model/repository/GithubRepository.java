package com.example.mycv.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mycv.model.api.GithubApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepository {

    private GithubApi githubApi;

    public GithubRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }

    public void getRepos(String username, MutableLiveData<List<Repository>> data) {
        githubApi.listRepos(username).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                data.setValue(null);
            }
        });
    }
}
