package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDao;
import com.example.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITLE = "Novo Aluno";
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    final AlunoDao alunoDao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITLE);
        inicializa();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salva(criaAluno());
            }

        });
    }

    private void inicializa() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_Telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno aluno) {
        alunoDao.salva(aluno);
        finish();
    }

    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }

}