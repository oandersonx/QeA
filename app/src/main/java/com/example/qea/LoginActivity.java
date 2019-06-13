package com.example.qea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtSenha;
    Button btnLogin;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsuario.getText().toString();
                String password = edtSenha.getText().toString();

                if(username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuário nao inserido", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {

                    Toast.makeText(LoginActivity.this, "Senha nao inserida", Toast.LENGTH_SHORT).show();
                }else{
                    String res = db.ValidarLogin(username, password);
                    if(res.equals("")){
                        Toast.makeText(LoginActivity.this, "Login Ok", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, Perfil.class);
                        startActivity(i);



                    }else{
                        Toast.makeText(LoginActivity.this, "Login errado, tente novamente", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
