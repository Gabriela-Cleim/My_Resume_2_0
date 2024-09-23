package com.example.mycv.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycv.model.repository.GithubRepository;
import com.example.mycv.model.repository.Repository;

import java.util.List;

public class GithubReposViewModel extends ViewModel {

    private GithubRepository githubRepository;
    private MutableLiveData<List<Repository>> repository;

    public GithubReposViewModel() {
        githubRepository = new GithubRepository();
        repository = new MutableLiveData<>();
    }

    public void fetchRepos(String username) {

        githubRepository.getRepos(username, repository);
    }

    public LiveData<List<Repository>> getRepos() {
        return repository;
    }
}
