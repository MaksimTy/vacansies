package com.tymkovskiy.vacancies.controller;

import com.tymkovskiy.vacancies.model.Vacancy;
import com.tymkovskiy.vacancies.service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VacanciesController {

    private VacanciesService vacanciesService;
    private int page;
    @Value("${vacancies.per.page}")
    private int vacanciesPerPage;

    @Autowired
    public void setVacanciesService(VacanciesService vacanciesService) {
        this.vacanciesService = vacanciesService;
    }

    @GetMapping("/")
    public ModelAndView allVacancies(@RequestParam(defaultValue = "1") int page) {
        List<Vacancy> vacancies = vacanciesService.allVacancies(page);
        int vacanciesCount = vacanciesService.vacanciesCount();
        int pagesCount = (vacanciesCount + vacanciesPerPage-1) / vacanciesPerPage;
        ModelAndView modelAndView = new ModelAndView("allVacancies");
        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("page", page);
        modelAndView.addObject("vacanciesCount", vacanciesCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Vacancy vacancy = vacanciesService.getById(id);
        ModelAndView modelAndView = new ModelAndView("editVacancy");
        modelAndView.addObject("vacancy", vacancy);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editVacancy(@ModelAttribute("vacancy") Vacancy vacancy) {
        ModelAndView modelAndView = new ModelAndView("redirect:/?page=" + this.page);
        vacanciesService.update(vacancy);
        return modelAndView;
    }

    @GetMapping("/add")
    private ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView("editVacancy");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addVacancy(@ModelAttribute("vacancy") Vacancy vacancy) {
        ModelAndView modelAndView = new ModelAndView("redirect:/?page=" + this.page);
        vacanciesService.add(vacancy);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteVacancy(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/?page=" + this.page);
        vacanciesService.delete(vacanciesService.getById(id));
        return modelAndView;
    }
}