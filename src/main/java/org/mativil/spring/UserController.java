package org.mativil.spring;

import org.mativil.dto.UserRegistrationDTO;
import org.mativil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Ivan on 05.02.2017.
 */
@Controller
public class UserController {

    @Resource
    UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("registration_form", "user", new UserRegistrationDTO());
    }

    @RequestMapping(value = "/register_me", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute UserRegistrationDTO dto)
    {
        service.registerUser(dto);

        return new ModelAndView("registration_form", "user", dto);
    }

}
