package com.example.neostudy.service.pay_service;

import com.example.neostudy.entity.RequestVacationPayData;
import com.example.neostudy.entity.VacationPayData;

import java.math.BigDecimal;

public interface VacationPayService {
    RequestVacationPayData getVacationPay(VacationPayData vacationPayData);
}
