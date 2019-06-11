package com.example.will.burguerdonalds;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragFinalizar extends Fragment {

    MainActivity activity;

    public fragFinalizar() {
        // Required empty public constructor
    }

    public void novoPedido(View v){

        try{


            activity.frag_inicio.novoPedido();
            activity.mudaFragmento(1);
        }catch (Exception e){
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_finalizar, container, false);
        activity = (MainActivity)getActivity();
        // Inflate the layout for this fragment
        TextView nome = v.findViewById(R.id.fimNome);
        TextView endereco = v.findViewById(R.id.fimEndereco);
        TextView valor = v.findViewById(R.id.fimTotal);

        nome.setText(Dados.nome);
        endereco.setText(Dados.rua + " n° " + Dados.numero + ", " + Dados.bairro + " - " + Dados.cidade);
        valor.setText("Valor total: $" + Dados.valor);

        Button btNovo = v.findViewById(R.id.btNovo);
        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoPedido(v);
            }
        });
        return v;
    }

}
