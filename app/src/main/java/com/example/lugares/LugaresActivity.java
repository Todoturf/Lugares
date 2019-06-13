package com.example.lugares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lugares.data.Lugar;

import static com.example.lugares.data.ListaDatos.listaLugares;

public class LugaresActivity extends AppCompatActivity
{

    ListView listLugares;
    //ImageButton imgMapa;
    ListadoLugaresAdapter listadoLugaresAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        listLugares = findViewById(R.id.listLugares);
       // imgMapa = findViewById(R.id.imgMapa);
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Vista de la pista desde la carretera", 43.260955, -2.022858, 5.0F));
        listaLugares.add(new Lugar("Lopetegi Baserria", "Cuadra de caballos", 43.255267, -2.023055, 2.5F));
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Entrada principal al hipódromo",43.265603, -2.024819, 4.5F));
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Entrada a las cuadras de Bugatti",43.257660, -2.021217, 3.5F));
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Curva del Bugatti", 43.259157, -2.021915, 1F));

        listadoLugaresAdapter = new ListadoLugaresAdapter(this,listaLugares);

        listLugares.setAdapter(listadoLugaresAdapter);



    }
}
