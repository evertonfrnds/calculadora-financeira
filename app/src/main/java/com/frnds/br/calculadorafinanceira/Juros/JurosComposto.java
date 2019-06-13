package com.frnds.br.calculadorafinanceira.Juros;

import android.util.Log;

public class JurosComposto  extends Juros{
    public double valorPresente(){ //correto
        double valor_presente = (float) (this.valor_futuro / (Math.pow(1+this.taxa, this.tempo)));
        return valor_presente;
    }
    public double valorFuturo(){ //correto
        double montante =  this.valor_presente * Math.pow(1+this.taxa, this.tempo);
        return montante;
    }
    public double taxa(){
        double taxa = (float) Math.pow(this.valor_futuro/this.valor_presente,1/this.tempo)-1;
        return taxa;
    }
    public double juros(){
        double juros = this.valorFuturo() - this.valor_presente;
        return juros;
    }
    public double tempo(){
        double a = this.valor_futuro/this.valor_presente;
        double b = 1 + this.taxa;
        double tempo =  Math.log(a)/Math.log(b);
        Log.d("teste", String.valueOf(a));
        Log.d("teste", String.valueOf(b));

        Log.d("teste", String.valueOf(Math.log(a)));
        Log.d("teste", String.valueOf(Math.log(b)));

        Log.d("teste", String.valueOf(tempo));

        Log.d("teste", String.valueOf(this.taxa));
        Log.d("teste", String.valueOf(this.valor_futuro));
        Log.d("teste", String.valueOf(this.valor_presente));
        return tempo;
    }
}
