package com.example.neostudy.service.Date;

import java.time.LocalDate;


public interface DateService {

    int getCountFreeDay(LocalDate startDate, LocalDate endDate);

}
