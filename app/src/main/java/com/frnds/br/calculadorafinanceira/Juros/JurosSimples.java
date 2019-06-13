package com.frnds.br.calculadorafinanceira.Juros;

public class JurosSimples extends Juros {
    public double valorPresente(){
        double valor_presente = this.valor_futuro / (1 + (this.taxa*this.tempo));
        return valor_presente;
    }
    public double valorFuturo(){
        double montante = this.valor_presente * (1 + (this.taxa*this.tempo));
        return montante;
    }
    public double taxa(){
        double taxa = (this.valor_futuro-this.valor_presente)/(this.valor_presente * this.tempo);
        return taxa;
    }
    public double juros(){
        double juros = this.valorFuturo() - this.valor_presente;
        return juros;
    }
    public double tempo(){
        float tempo = (this.valor_futuro-this.valor_presente)/(this.valor_presente * this.taxa);
        return tempo;
    }
}
