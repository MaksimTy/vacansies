package com.tymkovskiy.vacancies.dao;

import com.tymkovskiy.vacancies.model.Vacancy;

import java.sql.Date;
import java.util.List;

public interface VacanciesDAO {

    List<Vacancy> allVacancies(int page);

    void add(Vacancy vacancy);

    void delete(Vacancy vacancy);

    void update(Vacancy vacancy);

    Vacancy getById(int id);

    int vacanciesCount();

    List<Vacancy> filter(
            int page,
            String company,
            String vacancy,
            Date requestFrom,
            Date requestTo,
            Date responseFrom,
            Date responseTo);
}
