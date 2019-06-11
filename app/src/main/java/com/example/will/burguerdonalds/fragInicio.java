package com.example.will.burguerdonalds;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragInicio extends Fragment {

    private View v;

    private EditText nome;
    private EditText rua;
    private EditText numero;
    private EditText bairro;
    private EditText cidade;


    private MainActivity activity;

    public fragInicio() {
        // Required empty public constructor
    }

    public void tapAcessar(View v){
        try{
            activity.mudaFragmento(2);
        }catch (Exception e){
        }
    }

    public void novoPedido() {
        Dados.nome = "";
        Dados.rua = "";
        Dados.numero = "";
        Dados.bairro = "";
        Dados.cidade = "";
        Dados.valor = "";
        nome.setText(Dados.nome);
        rua.setText(Dados.rua);
        numero.setText(Dados.numero);
        bairro.setText(Dados.bairro);
        cidade.setText(Dados.cidade);
        Dados.pedido.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (v==null) {
            v = inflater.inflate(R.layout.fragment_inicio, container, false);

            activity = (MainActivity) getActivity();

            nome = v.findViewById(R.id.txtNome);
            rua = v.findViewById(R.id.txtRua);
            numero = v.findViewById(R.id.txtNumero);
            bairro = v.findViewById(R.id.txtBairro);
            cidade = v.findViewById(R.id.txtCidade);


            Button btAcessar = v.findViewById(R.id.btAcessar);
            btAcessar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dados.nome = nome.getText().toString();
                    Dados.rua = rua.getText().toString();
                    Dados.numero = numero.getText().toString();
                    Dados.bairro = bairro.getText().toString();
                    Dados.cidade = cidade.getText().toString();
                    //novoPedido();
                    tapAcessar(v);
                }
            });

            ImageView logo = v.findViewById(R.id.logo_inicio);
            logo.setImageResource(R.drawable.logo_bd);
        } else {
            v.invalidate();
        }
        return v;
    }

}
