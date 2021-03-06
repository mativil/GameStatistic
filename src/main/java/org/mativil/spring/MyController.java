package org.mativil.spring;

import org.mativil.entity.HeroEntity;
import org.mativil.entity.LogEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.mativil.service.GenericService;
import org.mativil.service.RuntimeStatHeroService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/")
public class MyController {

    @Resource
    private GenericService<HeroEntity> heroService;

    @Resource
    private GenericService<LogEntity> logService;

    @Resource
    private RuntimeStatHeroService runtimeStatHeroService;
    /*
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        //model.addAttribute("message", "Hi, my dear friend");
        return "index";
    }
    /*

    /*Запускаем на корень*/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String heroesStat(Model model) {
        //model.addAttribute("hero", new HeroEntity());
        model.addAttribute("mapResults", this.runtimeStatHeroService.getStatisticMap());
        model.addAttribute("logsCount", this.logService.list().size());
        return "index";
    }

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public String listLogs(Model model) {
        //model.addAttribute("hero", new HeroEntity());
        model.addAttribute("listLogs", this.logService.list());
        return "logs";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        return "registration_form";
    }


    @RequestMapping(value = "/heroes", method = RequestMethod.GET)
    public String listHeroes(Model model) {
        //model.addAttribute("hero", new HeroEntity());
        // model.addAttribute("listHeroes", this.heroService.list());
        //return "heroes";
        return heroesStat(model);
    }

    @RequestMapping(value = "/heroes/{id}", method = RequestMethod.GET)
    public String heroInfo(Model model, @PathVariable("id") int id) {
        //model.addAttribute("hero", new HeroEntity());
        HeroEntity h = heroService.getById(id);
        model.addAttribute("hero", h);
        //return "heroes";
        return "heroInfo";
    }



    @RequestMapping(value="/heroes/never/die", method = RequestMethod.GET)
    public String seeMercy(ModelMap model) {
        model.addAttribute("picPath", "/resources/mirco-cabbia-mercy-witch-2-4.jpg");
        return "pic";
    }




/*
    @RequestMapping(value = "/heroes/add", method = RequestMethod.POST)
    public String addHero(@ModelAttribute("hero") HeroEntity h) {
        if (h.getId() == 0)
            this.heroService.addHero(h);
        else
            this.heroService.updateHero(h);

        return "redirect:/heroes";
    }

    @RequestMapping("/remove/{id}")
    public String removeHero(@PathVariable("id") int id) {
        this.heroService.removeHero(id);
        return "redirect:/heroes";
    }

    @RequestMapping("/edit/{id}")
    public String editHero(@PathVariable("id") int id, Model model) {
        model.addAttribute("hero", this.heroService.getHeroById(id));
        model.addAttribute("listHeroes", this.heroService.listHeroes());
        return "hero";
    }
    */
}

