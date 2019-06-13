package com.frnds.br.calculadorafinanceira.Desconto;

import android.content.Context;

import com.frnds.br.calculadorafinanceira.Dialog.DialogJuros;
import com.frnds.br.calculadorafinanceira.Juros.JurosComposto;
import com.frnds.br.calculadorafinanceira.Juros.JurosSimples;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalcularDesconto {
    private Context context;
    private DecimalFormat df = new DecimalFormat("0.00");
    public int tipo;
    public int tipo_cr;
    public int taxa_dt;
    public int tempo_dt;
    public DescontoSimples descontoSimples ;
    public DescontoComposto descontoComposto;
    DialogJuros dialogJuros;
    public CalcularDesconto(Context context){
        this.context = context;
        df.setRoundingMode(RoundingMode.UP);
    }

    private boolean isEqual(){
        if(taxa_dt == tempo_dt) {
            return true;
        }else{
            return false;
        }
    }

    public void calcularTaxa(float vl_n, float vl_tem, float vl_a){
        descontoSimples = new DescontoSimples();
        descontoComposto = new DescontoComposto();
        if(tipo == 0){
            descontoSimples.setValor_nominal(vl_n);
            descontoSimples.setValor_atual(vl_a);
            if(isEqual()){
                descontoSimples.setTempo(vl_tem);
            }else{
                descontoSimples.setTempo(convertTm(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoSimples.taxa_c()*100;
                dialogJuros = new DialogJuros(context, "Taxa : " + df.format(result)+"%");
            }else {
                float result = descontoSimples.taxa_r()*100;
                dialogJuros = new DialogJuros(context, "Taxa : " + df.format(result)+"%");
            }
        }else{
            descontoComposto.setValor_nominal(vl_n);
            descontoComposto.setValor_atual(vl_a);
            if(isEqual()){
                descontoComposto.setTempo(vl_tem);
            }else{
                descontoComposto.setTempo(convertTm(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoComposto.taxa_c();
                dialogJuros = new DialogJuros(context, "Taxa : " + df.format(result));
            }else {
                float result = descontoComposto.taxa_r();
                dialogJuros = new DialogJuros(context, "Taxa : " + df.format(result));
            }
        }

    }
    public void calcularTempo(float vl_n, float vl_tx, float vl_a){
        descontoSimples = new DescontoSimples();
        descontoComposto = new DescontoComposto();
        if(tipo == 0){
            descontoSimples.setValor_nominal(vl_n);
            descontoSimples.setValor_atual(vl_a);
            if(isEqual()){
                descontoSimples.setTaxa(vl_tx);
            }else{
                descontoSimples.setTaxa(convertTx(vl_tx));
            }
            if(tipo_cr==0){
                float result = descontoSimples.tempo_c();
                dialogJuros = new DialogJuros(context, "Tempo  : " + df.format(result));
            }else {
                float result = descontoSimples.tempo_r();
                dialogJuros = new DialogJuros(context, "Tempo : " + df.format(result));
            }
        }else{
            descontoComposto.setValor_nominal(vl_n);
            descontoComposto.setValor_atual(vl_a);
            if(isEqual()){
                descontoComposto.setTaxa(convertTm(vl_tx));
            }else{
                descontoComposto.setTaxa(vl_tx);
            }
            if(tipo_cr==0){
                float result = descontoComposto.tempo_c();
                dialogJuros = new DialogJuros(context, "Tempo : " + df.format(result));
            }else {
                float result = descontoComposto.tempo_r();
                dialogJuros = new DialogJuros(context, "Tempo : " + df.format(result));
            }
        }

    }
    public void calcularValorNominal(float vl_tem, float vl_tx, float vl_a){
        descontoSimples = new DescontoSimples();
        descontoComposto = new DescontoComposto();
        if(tipo == 0){
            descontoSimples.setTaxa(vl_tx);
            descontoSimples.setValor_atual(vl_a);
            if(isEqual()){
                descontoSimples.setTempo(vl_tem);
            }else{
                descontoSimples.setTempo(convertTx(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoSimples.valor_nominal_c();
                dialogJuros = new DialogJuros(context, "Valor nominal: " + df.format(result));
            }else {
                float result = descontoSimples.valor_nominal_r();
                dialogJuros = new DialogJuros(context, "Valor nominal: " + df.format(result));
            }
        }else{
            descontoComposto.setTaxa(vl_tx);
            descontoComposto.setValor_atual(vl_a);
            if(isEqual()){
                descontoComposto.setTempo(vl_tem);
            }else{
                descontoComposto.setTempo(convertTm(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoComposto.valor_nominal_c();
                dialogJuros = new DialogJuros(context, "Valor nominal : " + df.format(result));
            }else {
                float result = descontoComposto.valor_nominal_r();
                dialogJuros = new DialogJuros(context, "Valor nominal : " + df.format(result));
            }
        }

    }
    public void calcularValorAtual(float vl_n, float vl_tx, float vl_tem){
        descontoSimples = new DescontoSimples();
        descontoComposto = new DescontoComposto();
        if(tipo == 0){
            descontoSimples.setTaxa(vl_tx);
            descontoSimples.setValor_nominal(vl_n);
            if(isEqual()){
                descontoSimples.setTempo(vl_tem);
            }else {
                descontoSimples.setTempo(convertTm(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoSimples.valor_atual_c();
                dialogJuros = new DialogJuros(context, "Valor atual: " + df.format(result)+"\n" +
                        "Desconto: "+descontoSimples.desconto_c());
            }else {
                float result = descontoSimples.valor_atual_r();
                dialogJuros = new DialogJuros(context, "Valor atual: " + df.format(result)+ "\n" +
                        "Desconto: "+descontoSimples.desconto_r());
            }
        } else {
            descontoComposto.setTaxa(vl_tx);
            descontoComposto.setValor_nominal(vl_n);
            if(isEqual()){
                descontoComposto.setTempo(vl_tem);
            }else{
                descontoComposto.setTempo(convertTm(vl_tem));
            }
            if(tipo_cr==0){
                float result = descontoComposto.valor_atual_c();
                dialogJuros = new DialogJuros(context, "Valor atual: " + df.format(result)+"\n" +
                        "Desconto: "+descontoComposto.desconto_c());
            }else {
                float result = descontoComposto.valor_atual_r();
                dialogJuros = new DialogJuros(context, "Valor atual: " + df.format(result)+"\n" +
                        "Desconto: "+descontoComposto.desconto_r());
            }
        }

    }
    public void erro(){
        dialogJuros = new DialogJuros(context, "Erro, verifique se deixou algum campo não preenchido para exibir o resultado!");
    }

    private float convertTx(float taxa){
        if(taxa_dt == 1){
            if(tempo_dt == 0){
                return taxa/30;
            }else{
                return taxa*12;
            }
        }else if(taxa_dt == 0){
            if(tempo_dt == 1){
                return taxa*30;
            }else{
                return taxa*360;
            }
        }else{
            if(tempo_dt == 0){
                return taxa/360;
            }else{
                return taxa/12;
            }
        }
    }
    private float convertTm(float tempo){
        if(tempo_dt == 2){
            if(taxa_dt == 1){
                return tempo*12; //correto
            }else {
                return tempo*360; //correto
            }
        }else if (tempo_dt == 1){
            if(taxa_dt == 0){
                return tempo*30; //correto
            }else{
                return tempo/12; //correto
            }
        }else {
            if(taxa_dt == 1){
                return tempo/30;
            }else{
                return tempo/360;
            }
        }
    }
}
