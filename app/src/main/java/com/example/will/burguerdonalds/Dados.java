package com.example.will.burguerdonalds;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.will.burguerdonalds.R;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    static List<Hamburguer> conteudo = preenche();
    static List<Hamburguer> pedido = new ArrayList<Hamburguer>();
    static String nome = "";
    static String rua = "";
    static String numero = "";
    static String bairro = "";
    static String cidade = "";
    static String valor = "";
    static boolean novo = false;

    static List<Hamburguer> preenche() {
        List<Hamburguer> ret = new ArrayList<Hamburguer>();
        {
            Hamburguer h = new Hamburguer();
            h.setNome("Hamburguer 01");
            h.setValor(15.50);
            ret.add(h);
        }

        {
            Hamburguer h = new Hamburguer();
            h.setNome("Hamburguer 02");
            h.setValor(19.20);
            ret.add(h);
        }

        {
            Hamburguer h = new Hamburguer();
            h.setNome("Hamburguer 03");
            h.setValor(17.80);
            ret.add(h);
        }

        {
            Hamburguer h = new Hamburguer();
            h.setNome("Batata Frita");
            h.setValor(5.50);
            ret.add(h);
        }

        {
            Hamburguer h = new Hamburguer();
            h.setNome("Sorvete M&Ms");
            h.setValor(9.50);
            ret.add(h);
        }

        return ret;
    }



}
