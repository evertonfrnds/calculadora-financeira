package com.frnds.br.calculadorafinanceira;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.frnds.br.calculadorafinanceira.Juros.CalcularJuros;

import java.util.ArrayList;

public class JurosActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner_taxa, spinner_tempo, spinner_tipo;
    TextInputEditText valor_presente, valor_taxa, valor_tempo, valor_futuro;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros);
        init();
        calcular.setOnClickListener(this);

    }
    private void init(){
        spinner_taxa = findViewById(R.id.sp_taxa);
        spinner_tempo = findViewById(R.id.sp_tempo);
        spinner_tipo = findViewById(R.id.sp_tipo_juros);
        valor_presente = findViewById(R.id.id_jr_valor_p);
        valor_taxa = findViewById(R.id.id_tx_juros);
        valor_tempo = findViewById(R.id.id_jrs_tempo);
        valor_futuro = findViewById(R.id.id_jrs_valor_f);
        calcular = findViewById(R.id.bt_cal_juros);
        ArrayAdapter<CharSequence> adapter_dt = ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        adapter_dt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter_tipo = ArrayAdapter.createFromResource(this,R.array.spinner_juros_tipo,android.R.layout.simple_spinner_item);
        adapter_tipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tipo.setAdapter(adapter_tipo);
        spinner_taxa.setAdapter(adapter_dt);
        spinner_taxa.setSelection(1);
        spinner_tempo.setAdapter(adapter_dt);
        spinner_tempo.setSelection(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cal_juros:
                calcular();break;
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
        CalcularJuros calcularJuros = new CalcularJuros(JurosActivity.this);
        float vl_presente, vl_futuro, vl_taxa, vl_tempo;
        vl_presente = (isEmpty(valor_presente)) ? Float.parseFloat(valor_presente.getText().toString()) : -1;
        vl_futuro = (isEmpty(valor_futuro)) ? Float.parseFloat(valor_futuro.getText().toString()) : -1;
        vl_taxa = (isEmpty(valor_taxa)) ? Float.parseFloat(valor_taxa.getText().toString())/100 : -1;
        vl_tempo = (isEmpty(valor_tempo)) ? Float.parseFloat(valor_tempo.getText().toString()) : -1;
        if(vl_taxa < 0 && vl_presente >=0 && vl_futuro >=0 && vl_tempo >=0){
            calcularJuros.taxa_dt = spinner_taxa.getSelectedItemPosition();
            calcularJuros.tempo_dt = spinner_tempo.getSelectedItemPosition();
            calcularJuros.tipo = spinner_tipo.getSelectedItemPosition();
            calcularJuros.calcularTaxa(vl_presente, vl_tempo, vl_futuro);
        }else if(vl_presente < 0 && vl_taxa >=0 && vl_futuro >=0 && vl_tempo >=0){
            calcularJuros.taxa_dt = spinner_taxa.getSelectedItemPosition();
            calcularJuros.tempo_dt = spinner_tempo.getSelectedItemPosition();
            calcularJuros.tipo = spinner_tipo.getSelectedItemPosition();
            calcularJuros.calcularValorPresente(vl_tempo , vl_taxa, vl_futuro);
        }else if(vl_tempo < 0 && vl_taxa >=0 && vl_futuro >=0 && vl_presente >=0){
            calcularJuros.taxa_dt = spinner_taxa.getSelectedItemPosition();
            calcularJuros.tempo_dt = spinner_tempo.getSelectedItemPosition();
            calcularJuros.tipo = spinner_tipo.getSelectedItemPosition();
            calcularJuros.calcularTempo(vl_presente , vl_taxa, vl_futuro);
        }else if(vl_futuro < 0 && vl_taxa >=0 && vl_tempo >=0 && vl_presente >=0){
            calcularJuros.taxa_dt = spinner_taxa.getSelectedItemPosition();
            calcularJuros.tempo_dt = spinner_tempo.getSelectedItemPosition();
            calcularJuros.tipo = spinner_tipo.getSelectedItemPosition();
            calcularJuros.calcularValorFuturo(vl_presente,vl_taxa,vl_tempo);
        }else{
            calcularJuros.erro();
        }
    }

}
