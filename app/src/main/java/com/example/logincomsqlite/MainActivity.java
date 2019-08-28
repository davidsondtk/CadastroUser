package com.example.logincomsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view){
        Intent it = new Intent(MainActivity.this, Principal.class);
        startActivity(it);
    }

    public void cadastrar(View view){
        Intent it = new Intent(MainActivity.this, Cadastro.class);
        startActivity(it);
    }
}
