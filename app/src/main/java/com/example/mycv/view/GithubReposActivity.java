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

import com.example.mycv.MainActivity;
import com.example.mycv.R;
import com.example.mycv.model.Repository;
import com.example.mycv.viewmodel.GithubReposViewModel;
import com.example.mycv.viewmodel.ReposAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GithubReposActivity extends AppCompatActivity {

    private TextView tvGithubUsername, txtHourRepo;
    private RecyclerView recyclerViewRepos;
    private Button btnOpenGithub;
    private ReposAdapter adapter;
    private GithubReposViewModel viewModel;
    private ImageButton imageButtonStart;

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



        tvGithubUsername = findViewById(R.id.tv_github_username);
        recyclerViewRepos = findViewById(R.id.recycler_view_repos);
        btnOpenGithub = findViewById(R.id.btn_open_github);
        txtHourRepo = findViewById(R.id.hour_repo);
        imageButtonStart = findViewById(R.id.img_btn_start_repo);

        tvGithubUsername.setText("Nome da Conta: Gabriela-Cleim"); // Aqui você coloca seu nome de usuário GitHub.


        imageButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GithubReposActivity.this, MainActivity.class));
            }
        });


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date hour = Calendar.getInstance().getTime();
                String hourFormated = simpleDateFormat.format(hour);
                txtHourRepo.setText(hourFormated);

                // Atualiza a cada segundo
                handler.postDelayed(this, 1000);
            }
        };

        // Inicia a primeira execução
        handler.post(runnable);


        // Configurar o RecyclerView
        recyclerViewRepos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReposAdapter(new ArrayList<>());
        recyclerViewRepos.setAdapter(adapter);

        // Inicializar o ViewModel
        viewModel = new ViewModelProvider(this).get(GithubReposViewModel.class);

        // Observar mudanças nos dados
        viewModel.getRepos().observe(this, new Observer<List<Repository>>() {
            @Override
            public void onChanged(List<Repository> repos) {
                if (repos != null) {
                    adapter.updateData(repos);  // Atualiza a lista de repositórios
                } else {
                    Toast.makeText(GithubReposActivity.this, "Erro ao carregar repositórios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Chamar a função do ViewModel para buscar os repositórios
        viewModel.fetchRepos("Gabriela-Cleim");

        // Botão para abrir GitHub
        btnOpenGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Gabriela-Cleim")));
            }
        });
    }
}