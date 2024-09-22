package com.example.neostudy.entity;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacationPayData {

    private double averageSalary;

    private int vacationDays;

    LocalDate startVacationDate;

    LocalDate endVacationDate;
}
