package com.example.neostudy.controller;

import com.example.neostudy.entity.VacationPayData;
import com.example.neostudy.service.pay_service.ManagePayService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Validated
@RestController
public class VacationPayController {


    ManagePayService managePayService;


    @GetMapping("/calculacte")

    public ResponseEntity<?> getVacationPay(@RequestParam("averageSalary") @Min(value = 1, message = "Среднаяя зарплата должна быть больше нуля") double averageSalary,

                                            @RequestParam("vacationDays") @Min(value = 1, message = "Количество отпуска должно быть больше нуля") int vacationDays,

                                            @RequestParam(value = "startWeekend", required = false) LocalDate startWeekend,
                                            @RequestParam(value = "endWeekend", required = false) LocalDate endWeekend) {



       
        if (startWeekend != null && endWeekend != null && startWeekend.isAfter(endWeekend))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Начальная дата больше конечной");

        if (startWeekend != null && endWeekend != null) {
            if (vacationDays != (ChronoUnit.DAYS.between(startWeekend, endWeekend) + 1)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Количество дней отпуска не совпадает с количеством дней недели");
            }
        }

        VacationPayData vacationPayData = new VacationPayData(averageSalary, vacationDays, startWeekend, endWeekend);

        return ResponseEntity.ok().body(managePayService.getVacationPay(vacationPayData).getVacationPay());
    }
}


