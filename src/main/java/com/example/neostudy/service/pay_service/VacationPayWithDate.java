package com.example.neostudy.service.pay_service;

import com.example.neostudy.entity.RequestVacationPayData;
import com.example.neostudy.entity.VacationPayData;

import com.example.neostudy.service.Date.Holydays;
import com.example.neostudy.service.Date.ManagerFreeDay;
import com.example.neostudy.service.Date.Weekend;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;



import static com.example.neostudy.helpers.HelperData.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class VacationPayWithDate implements VacationPayService {

    ManagerFreeDay managerFreeDay;

    @Override
    public RequestVacationPayData getVacationPay(VacationPayData vacationPayData) {

        double rezult = vacationPayData.getAverageSalary() / AVERAGE_DAY_IN_MOUNTH * (vacationPayData.getVacationDays() - getFreeDay(vacationPayData));

        rezult -= rezult * NDFL;

        return new RequestVacationPayData(rezult);
    }

    private int getFreeDay(VacationPayData vacationPayData) {

        return managerFreeDay.managerFreeDay(vacationPayData, new Holydays())
                + managerFreeDay.managerFreeDay(vacationPayData, new Weekend());
    }

}
