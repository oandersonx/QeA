package com.example.qea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    EditText edtRegistrarUsuario, edtRegistrarSenha, edtRegistrarRepitaSenha;
    Button btnRegistrar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);

        edtRegistrarUsuario = (EditText)findViewById(R.id.edtRegistrarUsuario);
        edtRegistrarSenha = (EditText)findViewById(R.id.edtRegistrarSenha);
        edtRegistrarRepitaSenha = (EditText)findViewById(R.id.edtRegistrarRepitaSenha);

        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edtRegistrarUsuario.getText().toString();
                String p1 = edtRegistrarSenha.getText().toString();
                String p2 = edtRegistrarRepitaSenha.getText().toString();

                if(username.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Usuario nao inserido", Toast.LENGTH_SHORT).show();

                }
                else if (p1.equals("") || p2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Senha nao inserida", Toast.LENGTH_SHORT).show();
                }

                else if (!p1.equals(p2)){
                    Toast.makeText(RegistrarActivity.this, "Senhas diferentes", Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.CriarUtilizador(username,p1);

                    if(res>0){
                        Toast.makeText(RegistrarActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrarActivity.this, "Registro Invalido", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
