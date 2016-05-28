package dz.labs.controllers;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import dz.labs.Constants;
import dz.labs.Mail;
import dz.labs.aspects.annotation.CatalogInclude;
import dz.labs.model.Users;
import dz.labs.services.UsersService;
import dz.labs.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;


@Controller
public class RegistrationController extends BaseController {
    @Autowired
    UsersService usersService;

    Mail mail;

    @PostConstruct
    public void init() {
        mail = new Mail();
    }


    @CatalogInclude
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderMyItemPage() {
        return "pages/registration";
    }

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String checkValidation(String userName, String userEmail, String userPass) throws MessagingException, javax.mail.MessagingException {
        if (usersService.checkEmail(userEmail)) {
            usersService.addUsers(userName, userEmail, userPass);
            Users user = usersService.checkLogging(userEmail, userPass);
            request.getSession().setAttribute(Constants.SESSION_USER, user);
            mail.sendHelloMessage(userName, user.getKey(), userEmail);
            return "ok";
        } else
            return "failed";
    }

    @RequestMapping(value = "/signup/key", method = RequestMethod.GET)
    public String activateAccount(String key) {
        usersService.activateAccount(key);
        return "redirect:/";
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String renderForgotPasswordPage() {
        return "pages/forgot";
    }

    @ResponseBody
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public String forgotPassword(String email) throws MessagingException, javax.mail.MessagingException {
        if (!usersService.checkEmail(email)) {
            Users userByEmail = usersService.getUserByEmail(email);
            String newPass = Methods.keyGen();
            usersService.updatePasswordOfUserById(userByEmail.getId(), newPass);
            mail.sendForgotMessage(userByEmail.getName(), newPass, email);
            return "ok";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/activation", method = RequestMethod.GET)
    public String renderActivationPage() {
        return "pages/activation";
    }

    @ResponseBody
    @RequestMapping(value = "/activation", method = RequestMethod.POST)
    public String activationAgain(String email, String pass) throws MessagingException, javax.mail.MessagingException {
        Users user = usersService.checkLogging(email, pass);
        if (user != null) {
            mail.sendActivation(user.getName(), user.getKey(), email);
            return "ok";
        } else {
            return "failed";
        }
    }
}
