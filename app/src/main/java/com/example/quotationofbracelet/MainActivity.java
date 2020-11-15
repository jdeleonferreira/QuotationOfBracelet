package com.example.quotationofbracelet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spMaterial;
    private Spinner spPendant;
    private Spinner spMetalType;
    private Spinner spCurrency;

    private String[] materialOptions;
    private String[] pendantOptions;
    private String[] metalTypeOptions;
    private String[] currencyOptions;

    private Double TRM = 3200.00;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.lblResult);

        spMaterial = findViewById(R.id.sprMaterial);
        spPendant = findViewById(R.id.sprPendant);
        spMetalType = findViewById(R.id.sprMetalType);
        spCurrency = findViewById(R.id.sprCurrency);

        materialOptions = getResources().getStringArray(R.array.material_options);
        pendantOptions = getResources().getStringArray(R.array.pendant_options);
        metalTypeOptions = getResources().getStringArray(R.array.metal_type_options);
        currencyOptions = getResources().getStringArray(R.array.currency_options);

        spMaterial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,materialOptions));
        spPendant.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pendantOptions));
        spMetalType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,metalTypeOptions));
        spCurrency.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,currencyOptions));

    }

    public void calculate(View v){
        int material = spMaterial.getSelectedItemPosition();
        int pendant = spPendant.getSelectedItemPosition();
        int metalType = spMetalType.getSelectedItemPosition();
        Double usdPrice = 0.00;


        //Gold and Pink gold
        if(material == 0 && pendant == 0 && (metalType == 0 || metalType == 1)){
            usdPrice = 100.00;
        }else if(material == 0 && pendant == 0 && metalType == 2){ //Silver
            usdPrice = 80.00;
        }else if(material == 0 && pendant == 0 && metalType == 3){//Nickel
            usdPrice = 70.00;
        }else if(material == 0 && pendant == 1 && (metalType == 0 || metalType == 1)){
            usdPrice = 120.00;
        }else if(material == 0 && pendant == 1 && metalType == 2){ //Silver
            usdPrice = 100.00;
        }else if(material == 0 && pendant == 1 && metalType == 3){ //Nickel
            usdPrice = 90.00;
        }else  if(material == 1 && pendant == 0 && (metalType == 0 || metalType == 1)){
            usdPrice = 90.00;
        }else if(material == 1 && pendant == 0 && metalType == 2){ //Silver
            usdPrice = 70.00;
        }else if(material == 1 && pendant == 0 && metalType == 3){//Nickel
            usdPrice = 50.00;
        }else if(material == 1 && pendant == 1 && (metalType == 0 || metalType == 1)){
            usdPrice = 110.00;
        }else if(material == 1 && pendant == 1 && metalType == 2){ //Silver
            usdPrice = 90.00;
        }else if(material == 1 && pendant == 1 && metalType == 3){ //Nickel
            usdPrice = 80.00;
        }


        String result = calculatePrice(usdPrice);
        this.result.setText(result);
    }

    private String calculatePrice(Double value){
        String currency = spCurrency.getSelectedItem().toString();
        int option = spCurrency.getSelectedItemPosition();
        String price = "";
        switch (option){
            case 0:
                price = currency + " " + String.format("%.2f",value * TRM);
                break;
            case 1:
                price = currency + " " + String.format("%.2f",value);
                break;
            default:
                price  = ""+value;
        }

        return price;

    }
}