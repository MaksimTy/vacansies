package com.tymkovskiy.vacancies.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mail")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "company")
    private String company;
    @Column(name = "vacancy")
    private String vacancy;
    @Column(name = "mail")
    private String mail;
    @Column(name = "mail_date")
    private Date requestDate;
    @Column(name = "text")
    private String text;
    @Column(name = "answer")
    private String answer;
    @Column(name = "vacancy_linc")
    private String vacancyLink;
    @Column(name = "answer_date")
    private Date responseDate;

    public Vacancy(int id,
                   String company,
                   String vacancy,
                   String mail,
                   Date requestDate,
                   String text,
                   String answer,
                   String vacancyLink,
                   Date responseDate) {
        this.id = id;
        this.company = company;
        this.vacancy = vacancy;
        this.mail = mail;
        this.requestDate = requestDate;
        this.text = text;
        this.answer = answer;
        this.vacancyLink = vacancyLink;
        this.responseDate = responseDate;
    }

    public Vacancy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getVacancyLink() {
        return vacancyLink;
    }

    public void setVacancyLink(String vacancyLink) {
        this.vacancyLink = vacancyLink;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        if(responseDate == null)
            this.requestDate = null;
        this.responseDate = responseDate;
    }



    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", mail='" + mail + '\'' +
                ", mailDate='" + requestDate + '\'' +
                ", text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                ", vacancyLink='" + vacancyLink + '\'' +
                ", answerDate='" + responseDate + '\'' +
                '}';
    }
}