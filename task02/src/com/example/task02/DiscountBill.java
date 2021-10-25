package com.example.task02;

public class DiscountBill extends  Bill{

    int discount;

    public DiscountBill(int discount) {
        if(discount < 0 || discount > 100)
            throw new IllegalArgumentException("discount 0..100");
        this.discount = discount;
    }
     public long getDiscountPrice() {
         return (long) (super.getPrice() * (discount / 100.0));
     }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount / 100.0));
    }
}
