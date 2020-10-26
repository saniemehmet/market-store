package com.example.marketstore;

import java.text.DecimalFormat;

public class GoldCard extends DiscountCard {
    GoldCard(Customer owner, float turnover) {
        super(owner, turnover);
        setDiscountRate(0.02f);
    }

    float getDiscount() {
        if(getTurnover()<100) {
            return getDiscountRate();
        }
        else if(getTurnover()>=800) {
            return 0.1f;
        }
        else {
            return (float)(Math.floor((getTurnover()/100)+2)/100);
        }
    }

    float calculateDiscount(float purchaseValue) {
        return (purchaseValue * getDiscount());
    }

    @Override
    String printInfo(float purchaseValue) {
        return "Gold:\na.Mock data: turnover $"+getTurnover()+", purchase value $"+purchaseValue
                +"\nb.Output:\n\n* Purchase value: $"+ new DecimalFormat("#0.00").format(purchaseValue)+
                "\n* Discount rate: "+ (getDiscount()*100) +
                "%\n* Discount: $"+new DecimalFormat("#0.00").format(calculateDiscount(purchaseValue))+
                "\n* Total: $"+new DecimalFormat("#0.00").format((purchaseValue-calculateDiscount(purchaseValue)))+"\n";
    }
}
