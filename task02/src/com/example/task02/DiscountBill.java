package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("Illegal discount");
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public long getDiscountValue(){
        return (long) (super.getPrice() * (discount / 100));
    }

    @Override
    public long getPrice(){
        return super.getPrice() - getDiscountValue();
    }
}
