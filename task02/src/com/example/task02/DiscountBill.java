package com.example.task02;

public class DiscountBill extends Bill {
    private double discount = 0;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public long getDiscountPrice() {
        return (long) (super.getPrice() * (discount / 100.0));
    }

    @Override
    public long getPrice() {
        return super.getPrice() - getDiscountPrice();
    }
}
