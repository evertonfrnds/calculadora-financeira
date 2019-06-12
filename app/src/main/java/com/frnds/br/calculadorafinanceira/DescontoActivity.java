package com.frnds.br.calculadorafinanceira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DescontoActivity extends AppCompatActivity {
    Spinner sp_taxa, sp_tempo, sp_tipo, sp_tipo_rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto);
        sp_taxa = findViewById(R.id.sp_taxa_desc);
        sp_tempo = findViewById(R.id.sp_tempo_desc);
        sp_tipo = findViewById(R.id.sp_tipo_desc);
        sp_tipo_rc = findViewById(R.id.sp_rc_desc);
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
}
