package com.frnds.br.calculadorafinanceira.Desconto;

public class Desconto {
    protected int tipo;
    protected float valor_nominal;
    protected float taxa;
    protected float tempo;
    protected float valor_atual;
    protected float desconto;
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getValor_nominal() {
        return valor_nominal;
    }

    public void setValor_nominal(float valor_nominal) {
        this.valor_nominal = valor_nominal;
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

    public float getValor_atual() {
        return valor_atual;
    }

    public void setValor_atual(float valor_atual) {
        this.valor_atual = valor_atual;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
