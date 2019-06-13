package com.frnds.br.calculadorafinanceira.Desconto;

public class DescontoComposto extends Desconto {
    //COMERCIAL
    public float desconto_c(){ //correto
        float desconto = this.valor_nominal - this.valor_atual_c();
        return desconto;
    }
    public float valor_nominal_c(){ //correto
        float valor_nominal = (float) (this.valor_atual / Math.pow(1-this.taxa, this.tempo)) ;
        return valor_nominal;
    }
    public float valor_atual_c(){ //correto
        return (float) ((float) this.valor_nominal * Math.pow(1-this.taxa, this.tempo));
    }
    public float taxa_c(){ //correto
        float taxa = (float) (1 - Math.pow(this.valor_atual/ this.valor_nominal, 1/this.tempo));
        return taxa;
    }
    public float tempo_c() { //correto
        float tempo = (float) (Math.log(this.valor_atual/this.valor_nominal)/Math.log(1-this.taxa));
        return tempo;
    }
    //RACIONAL
    public float desconto_r() {
        float desconto = this.desconto_c() / (1+ (this.taxa * this.tempo));
        return desconto;
    }
    public float valor_nominal_r(){ //correto
        return (float) (this.valor_atual * Math.pow(1 + this.taxa, this.tempo));
    }
    public float valor_atual_r(){ //correto
        return (float) ((float) this.valor_nominal / Math.pow(1+this.taxa, this.tempo));
    }
    public float taxa_r(){ //correto
        return (float) (Math.pow(this.valor_nominal/ this.valor_atual, 1/this.tempo) - 1);
    }
    public float tempo_r() { //correto
        return (float) (Math.log(this.valor_nominal/this.valor_atual)/Math.log(1+ this.taxa));
    }
}
