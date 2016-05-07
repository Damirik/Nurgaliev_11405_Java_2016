package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.Addresses;
import ru.kpfu.itis.model.Telephones;
import ru.kpfu.itis.model.Users;
import ru.kpfu.itis.services.AddressesService;
import ru.kpfu.itis.services.TelephoneService;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.util.Methods;


@Controller
public class AccountEditController extends BaseController {
    @Autowired
    UsersService usersService;
    @Autowired
    TelephoneService telephoneService;
    @Autowired
    AddressesService addressesService;


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String renderEditPage() {
        return "pages/accountEdit";
    }


    /**
     * Приходят параметры, проверяем, пусты или не пусты
     * Не пустые соответствующе обрабатываем
     */
    @ResponseBody
    @RequestMapping(value = "/edit_name", method = RequestMethod.POST)
    public String updateUsersName( String userEditName) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        usersService.updateNameOfUserById(user.getId(), userEditName);
        request.getSession().setAttribute(Constants.SESSION_USER, usersService.getUsersById(user.getId()));
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_avatar", method = RequestMethod.POST)
    public String updateUsersAvatar(String userEditAvatar) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        usersService.updateAvatarOfUserById(user.getId(), userEditAvatar);
        request.getSession().setAttribute(Constants.SESSION_USER, usersService.getUsersById(user.getId()));
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_telephone", method = RequestMethod.POST)
    public String addUsersTelephone(String userEditTelephone) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        telephoneService.addTelephone(new Telephones(userEditTelephone, user));
        request.getSession().setAttribute(Constants.SESSION_USER, usersService.getUsersById(user.getId()));
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_address", method = RequestMethod.POST)
    public String addUsersAddress(String userEditAddress) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        addressesService.addAddresses(new Addresses(userEditAddress, user));
        request.getSession().setAttribute(Constants.SESSION_USER, usersService.getUsersById(user.getId()));
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/edit_pass", method = RequestMethod.POST)
    public String updateUsersPass(String userEditOldPass, String userEditNewPass) {
        Users user = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        if (Methods.checkNotNullPasswords(userEditOldPass, userEditNewPass)) {
            if (Methods.passToHash(userEditOldPass).equals(user.getHash_pass())) {
                usersService.updatePasswordOfUserById(user.getId(), userEditNewPass);
                request.getSession().setAttribute(Constants.SESSION_USER, usersService.getUsersById(user.getId()));
                return "ok";
            }
        }
        return "false";
    }



}
