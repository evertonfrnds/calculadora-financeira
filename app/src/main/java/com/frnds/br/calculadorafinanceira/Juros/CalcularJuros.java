package com.frnds.br.calculadorafinanceira.Juros;

import android.content.Context;
import android.widget.Toast;

import com.frnds.br.calculadorafinanceira.Dialog.DialogJuros;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalcularJuros {
    private Context context;
    private DecimalFormat df = new DecimalFormat("0.00");
    public int tipo;
    public int taxa_dt;
    public int tempo_dt;
    public JurosSimples jurosSimples ;
    public JurosComposto jurosComposto;
    DialogJuros dialogJuros;
    public CalcularJuros(Context context){
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

    public void calcularTaxa(float vl_p, float vl_tem, float vl_fut){
        jurosSimples = new JurosSimples();
        jurosComposto = new JurosComposto();
        if(tipo == 0){
            double result = 0;
            jurosSimples.setValor_presente(vl_p);
            jurosSimples.setValor_futuro(vl_fut);
            if(isEqual()){
                jurosSimples.setTempo(vl_tem);
            }else{
                jurosSimples.setTempo(convertTm(vl_tem));
            }
            result = jurosSimples.taxa()*100;
            dialogJuros = new DialogJuros(context, "Valor da Taxa : " + df.format(result)+"%");
        }else if(tipo == 1){
            double result = 0;
            jurosComposto.setValor_presente(vl_p);
            jurosComposto.setValor_futuro(vl_fut);
            if(isEqual()){
                jurosComposto.setTempo(vl_tem);
            }else{
                jurosComposto.setTempo(convertTm(vl_tem));
            }
            result = jurosComposto.taxa()*100;
            dialogJuros = new DialogJuros(context, "Valor da Taxa : " + df.format(result)+"%");
        }
    }
    public void calcularTempo(float vl_p, float vl_tx, float vl_fut){
        jurosSimples = new JurosSimples();
        jurosComposto = new JurosComposto();
        if(tipo == 0){
            float result = 0;
            jurosSimples.setValor_presente(vl_p);
            jurosSimples.setValor_futuro(vl_fut);
            jurosSimples.setTaxa(vl_tx);
            if(isEqual()){
                jurosSimples.setTaxa(vl_tx);
            }else{
                jurosSimples.setTaxa(convertTx(vl_tx));
            }
            dialogJuros = new DialogJuros(context, "Valor do tempo : " + df.format(jurosSimples.tempo()));
        }else if(tipo == 1){
            jurosComposto.setValor_presente(vl_p);
            jurosComposto.setValor_futuro(vl_fut);
            if(isEqual()){
                jurosComposto.setTaxa(vl_tx);
            }else{
                jurosComposto.setTaxa(convertTx(vl_tx));
            }
            dialogJuros = new DialogJuros(context, "Tempo : " + df.format(jurosComposto.tempo()));
        }
    }
    public void calcularValorPresente(float vl_tem, float vl_tx, float vl_fut){
        jurosSimples = new JurosSimples();
        jurosComposto = new JurosComposto();
        if(tipo == 0){
            double result = 0;
            jurosSimples.setTaxa(vl_tx);
            jurosSimples.setValor_futuro(vl_fut);
            if(isEqual()){
                jurosSimples.setTempo(vl_tem);
            }else{
                jurosSimples.setTempo(convertTm(vl_tem));
            }
            result = jurosSimples.valorPresente();
            dialogJuros = new DialogJuros(context, "Valor Presente : " + df.format(result));
        }else if(tipo == 1){
            double result = 0;
            jurosComposto.setTaxa(vl_tx);
            jurosComposto.setValor_futuro(vl_fut);
            if(isEqual()){
                jurosComposto.setTempo(vl_tem);
            }else{
                jurosComposto.setTempo(convertTm(vl_tem));
            }
            result = jurosComposto.valorPresente();
            dialogJuros = new DialogJuros(context, "Valor Presente : " + df.format(result));
        }
    }
    public void calcularValorFuturo(float vl_p, float vl_tx, float vl_tem){
        jurosSimples = new JurosSimples();
        jurosComposto = new JurosComposto();
        if(tipo == 0){
            jurosSimples.setValor_presente(vl_p);
            jurosSimples.setTaxa(vl_tx);
            if(isEqual()){
                jurosSimples.setTempo(vl_tem);
            }else{
                jurosSimples.setTempo(convertTm(vl_tem));
            }
            dialogJuros = new DialogJuros(context, "Valor Futuro : " + df.format(jurosSimples.valorFuturo())+"" +
                    "\nJuros : " +df.format(jurosSimples.juros()) );
        }else if(tipo == 1){
            jurosComposto.setValor_presente(vl_p);
            jurosComposto.setTaxa(vl_tx);
            if(isEqual()){
                jurosComposto.setTempo(vl_tem);
            }else{
                jurosComposto.setTempo(convertTm(vl_tem));
            }
            dialogJuros = new DialogJuros(context, "Valor Futuro : " + df.format(jurosComposto.valorFuturo())+"" +
                    "\nJuros : " +df.format(jurosComposto.juros()));
        }
    }
    public void erro(){
        dialogJuros = new DialogJuros(context, "Erro");
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
