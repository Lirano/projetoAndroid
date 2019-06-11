package com.example.will.burguerdonalds;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragCardapio extends Fragment {

    private ListView listaCard;
    private HamAdapter adaptador_hamburguer_h;
    private MainActivity activity;


    public FragCardapio() {
        // Required empty public constructor
    }

    public void tapPedido(View v){
        try{
            activity.mudaFragmento(3);
        }catch (Exception e){
        }
    }

    public void tapDados(View v){
        try{
            activity.mudaFragmento(1);
        }catch (Exception e){
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cardapio, container, false);
        activity = (MainActivity)getActivity();
        Button btDados = v.findViewById(R.id.btDados);
        btDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDados(v);
            }
        });

        Button btPedido = v.findViewById(R.id.btPedido);
        btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapPedido(v);
            }
        });

        listaCard = v.findViewById(R.id.listaCard);

        listaCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hamburguer h = Dados.conteudo.get(position);
                Dados.pedido.add(h);
            }
        });

        adaptador_hamburguer_h = new HamAdapter(getActivity(), Dados.conteudo);

        listaCard.setAdapter(adaptador_hamburguer_h);
        return v;
    }

        private class HamAdapter extends ArrayAdapter<Hamburguer>{
            private Context ctx;
            private List<Hamburguer> conteudo;
            private static final int layout = R.layout.celular_cardapio;

            public HamAdapter(Context ctx, List<Hamburguer> conteudo){
                super(ctx, layout, conteudo);
                this.ctx = ctx;
                this.conteudo = conteudo;
            }

            public View getView(int position, View convertView, ViewGroup parent){
                HamHolder holder = null;
                if(convertView==null){
                    LayoutInflater li = LayoutInflater.from(ctx);
                    convertView = li.inflate(layout,null);
                    holder = new HamHolder();
                    holder.lblNome = convertView.findViewById(R.id.lblNome);
                    holder.lblPreco = convertView.findViewById(R.id.lblPreco);
                    holder.imgProd = convertView.findViewById(R.id.imgProd);
                    convertView.setTag(holder);
                }else{
                    holder = (HamHolder)convertView.getTag();
                }

                Hamburguer h = conteudo.get(position);
                holder.lblNome.setText(h.getNome());
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String valorString = formatter.format(h.getValor());
                holder.lblPreco.setText(valorString);
                holder.imgProd.setImageResource(h.logo());
                return convertView;
            }

        }

        public static class HamHolder{
            public TextView lblNome, lblPreco;
            public ImageView imgProd;
        }

}
