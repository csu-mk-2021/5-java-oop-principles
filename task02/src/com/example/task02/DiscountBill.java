package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    /**
     * Конструктор списка покупок со скидкой
     *
     * @param discount [0...100] - скидка в процентах
     */
    public DiscountBill(double discount) {
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("discount = [0, 100]");
        this.discount = discount;
    }

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
