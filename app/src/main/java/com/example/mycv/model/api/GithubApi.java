package com.example.mycv.model.api;

import com.example.mycv.model.repository.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);
}
