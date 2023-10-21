package com.example.smile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class TrabalhadoresAdapter extends BaseAdapter {
  private Context context;
  private List<Trabalhadores> list;

    public TrabalhadoresAdapter(Context context, List<Trabalhadores> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.trabalhadores, null);

        TextView tv = (TextView) layout.findViewById(R.id.txt_lista);
        tv.setText(list.get(position).getNOME());


        Button editardb = (Button) layout.findViewById(R.id.btn_editar);
        editardb.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Adiciona_actv.class);
                intent.putExtra("SETOR", list.get(auxPosition).getSETOR());
                intent.putExtra("NOME", list.get(auxPosition).getNOME());
                intent.putExtra("_id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletardb = (Button) layout.findViewById(R.id.btn_delete);
        deletardb.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                ControladorSQL db = new ControladorSQL(context);
                db.deletar(list.get(auxPosition));
                layout.setVisibility(View.GONE);
            }
        });

        return layout;

    }






}
