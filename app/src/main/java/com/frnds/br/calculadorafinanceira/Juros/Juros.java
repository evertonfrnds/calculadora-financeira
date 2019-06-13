package com.frnds.br.calculadorafinanceira.Juros;

public class Juros {
    protected int tipo;
    protected float  valor_presente;
    protected float taxa;
    protected float tempo;
    protected float valor_futuro;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getValor_presente() {
        return valor_presente;
    }

    public void setValor_presente(float valor_presente) {
        this.valor_presente = valor_presente;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getValor_futuro() {
        return valor_futuro;
    }

    public void setValor_futuro(float valor_futuro) {
        this.valor_futuro = valor_futuro;
    }
}
