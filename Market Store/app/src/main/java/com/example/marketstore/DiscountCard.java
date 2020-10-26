package com.example.marketstore;

public abstract class DiscountCard {
    private Customer owner;
    private float turnover, discountRate;

    DiscountCard(Customer owner, float turnover, float discountRate){
        this.owner = owner;
        this.turnover = turnover;
        this.discountRate = discountRate;
    }

    DiscountCard(Customer owner, float turnover){
        this.owner = owner;
        this.turnover = turnover;
    }

    abstract float getDiscount();
    abstract float calculateDiscount(float purchaseValue);
    abstract String printInfo(float purchaseValue);

    public float getTurnover() {
        return turnover;
    }

    public void setTurnover(float turnover) {
        if (turnover < 0) {
            throw new IllegalArgumentException("Turnover cannot be negative.");
        }
        this.turnover = turnover;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        if (discountRate < 0) {
            throw new IllegalArgumentException("Discount rate cannot be negative.");
        }
        this.discountRate = discountRate;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null.");
        }
        this.owner = owner;
    }
}
