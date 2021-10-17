package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        if (discount < 0d || discount > 1d) {
            throw new IllegalArgumentException("discount must be >= 0 and <= 1");
        }
        this.discount = discount;
    }

    public long getPriceDisc() {
        return (long)(super.getPrice()* (1d - discount));
    }

    public int getPercentDisc(){
        return (int)(discount * 100);
    }

    public long getAbsDisc(){
        return super.getPrice() - getPrice();
    }
}
