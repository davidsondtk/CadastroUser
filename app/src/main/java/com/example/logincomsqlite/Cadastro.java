package com.example.logincomsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);
    private EditText edtNome, edtEmail, edtUsuario, edtSenha, edtConfSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsuario = findViewById(R.id.editUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfSenha);
    }

    public void cancelar() {
        finish();
    }

    public void cadastrar() {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();

        if (!senha.equals(confSenha)) {
            Toast.makeText(Cadastro.this, "Senha e confirmação de senha estão diferentes", Toast.LENGTH_SHORT).show();
            edtSenha.setText(" ");
            edtConfSenha.setText(" ");
        } else {
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setSenha(senha);
            contato.setUsuario(usuario);
            helper.insertContato(contato);
            Toast.makeText(Cadastro.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
