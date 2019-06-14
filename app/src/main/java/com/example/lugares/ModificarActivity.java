package com.example.lugares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.lugares.data.Lugar;

import static com.example.lugares.data.ListaDatos.listaLugares;

public class ModificarActivity extends AppCompatActivity {

    EditText editNombre2;
    EditText editDescripcion2;
    EditText editLatitud2;
    EditText editLongitud2;
    RatingBar ratingBarLugar2;
    Button btnModificar;
    Button btnCancelar2;

    Lugar lugarAux;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        editNombre2 = findViewById(R.id.editNombre2);
        editDescripcion2 = findViewById(R.id.editDescripcion2);
        editLatitud2 = findViewById(R.id.editLatitud2);
        editLongitud2 = findViewById(R.id.editLongitud2);
        ratingBarLugar2 = findViewById(R.id.ratingBarLugar2);
        btnModificar = findViewById(R.id.btnModificar);
        btnCancelar2 = findViewById(R.id.btnCancelar2);

        Bundle extras = getIntent().getExtras();
        int indiceLugar = extras.getInt("lugar", 0);

        lugarAux = listaLugares.get(indiceLugar);

        editNombre2.setText(lugarAux.getNombre());
        editDescripcion2.setText(lugarAux.getDescripcion());
        editLatitud2.setText(lugarAux.getLatitud().toString());
        editLongitud2.setText(lugarAux.getLongitud().toString());
        ratingBarLugar2.setRating(lugarAux.getRatingBarLugar());


        btnModificar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean correcto = true;
                if (editNombre2.getText().toString().isEmpty())
                {
                    editNombre2.setError("No has introducido el nombre");
                    correcto = false;
                }
                if (editDescripcion2.getText().toString().isEmpty())
                {
                    editDescripcion2.setError("No has introducido la descripción");
                    correcto = false;
                }
                if (editLatitud2.getText().toString().isEmpty())
                {
                    editLatitud2.setError("No has introducido la latitud");
                    correcto = false;
                }
                if (editLongitud2.getText().toString().isEmpty())
                {
                    editLongitud2.setError("No has introducido la longitud");
                    correcto = false;
                }

                if (correcto)
                {
                    lugarAux.setNombre(editNombre2.getText().toString());
                    lugarAux.setDescripcion(editDescripcion2.getText().toString());
                    lugarAux.setLatitud(Double.parseDouble(editLatitud2.getText().toString()));
                    lugarAux.setLongitud(Double.parseDouble(editLongitud2.getText().toString()));
                    lugarAux.setRatingBarLugar(ratingBarLugar2.getRating());
                    finish();
                }
            }
        });
        btnCancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
