package com.tymkovskiy.vacancies.dao;

import com.tymkovskiy.vacancies.model.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Vacancy> filter(
            String company,
            String vacancy,
            Date requestFrom,
            Date requestTo,
            Date responseFrom,
            Date responseTo) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder query = new StringBuilder("from Vacancy WHERE");
        if (company != null || !company.isEmpty())
            query.append(String.format(" LOWER(company) LIKE LOWER('%%%s%%')", company));
        if (company != null || !company.isEmpty())
            query.append(String.format(" AND LOWER(vacancy) LIKE LOWER('%%%s%%')", vacancy));
        if (requestFrom != null)
            query.append(String.format(" AND mail_date >= '%s'", requestFrom.toString()));
        if (requestTo != null)
            query.append(String.format(" AND mail_date <= '%s'", requestTo.toString()));
        if (responseFrom != null)
            query.append(String.format(" AND answer_date >= '%s'", responseFrom.toString()));
        if (responseTo != null)
            query.append(String.format(" AND answer_date <= '%s'", responseTo.toString()));
        query.append(" ORDER BY id");
        return session
                .createQuery(query.toString())
                .list();
    }
}