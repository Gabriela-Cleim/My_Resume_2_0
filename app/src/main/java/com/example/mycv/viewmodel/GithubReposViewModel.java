package com.example.mycv.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycv.model.GithubRepository;
import com.example.mycv.model.Repository;

import java.util.List;

public class GithubReposViewModel extends ViewModel {

    private GithubRepository githubRepository;
    private MutableLiveData<List<Repository>> repos;

    public GithubReposViewModel() {
        githubRepository = new GithubRepository();
        repos = new MutableLiveData<>(); // Inicialize o LiveData aqui
    }

    public void fetchRepos(String username) {
        // Busque os repositórios e atualize o LiveData
        githubRepository.getRepos(username, repos);
    }

    public LiveData<List<Repository>> getRepos() {
        return repos;
    }
}
