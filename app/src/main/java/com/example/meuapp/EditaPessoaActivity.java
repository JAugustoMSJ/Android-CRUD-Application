package com.example.meuapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class EditaPessoaActivity extends AppCompatActivity {
    private EditText editaNomePessoa;
    private EditText editaCpfPessoa;
    private EditText editaEnderecoPessoa;
    private EditText editaDataNascPessoa;
    private EditText editaTelefonePessoa;
    private EditText editaEstadoPessoa;
    private EditText editaCidadePessoa;
    private EditText editaEmailPessoa;
    private EditText editaUsuarioPessoa;
    private EditText editaSenhaPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_pessoa);

        editaNomePessoa = findViewById(R.id.editaNomePessoa);
        editaCpfPessoa = findViewById(R.id.editaCpfPessoa);
        editaEnderecoPessoa = findViewById(R.id.editaEnderecoPessoa);
        editaDataNascPessoa = findViewById(R.id.editaDataNascPessoa);
        editaTelefonePessoa = findViewById(R.id.editaTelefonePessoa);
        editaEstadoPessoa = findViewById(R.id.editaEstadoPessoa);
        editaCidadePessoa = findViewById(R.id.editaCidadePessoa);
        editaEmailPessoa = findViewById(R.id.editaEmailPessoa);
        editaUsuarioPessoa = findViewById(R.id.editaUsuarioPessoa);
        editaSenhaPessoa = findViewById(R.id.editaSenhaPessoa);

        Bundle pessoa = getIntent().getExtras();
        editaNomePessoa.setText(pessoa.getString("nome_completo"));
        editaCpfPessoa.setText(pessoa.getString("cpf"));
        editaEnderecoPessoa.setText(pessoa.getString("endereco"));
        editaDataNascPessoa.setText(pessoa.getString("data_nasc"));
        editaTelefonePessoa.setText(pessoa.getString("telefone"));
        editaEstadoPessoa.setText(pessoa.getString("estado"));
        editaCidadePessoa.setText(pessoa.getString("cidade"));
        editaEmailPessoa.setText(pessoa.getString("email"));
        editaUsuarioPessoa.setText(pessoa.getString("usuario"));
        editaSenhaPessoa.setText(pessoa.getString("senha"));
    }
    
}