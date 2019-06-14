package com.example.lugares;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lugares.data.Lugar;

import java.util.ArrayList;

public class ListadoLugaresAdapter  extends ArrayAdapter<Lugar>
{
    private ArrayList<Lugar> listaLugares;
    private Context context;

    public ListadoLugaresAdapter(Context context,
                                 ArrayList<Lugar> listaLugaresArrayList)
    {
        super(context, R.layout.activity_main, listaLugaresArrayList);
        this.context = context;
        this.listaLugares = listaLugaresArrayList;
    }

        /**
         * Método que se ejecuta una vez por cada elemento de la lista
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
    public View getView(final int position,
                        View convertView,
                        ViewGroup parent)
    {

            //variable nota guardamos los datos de la nota que se muestra en este item
        final Lugar lugar = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lugar,
                        parent,
                        false);
        }
        TextView txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
        TextView txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
        RatingBar ratingBarLugares = convertView.findViewById(R.id.ratingBarLugares);
        ImageButton imgMapa = convertView.findViewById(R.id.imgMapa);
        ImageButton imgModificar = convertView.findViewById(R.id.imgModificar);
        ImageButton imgBorrar = convertView.findViewById(R.id.imgBorrar);
        
        txtNombre.setText(lugar.getNombre());
        txtDescripcion.setText(lugar.getDescripcion());
        ratingBarLugares.setRating(lugar.getRatingBarLugar());

        imgMapa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context,  MapaActivity.class);
                intent.putExtra("latitud", listaLugares.get(position).getLatitud());
                intent.putExtra("longitud", listaLugares.get(position).getLongitud());
                intent.putExtra("nombre", listaLugares.get(position).getNombre());
                intent.putExtra("descripcion", listaLugares.get(position).getDescripcion());
                context.startActivity(intent);
            }

        });

        imgBorrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                createSimpleDialog(position).show();
            }
        });

        imgModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ModificarActivity.class);
                intent.putExtra(("lugar"), position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    public AlertDialog createSimpleDialog (final int position)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Atención")
                .setMessage("¿Seguro que desea eliminar esta nota?")
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // Eliminar nota
                        listaLugares.remove(position);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //cancelar operacion
                    }
                });
        return builder.create();
    }
}