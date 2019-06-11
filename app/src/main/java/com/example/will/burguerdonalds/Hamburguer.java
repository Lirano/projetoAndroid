package com.example.will.burguerdonalds;

public class Hamburguer {

    private String nome;
    private Double valor;

    public int logo(){
        if(nome==null) return android.R.drawable.alert_dark_frame;
        if(nome.equals("Hamburguer 01")){
            return R.drawable.ham1;
        }else if(nome.equals("Hamburguer 02")){
            return R.drawable.ham2;
        }else if(nome.equals("Hamburguer 03")){
            return R.drawable.ham3;
        }else if(nome.equals("Batata Frita")){
            return R.drawable.fries;
        }else if(nome.equals("Sorvete M&Ms")){
            return R.drawable.mm;
        }
        return android.R.drawable.alert_dark_frame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "$ " + valor + " - " + nome;
    }
}
