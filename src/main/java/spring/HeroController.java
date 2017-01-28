package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.HeroEntity;
import service.HeroService;

import javax.inject.Inject;

@Controller
@RequestMapping(value = "/")
public class HeroController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hi, my dear fucking friend");
        return "hello";
    }

    @RequestMapping(value="/heroes/never/die", method = RequestMethod.GET)
    public String seeMercy(ModelMap model) {
        model.addAttribute("picPath", "/resources/mirco-cabbia-mercy-witch-2-4.jpg");
        return "pic";
    }

    private HeroService heroService;

    /*
    @Autowired(required=true)
    @Qualifier(value="heroService")
    public void setHeroService(HeroService hs) {
        this.heroService = hs;
    }

    @RequestMapping(value = "/heroes", method = RequestMethod.GET)
    public String listHeroes(Model model) {
        //model.addAttribute("hero", new HeroEntity());
        model.addAttribute("listHeroes", this.heroService.listHeroes());
        return "hero";
    }
    */
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

