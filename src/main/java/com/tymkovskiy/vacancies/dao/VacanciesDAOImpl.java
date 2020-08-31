package com.tymkovskiy.vacancies.dao;

import com.tymkovskiy.vacancies.model.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacanciesDAOImpl implements VacanciesDAO {

    private SessionFactory sessionFactory;
    @Value("${vacancies.per.page}")
    private int vacanciesPerPage;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Vacancy> allVacancies(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Vacancy ORDER BY id")
                .setFirstResult(vacanciesPerPage * (page - 1))
                .setMaxResults(vacanciesPerPage)
                .list();
    }

    @Override
    public void add(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(vacancy);
    }

    @Override
    public void delete(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(vacancy);
    }

    @Override
    public void update(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vacancy);
    }

    @Override
    public Vacancy getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Vacancy.class, id);
    }

    @Override
    public int vacanciesCount() {
        Session session = sessionFactory.getCurrentSession();
        int count = session.createQuery("select count (*) from Vacancy", Number.class)
                .getSingleResult()
                .intValue();
        return count;
    }
}