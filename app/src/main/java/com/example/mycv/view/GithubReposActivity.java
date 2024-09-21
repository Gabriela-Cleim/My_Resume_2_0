package com.example.mycv.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycv.R;
import com.example.mycv.model.Repository;
import com.example.mycv.viewmodel.GithubReposViewModel;
import com.example.mycv.viewmodel.ReposAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GithubReposActivity extends AppCompatActivity {

    private TextView txtHourRepo;
    private RecyclerView recyclerViewRepos;
    private Button btnOpenGithub;
    private ReposAdapter adapter;
    private GithubReposViewModel viewModel;
    private ImageButton imgBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_github_repos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findId();
        dateFormat();
        buttonActions();


        recyclerViewRepos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReposAdapter(new ArrayList<>());
        recyclerViewRepos.setAdapter(adapter);


        viewModel = new ViewModelProvider(this).get(GithubReposViewModel.class);


        viewModel.getRepos().observe(this, new Observer<List<Repository>>() {
            @Override
            public void onChanged(List<Repository> repos) {
                if (repos != null) {
                    adapter.updateData(repos);
                } else {
                    Toast.makeText(GithubReposActivity.this, "Erro ao carregar repositórios", Toast.LENGTH_SHORT).show();
                }
            }
        });


        viewModel.fetchRepos("Gabriela-Cleim");


    }


    private void findId(){
        recyclerViewRepos = findViewById(R.id.recycler_view_repos);
        btnOpenGithub = findViewById(R.id.btn_open_github);
        txtHourRepo = findViewById(R.id.txt_hour_repo);
        imgBtnStart = findViewById(R.id.img_btn_start_repo);
    }

    private void buttonActions(){
        btnOpenGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Gabriela-Cleim")));
            }
        });

        imgBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GithubReposActivity.this, MainActivity.class));
            }
        });
    }

    private void dateFormat(){
        Locale locate = new Locale("pt", "BR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", locate);
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date hour = Calendar.getInstance().getTime();
                String hourFormated = simpleDateFormat.format(hour);
                txtHourRepo.setText(hourFormated);
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
    }


}