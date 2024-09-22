package com.example.neostudy.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVacationPayData {

    double vacationPay;

    public RequestVacationPayData(double vacationPay) {
        this.vacationPay = round(vacationPay, 2);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
