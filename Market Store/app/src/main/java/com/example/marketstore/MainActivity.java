package com.example.marketstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView output = findViewById(R.id.outputText);
        final TextView infoMessage =  findViewById(R.id.message);
        final EditText turnover =  findViewById(R.id.turnoverValue);
        final EditText purchaseValue = findViewById(R.id.purchaseValue);
        final ImageView bronzeCardBtn = findViewById(R.id.bronzeCardBtn);
        final ImageView silverCardBtn = findViewById(R.id.silverCardBtn);
        final ImageView goldCardBtn = findViewById(R.id.goldCardBtn);

        final Customer firstOwner = new Customer("Sanie Mehmet","+359000000000");
        output.setVisibility(View.INVISIBLE);
        Animation messageBlinkAnim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        infoMessage.startAnimation(messageBlinkAnim);

        bronzeCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setVisibility(View.VISIBLE);
                BronzeCard bronzeCard;
                if(turnover.getText().toString().equals("") || turnover.getText()==null){
                    bronzeCard = new BronzeCard(firstOwner,0);
                }
                else{
                    bronzeCard = new BronzeCard(firstOwner,getFloatFrom(turnover));
                }
                if(purchaseValue.getText().toString().equals("") || purchaseValue.getText()==null){
                    output.setText(bronzeCard.printInfo(150));
                }
                else {
                    output.setText(bronzeCard.printInfo(getFloatFrom(purchaseValue)));
                }
            }
        });

        silverCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setVisibility(View.VISIBLE);
                SilverCard silverCard;
                if(turnover.getText().toString().equals("") || turnover.getText()==null){
                    silverCard = new SilverCard(firstOwner,600);
                }
                else{
                    silverCard = new SilverCard(firstOwner,getFloatFrom(turnover));
                }
                if(purchaseValue.getText().toString().equals("") || purchaseValue.getText()==null){
                    output.setText(silverCard.printInfo(850));
                }
                else {
                    output.setText(silverCard.printInfo(getFloatFrom(purchaseValue)));
                }
            }
        });
        goldCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setVisibility(View.VISIBLE);
                GoldCard goldCard;
                if(turnover.getText().toString().equals("") || turnover.getText()==null){
                    goldCard = new GoldCard(firstOwner,1500);
                }
                else{
                    goldCard = new GoldCard(firstOwner,getFloatFrom(turnover));
                }
                if(purchaseValue.getText().toString().equals("") || purchaseValue.getText()==null){
                    output.setText(goldCard.printInfo(1300));
                }
                else {
                    output.setText(goldCard.printInfo(getFloatFrom(purchaseValue)));
                }
            }
        });
    }
    float getFloatFrom(EditText text) {
        try {
            return NumberFormat.getInstance().parse(text.getText().toString()).floatValue();
        } catch (ParseException e) {
            return 0.0f;
        }
    }
}
