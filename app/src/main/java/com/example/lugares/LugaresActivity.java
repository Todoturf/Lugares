package com.example.lugares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lugares.data.Lugar;

import static com.example.lugares.data.ListaDatos.listaLugares;

public class LugaresActivity extends AppCompatActivity
{

    ListView listLugares;
    ImageButton imgMapa;
    ListadoLugaresAdapter listadoLugaresAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        GestionFichero.leerDatos(this);

        listLugares = findViewById(R.id.listLugares);
        imgMapa = findViewById(R.id.imgMapa);

    /*
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Vista de la pista desde la carretera", 43.260955, -2.022858, 5.0F));
        listaLugares.add(new Lugar("Lopetegi Baserria", "Cuadra de caballos", 43.255267, -2.023055, 2.5F));
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Entrada principal al hipódromo",43.265603, -2.024819, 4.5F));
        listaLugares.add(new Lugar("Hipódromo de San Sebastián", "Entrada a las cuadras de Bugatti",43.257660, -2.021217, 3.5F));
     */

        listadoLugaresAdapter = new ListadoLugaresAdapter(this,listaLugares);

        listLugares.setAdapter(listadoLugaresAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itAnadir:
                Intent intent = new Intent(LugaresActivity.this, AnadirActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onStart()
    {
        super.onStart();
        listadoLugaresAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GestionFichero.guardarDatos(this);
    }

}
