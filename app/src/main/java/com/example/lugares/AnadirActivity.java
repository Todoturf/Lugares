package com.example.lugares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.lugares.data.ListaDatos;
import com.example.lugares.data.Lugar;

public class AnadirActivity extends AppCompatActivity
{

    EditText editNombre;
    EditText editDescripcion;
    EditText editLatitud;
    EditText editLongitud;
    RatingBar ratingBarLugar;
    Button btnAnadir;
    Button btnCancelar;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);

        editNombre = findViewById(R.id.editNombre);
        editDescripcion = findViewById(R.id.editDescripcion);
        editLatitud = findViewById(R.id.editLatitud);
        editLongitud = findViewById(R.id.editLongitud);
        ratingBarLugar = findViewById(R.id.ratingBarLugar);
        btnAnadir = findViewById(R.id.btnAnadir);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAnadir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String textoNombre = editNombre.getText().toString();
                String textoDescripcion = editDescripcion.getText().toString();
                String textoLatitud = editLatitud.getText().toString();
                String textoLongitud = editLongitud.getText().toString();
                float ratingBarLugares = ratingBarLugar.getNumStars();
                boolean correcto = true;
                if (editNombre.getText().toString().isEmpty())
                {
                    editNombre.setError("No has introducido el nombre");
                    correcto = false;
                }
                if (editDescripcion.getText().toString().isEmpty())
                {
                    editDescripcion.setError("No has introducido la descripción");
                    correcto = false;
                }
                if (editLatitud.getText().toString().isEmpty())
                {
                    editLatitud.setError("No has introducido la latitud");
                    correcto = false;
                }
                if (editLongitud.getText().toString().isEmpty())
                {
                    editLongitud.setError("No has introducido la longitud");
                    correcto = false;
                }

                if (correcto)
                {
                    ListaDatos.listaLugares.add(new Lugar(textoNombre, textoDescripcion, Double.parseDouble(textoLatitud), Double.parseDouble(textoLongitud), ratingBarLugares));
                    finish();
                }
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
