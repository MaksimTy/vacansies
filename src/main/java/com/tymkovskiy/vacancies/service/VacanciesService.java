package com.tymkovskiy.vacancies.service;

import com.tymkovskiy.vacancies.model.Vacancy;

import java.util.List;

public interface VacanciesService {
    List<Vacancy> allVacancies(int page);

    void add(Vacancy vacancy);

    void delete(Vacancy vacancy);

    void update(Vacancy vacancy);

    Vacancy getById(int id);

    int vacanciesCount();
}
