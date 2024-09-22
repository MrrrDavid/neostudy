package com.example.neostudy.service.Date;


import com.example.neostudy.entity.VacationPayData;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@Service
public class ManagerFreeDay {
    public int managerFreeDay(VacationPayData vacationPayData, DateService dateService) {

        return dateService.getCountFreeDay(vacationPayData.getStartVacationDate(),
                vacationPayData.getEndVacationDate());
    }
}
