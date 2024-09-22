package com.example.neostudy.service.Date;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class Holydays implements DateService {

    @Override
    public int getCountFreeDay(LocalDate startDate, LocalDate endDate) {

        int countFreeDay = (int) IntStream.iterate(-1, i -> startDate.plusDays(i).isBefore(endDate), i -> i + 1)
                .mapToObj(startDate::plusDays)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();

        int rezult = countFreeDay + (int) getHolidays().stream()
                .filter(date -> date.isAfter(startDate) && date.isBefore(endDate))
                .count();

        return rezult;

    }


    private List<LocalDate> getHolidays() {

        List<LocalDate> freeDays = new ArrayList<>();
        freeDays.add(LocalDate.of(2024, 5, 10));
        freeDays.add(LocalDate.of(2024, 12, 30));
        freeDays.add(LocalDate.of(2024, 12, 31));
        return Collections.unmodifiableList(freeDays);

    }
}
