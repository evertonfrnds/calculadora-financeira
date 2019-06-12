package com.frnds.br.calculadorafinanceira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class JurosActivity extends AppCompatActivity {
    Spinner spinner_taxa, spinner_tempo, spinner_tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros);
        spinner_taxa = findViewById(R.id.sp_taxa);
        spinner_tempo = findViewById(R.id.sp_tempo);
        spinner_tipo = findViewById(R.id.sp_tipo_juros);
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
}
