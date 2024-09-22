package com.example.neostudy.service.pay_service;

import com.example.neostudy.entity.RequestVacationPayData;
import com.example.neostudy.entity.VacationPayData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.neostudy.helpers.HelperData.AVERAGE_DAY_IN_MOUNTH;
import static com.example.neostudy.helpers.HelperData.NDFL;


@Service
public class SimpleVacationPay implements VacationPayService {


    @Override
    public RequestVacationPayData getVacationPay(VacationPayData vacationPayData) {

        double salary = vacationPayData.getAverageSalary() / AVERAGE_DAY_IN_MOUNTH * vacationPayData.getVacationDays();

        salary -= salary * NDFL;

        return new RequestVacationPayData(salary);
    }

}
