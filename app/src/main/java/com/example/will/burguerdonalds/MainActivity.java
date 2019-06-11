package com.example.will.burguerdonalds;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public fragInicio frag_inicio = new fragInicio();
    public FragCardapio fragCardapio = new FragCardapio();
    public frag_pedido fragPedido = new frag_pedido();
    public fragFinalizar frag_finalizar = new fragFinalizar();

    private int fragAtual = 0;

    public void mudaFragmento(int n){
        if(n==fragAtual) return;
        fragAtual = n;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch(n){
            case 1: {
                ft.replace(R.id.fragmento, frag_inicio);
                break;
            }
            case 2:{
                ft.replace(R.id.fragmento, fragCardapio);
                break;
            }
            case 3: {
                ft.replace(R.id.fragmento, fragPedido);
                break;
            }
            case 4: {
                ft.replace(R.id.fragmento, frag_finalizar);
                break;
            }
        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (fragAtual==3) {
            mudaFragmento(2);
            return;
        }else if (fragAtual== 2) {
            mudaFragmento(1);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mudaFragmento(1);
    }
}
