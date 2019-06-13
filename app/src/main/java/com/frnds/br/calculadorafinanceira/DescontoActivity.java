package com.frnds.br.calculadorafinanceira;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.frnds.br.calculadorafinanceira.Desconto.CalcularDesconto;

public class DescontoActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner sp_taxa, sp_tempo, sp_tipo, sp_tipo_rc;
    TextInputEditText valor_nominal, valor_taxa, valor_tempo, valor_atual;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto);
        init();
        calcular.setOnClickListener(this);
    }
    private void init(){
        sp_taxa = findViewById(R.id.sp_taxa_desc);
        sp_tempo = findViewById(R.id.sp_tempo_desc);
        sp_tipo = findViewById(R.id.sp_tipo_desc);
        sp_tipo_rc = findViewById(R.id.sp_rc_desc);
        valor_nominal = findViewById(R.id.ti_valor_nominl);
        valor_atual = findViewById(R.id.ti_valor_atual);
        valor_taxa = findViewById(R.id.ti_tx_juros_desc);
        valor_tempo = findViewById(R.id.ti_tempo_desc);
        calcular = findViewById(R.id.bt_cal_desc);
        ArrayAdapter<CharSequence> adapter_sc = ArrayAdapter.createFromResource(this, R.array.spinner_juros_tipo, android.R.layout.simple_spinner_item);
        adapter_sc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter_dma = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        adapter_dma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter_rc = ArrayAdapter.createFromResource(this, R.array.spinner_desconto_tipo, android.R.layout.simple_spinner_item);
        adapter_rc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_taxa.setAdapter(adapter_dma);
        sp_tempo.setAdapter(adapter_dma);
        sp_tipo.setAdapter(adapter_sc);
        sp_tipo_rc.setAdapter(adapter_rc);
        sp_taxa.setSelection(1);
        sp_tempo.setSelection(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cal_desc:
                calcular();
                default:
                    break;
        }
    }
    private boolean isEmpty(TextInputEditText et){
        if(et.getText().toString().trim().length() > 0){
            return true;
        }else{
            return false;
        }
    }
    private void calcular(){
        //0 = dia ; 1 = mes; 2 = ano
        CalcularDesconto calcularDesconto = new CalcularDesconto(DescontoActivity.this);
        float vl_nominal, vl_atual, vl_taxa, vl_tempo;
        vl_nominal = (isEmpty(valor_nominal)) ? Float.parseFloat(valor_nominal.getText().toString()) : -1;
        vl_atual = (isEmpty(valor_atual)) ? Float.parseFloat(valor_atual.getText().toString()) : -1;
        vl_taxa = (isEmpty(valor_taxa)) ? Float.parseFloat(valor_taxa.getText().toString())/100 : -1;
        vl_tempo = (isEmpty(valor_tempo)) ? Float.parseFloat(valor_tempo.getText().toString()) : -1;
        if(vl_taxa < 0 && vl_nominal >=0 && vl_atual >=0 && vl_tempo >=0){
            calcularDesconto.taxa_dt = sp_taxa.getSelectedItemPosition();
            calcularDesconto.tempo_dt = sp_tempo.getSelectedItemPosition();
            calcularDesconto.tipo = sp_tipo.getSelectedItemPosition();
            calcularDesconto.calcularTaxa(vl_nominal, vl_tempo, vl_atual);
        }else if(vl_nominal < 0 && vl_taxa >=0 && vl_atual >=0 && vl_tempo >=0){
            calcularDesconto.taxa_dt = sp_taxa.getSelectedItemPosition();
            calcularDesconto.tempo_dt = sp_tempo.getSelectedItemPosition();
            calcularDesconto.tipo = sp_tipo.getSelectedItemPosition();
            calcularDesconto.tipo_cr = sp_tipo_rc.getSelectedItemPosition();
            calcularDesconto.calcularValorNominal(vl_tempo , vl_taxa, vl_atual);
        }else if(vl_tempo < 0 && vl_taxa >=0 && vl_atual >=0 && vl_nominal >=0){
            calcularDesconto.taxa_dt = sp_taxa.getSelectedItemPosition();
            calcularDesconto.tempo_dt = sp_tempo.getSelectedItemPosition();
            calcularDesconto.tipo = sp_tipo.getSelectedItemPosition();
            calcularDesconto.tipo_cr = sp_tipo_rc.getSelectedItemPosition();
            calcularDesconto.calcularTempo(vl_nominal , vl_taxa, vl_atual);
        }else if(vl_atual < 0 && vl_taxa >=0 && vl_tempo >=0 && vl_nominal >=0){
            calcularDesconto.taxa_dt = sp_taxa.getSelectedItemPosition();
            calcularDesconto.tempo_dt = sp_tempo.getSelectedItemPosition();
            calcularDesconto.tipo = sp_tipo.getSelectedItemPosition();
            calcularDesconto.tipo_cr = sp_tipo_rc.getSelectedItemPosition();
            calcularDesconto.calcularValorAtual(vl_nominal,vl_taxa,vl_tempo);
        }else{
            calcularDesconto.erro();
        }
    }
}
