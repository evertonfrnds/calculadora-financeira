package com.frnds.br.calculadorafinanceira.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;

public class DialogJuros {
    private Context context;
    private String message;

    public DialogJuros(Context context, String message){
        this.context = context;
        this.message = message;
        openDialog();
    }

    public void openDialog(){
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setTitle("Resultado")
                .setCancelable(true)
                .setPositiveButton("Ok", null)
            .show();
    }
}
