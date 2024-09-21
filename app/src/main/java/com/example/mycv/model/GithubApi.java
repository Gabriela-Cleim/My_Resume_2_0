package com.example.mycv.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);
}
