package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.aspects.annotation.AttsInclude;
import ru.kpfu.itis.aspects.annotation.CatalogInclude;
import ru.kpfu.itis.model.Users;
import ru.kpfu.itis.services.CartsService;
import ru.kpfu.itis.services.UsersService;

@Controller
public class ProfileController extends BaseController {
    @Autowired
    UsersService usersService;

    @Autowired
    CartsService cartsService;

    @AttsInclude
    @CatalogInclude
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String renderEditPage() {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        request.setAttribute(Constants.ORDERS, usersService.getUsersById(user.getId()).getOrders());
        return "pages/profile";
    }
}
