package com.frnds.br.calculadorafinanceira.Desconto;

public class DescontoSimples extends Desconto {
    //COMERCIAL
    public float desconto_c(){
        float desconto = this.valor_nominal * this.taxa * this.tempo;
        return desconto;
    }
    public float valor_nominal_c(){
        return  this.valor_atual / (1 - (this.taxa * this.tempo));
    }
    public float valor_atual_c(){
        float valor_atual = this.valor_nominal * (1 - this.taxa * this.tempo);
        return valor_atual;
    }
    public float taxa_c(){
        float taxa = (this.valor_nominal - this.valor_atual)/(this.valor_nominal * this.tempo);
        return taxa;
    }
    public float tempo_c() {
        float tempo = (this.valor_nominal - this.valor_atual) / (this.valor_nominal * this.taxa);
        return tempo;
    }
    //RACIONAL

    public float desconto_r() {
        return valor_nominal - valor_atual_r();
    }
    public float valor_nominal_r(){
        return this.valor_atual * (1+ this.taxa * this.tempo);
    }
    public float valor_atual_r(){
        return this.valor_nominal / (1 + this.taxa * this.tempo);
    }
    public float taxa_r(){
        return ((this.valor_nominal/this.valor_atual)-1)/this.tempo;
    }
    public float tempo_r() {
        return ((this.valor_nominal/this.valor_atual)-1)/this.taxa;
    }
}
