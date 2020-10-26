package com.example.marketstore;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;

public class BronzeCard extends DiscountCard {

    BronzeCard(Customer owner, float turnover) {
        super(owner, turnover);
        setDiscountRate(0f);
    }

    float getDiscount() {
        if(getTurnover()<100) {
            return getDiscountRate();
        }
        else if(getTurnover()>=100 && getTurnover() <=300) {
            return 0.01f;
        }
        else {
            return 0.025f;
        }
    }

    float calculateDiscount(float purchaseValue) {
        return (purchaseValue * getDiscount());
    }

    @Override
    String printInfo(float purchaseValue) {
        return "Bronze:\na.Mock data: turnover $"+getTurnover()+", purchase value $"+purchaseValue
        +"\nb.Output:\n\n* Purchase value: $"+ new DecimalFormat("#0.00").format(purchaseValue)+
                "\n* Discount rate: "+ (getDiscount()*100) +
                "%\n* Discount: $"+new DecimalFormat("#0.00").format(calculateDiscount(purchaseValue))+
                "\n* Total: $"+new DecimalFormat("#0.00").format((purchaseValue-calculateDiscount(purchaseValue)))+"\n";
    }

}
