package dz.labs.controllers;

import dz.labs.services.AddressesService;
import dz.labs.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import dz.labs.Constants;
import dz.labs.model.Addresses;
import dz.labs.model.Telephones;
import dz.labs.model.Users;
import dz.labs.services.TelephoneService;
import dz.labs.util.Methods;


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
