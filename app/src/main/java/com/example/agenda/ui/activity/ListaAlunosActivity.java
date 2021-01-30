package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITLE = "Lista de alunos";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITLE);

        configuraFabNovoAluno();

    }

    private void configuraFabNovoAluno() {
        FloatingActionButton fabNew = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        fabNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormAluno();
            }
        });
    }

    private void abreFormAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        AlunoDao alunoDao = new AlunoDao();

        ListView listaAlunos = findViewById(R.id.activity_lista_de_alunos_listView);
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunoDao.getAlunos()));

    }
}
