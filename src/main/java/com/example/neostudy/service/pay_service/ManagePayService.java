package com.example.neostudy.service.pay_service;

import com.example.neostudy.entity.RequestVacationPayData;
import com.example.neostudy.entity.VacationPayData;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class ManagePayService implements VacationPayService {

    SimpleVacationPay simpleVacationPay;
    VacationPayWithDate vacationPayWithDate;


    @Override
    public RequestVacationPayData getVacationPay(VacationPayData vacationPayData) {

        if (vacationPayData.getStartVacationDate() != null && vacationPayData.getEndVacationDate() != null) {
            return vacationPayWithDate.getVacationPay(vacationPayData);
        }

        return simpleVacationPay.getVacationPay(vacationPayData);
    }
}
