package dz.labs.controllers;

import dz.labs.Constants;
import dz.labs.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dz.labs.aspects.annotation.AttsInclude;
import dz.labs.aspects.annotation.CatalogInclude;
import dz.labs.model.Users;
import dz.labs.services.CartsService;

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
