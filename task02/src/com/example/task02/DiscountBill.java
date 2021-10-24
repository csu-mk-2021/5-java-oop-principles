package com.example.task02;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends Bill {

    private double discount;
    private Bill bill;

    public DiscountBill(Bill bill, double discount){
        this.discount = discount;
        this.bill = bill;
    }

    public long getPriceDiscount() {
        return (long)(this.bill.getPrice()*this.discount/100);
    }

    public long getSumDiscounted() {
        return (long)(this.bill.getPrice() - getPriceDiscount());
    }

    public double getPercentDiscount() {
        return this.discount/100;
    }

}
