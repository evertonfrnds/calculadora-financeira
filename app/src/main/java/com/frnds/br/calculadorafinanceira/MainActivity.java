package com.frnds.br.calculadorafinanceira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CardView cv_juros, cv_desconto, cv_financiamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_juros = findViewById(R.id.cv_juros);
        cv_desconto = findViewById(R.id.cv_desconto);
        cv_financiamento = findViewById(R.id.cv_financiamento);
        cv_juros.setOnClickListener(this);
        cv_desconto.setOnClickListener(this);
        cv_financiamento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_juros:
                startActivity(new Intent(MainActivity.this, JurosActivity.class));break;
            case R.id.cv_desconto:
                startActivity(new Intent(MainActivity.this, DescontoActivity.class));break;
            case R.id.cv_financiamento:
                startActivity(new Intent(MainActivity.this, FinanciarActivity.class));break;
            default:
                break;
        }
    }
}
