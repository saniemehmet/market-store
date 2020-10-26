package com.example.marketstore;

import java.text.DecimalFormat;

public class SilverCard extends DiscountCard {
    SilverCard(Customer owner, float turnover) {
        super(owner, turnover);
        setDiscountRate(0.02f);
    }

    float getDiscount() {
        if(getTurnover()>300) {
            return 0.035f;
        }
        else {
            return getDiscountRate();
        }
    }

    float calculateDiscount(float purchaseValue) {
        return (purchaseValue * getDiscount());
    }

    @Override
    String printInfo(float purchaseValue) {
        return "Silver:\na.Mock data: turnover $"+getTurnover()+", purchase value $"+purchaseValue
                +"\nb.Output:\n\n* Purchase value: $"+ new DecimalFormat("#0.00").format(purchaseValue)+
                "\n* Discount rate: "+ (getDiscount()*100) +
                "%\n* Discount: $"+new DecimalFormat("#0.00").format(calculateDiscount(purchaseValue))+
                "\n* Total: $"+new DecimalFormat("#0.00").format((purchaseValue-calculateDiscount(purchaseValue)))+"\n";
    }
}
