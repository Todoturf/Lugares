package com.example.lugares;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNombre;
    EditText editPassword;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String usuario = "Pedro";
        final String password = "1234";

        editNombre = findViewById(R.id.editNombre);
        editPassword = findViewById(R.id.editPassword);
        btnEnviar = findViewById(R.id.btnEnviar);

        SharedPreferences prefs = getSharedPreferences("misPreferencias", Context.MODE_PRIVATE);
        editNombre.setText(prefs.getString("nombre", ""));
        editPassword.setText(prefs.getString("password", ""));

        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String textoNombre = editNombre.getText().toString();
                String textoPassword = editPassword.getText().toString();
                boolean correcto = true;

                if (textoNombre.isEmpty())
                {
                    editNombre.setError("No has introducido el nombre");
                    correcto = false;
                }

                if (textoPassword.isEmpty())
                {
                    editPassword.setError("No has introducido la contraseña");
                    correcto = false;
                }

                if (textoNombre.equalsIgnoreCase(usuario) && textoPassword.equalsIgnoreCase(password))
                {
                     Intent intent = new Intent(MainActivity.this, LugaresActivity.class);
                     intent.putExtra("nombre", textoNombre);
                     startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error al introducir el usuario y/o la contraseña", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
