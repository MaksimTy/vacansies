package com.tymkovskiy.vacancies.service;

import com.tymkovskiy.vacancies.dao.VacanciesDAO;
import com.tymkovskiy.vacancies.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacanciesServiceImpl implements VacanciesService {

    private VacanciesDAO vacanciesDAO;

    @Autowired
    public void setVacanciesDAO(VacanciesDAO vacanciesDAO) {
        this.vacanciesDAO = vacanciesDAO;
    }

    @Override
    @Transactional
    public List<Vacancy> allVacancies(int page) {
        return vacanciesDAO.allVacancies(page);
    }

    @Override
    @Transactional
    public void add(Vacancy vacancy) {
        vacanciesDAO.add(vacancy);
    }

    @Override
    @Transactional
    public void delete(Vacancy vacancy) {
        vacanciesDAO.delete(vacancy);
    }

    @Override
    @Transactional
    public void update(Vacancy vacancy) {
        vacanciesDAO.update(vacancy);
    }

    @Override
    @Transactional
    public Vacancy getById(int id) {
        return vacanciesDAO.getById(id);
    }

    @Override
    @Transactional
    public int vacanciesCount() {
        return vacanciesDAO.vacanciesCount();
    }
}