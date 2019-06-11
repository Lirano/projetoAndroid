package com.example.will.burguerdonalds;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag_pedido extends Fragment {


    public frag_pedido() {
        // Required empty public constructor
    }

    private ListView listPedido;
    private ArrayAdapter<Hamburguer> adaptador;
    TextView lbTotal;
    MainActivity activity;

    public void tapFinalizar(View v){

        int qtd = Dados.pedido.size();
        try{
            if(Dados.nome == "" || Dados.rua == "" || Dados.numero == "" || Dados.bairro == "" || Dados.cidade == "" || qtd == 0){
                Toast.makeText(activity,"Dados ausentes e/ou pedido vazio!",Toast.LENGTH_SHORT).show();
            }
            else {
                activity.mudaFragmento(4);
            }
        }catch (Exception e){
        }
    }

    public void tapCardapioPed(View v){
        try{
            activity.mudaFragmento(2);
        }catch (Exception e){
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = (MainActivity)getActivity();
        View v = inflater.inflate(R.layout.fragment_pedido, container, false);

        listPedido = (ListView)v.findViewById(R.id.listPedido);
        lbTotal = (TextView)v.findViewById(R.id.lbTotal);

        listPedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dados.pedido.remove(position);
                atualizado();
            }
        });

        Button btCardapioPed = v.findViewById(R.id.btCardapioPed);
        btCardapioPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapCardapioPed(v);
            }
        });

        Button btFinalizar = v.findViewById(R.id.btFinalizar);
        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapFinalizar(v);
            }
        });

        adaptador = new ArrayAdapter<Hamburguer>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,Dados.pedido);
        listPedido.setAdapter(adaptador);


        atualizado();

        return v;
    }

    public void atualizado(){

        Double total = 0.00;

        for(Hamburguer h:Dados.pedido) {

            total += h.getValor();
        }

        lbTotal.setText(String.format("%.2f",total));
        adaptador.notifyDataSetChanged();
        Dados.valor = String.format("%.2f",total);
    }

}
