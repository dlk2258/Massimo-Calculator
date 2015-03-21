package com.Massimo.Calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MyActivity extends Activity {
    private EditText aField, bField, nField;
    private Button OkButton;
    private String aString, bString, nString, toastString, numeric = "Numeric", formula = "Formula";
    private int n;
    private boolean numOrForm;
    private double[] factor = new double[10];
    private double a, b;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        aField = (EditText) findViewById(R.id.aField);
        bField = (EditText) findViewById(R.id.bField);
        nField = (EditText) findViewById(R.id.nField);
        OkButton = (Button) findViewById(R.id.DaButton);

        new AlertDialog.Builder(this)
                .setTitle("Type")
                .setMessage("Numeric or Formula answer?")
                .setPositiveButton(numeric, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        numOrForm = false;
                    }
                })
                .setNegativeButton(formula, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        numOrForm = true;
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        OkButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (numOrForm == false) {
                    aString = aField.getText().toString();
                    bString = bField.getText().toString();
                    nString = nField.getText().toString();

                    a = Integer.parseInt(aString);
                    b = Integer.parseInt(bString);
                    n = Integer.parseInt(nString);

                    if (n == 2) {

                        factor[0] = Math.pow(a, n);
                        factor[1] = n * a * b;
                        factor[2] = Math.pow(b, n);

                        toastString = "Your result is: " + factor[0] + " + " + factor[1] + " + " + factor[2];
                        Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();

                    } else if (n == 3) {
                        factor[0] = Math.pow(a, n);
                        factor[1] = n * (Math.pow(a, 2)) * b;
                        factor[2] = n * a * (Math.pow(a, 2));
                        factor[3] = Math.pow(b, n);

                        toastString = "Your result is: " + factor[0] + " + " + factor[1] + " + " + factor[2] + " + " + factor[3];
                        Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
                    }
                }
                if (numOrForm == true) {
                    aString = aField.getText().toString();
                    bString = bField.getText().toString();
                    nString = nField.getText().toString();

                    n = Integer.parseInt(nString);

                    if (n == 2) {
                        toastString = "Your result is: " + aString + "^2" + " " + "+" + " " + "2" + aString + bString + " " + " + " + bString + "^2";
                        Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
                    } else if (n == 3) {
                        toastString = "Your result is: " + aString + "^3" + " " + "+" + " " + "3" + aString + "^2" + bString + " " + "+" + "3" + aString + bString + "^2" + " + " + bString + "^3";
                        Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}










