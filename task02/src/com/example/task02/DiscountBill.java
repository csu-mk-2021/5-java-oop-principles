package com.example.task02;

public class DiscountBill extends Bill{

    private float discount;

    public DiscountBill(float discount){//ноль не волнует?
        this.discount = discount;
    }

    public long getDiscountPrice() {
        if(discount>=1f)
        {
            throw new IllegalArgumentException("discount to big");
        }
        return (long) (getPrice() * (1f - discount));
    }

    public long getDiscountedSum() {
        return (getPrice() - getDiscountPrice());
    }

    public float getDiscountPercent() {
        return discount * 100;
    }

    public float getDiscount(){
        return discount;
    }
}
