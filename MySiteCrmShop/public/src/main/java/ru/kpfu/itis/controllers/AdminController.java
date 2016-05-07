package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.services.UsersService;


@Controller
public class AdminController extends BaseController {
    @Autowired
    UsersService usersService;
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String visitAdmin() {
        return "pages/admin";
    }
}
