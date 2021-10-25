package com.example.task02;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends Bill {

    private double discount;

    public DiscountBill(double discount){
        /**
         * @param discount скидка в процентах, принимает значение от 0 до 100
         */
        if (discount >= 0 && discount <=100) {
            this.discount = discount;
        }
    }

    public long getPriceDiscount() {
        return (long)(super.getPrice()*this.discount/100);
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() - getPriceDiscount());
    }

    public double getPercentDiscount() {
        return this.discount/100;
    }

}
