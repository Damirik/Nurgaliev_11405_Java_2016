package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.Users;
import ru.kpfu.itis.security.MyUserDetail;
import ru.kpfu.itis.services.CartsService;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.util.Methods;

import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController extends BaseController {
    @Autowired
    UsersService usersService;
    @Autowired
    CartsService cartsService;

    /**
     * При удачном логировании security
     */
    @RequestMapping(value = "/success_log", method = RequestMethod.GET)
    public String success(HttpServletResponse response) {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users myUser = user.getUserInfo();
        request.getSession().setAttribute(Constants.SESSION_USER, myUser);

        //перенос корзины из кук в бд
        String cart = Methods.getCookiesValue(request, Constants.CART);
        if (Methods.checkOfNull(cart)) {
            cartsService.toCartFromCook(myUser, cart.split(","));
        }
        Methods.deleteCookie(Constants.CART, response);
        request.getSession().setAttribute(Constants.CART_FROM_COOKIE, null);
        if (myUser.getRole().equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else {
            return "redirect:/profile";
        }
    }
}
