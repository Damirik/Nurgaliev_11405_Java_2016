package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.aspects.annotation.CatalogInclude;
import ru.kpfu.itis.services.CategoriesService;


@Controller
public class CollectionsController extends BaseController {

    @Autowired
    CategoriesService categoriesService;

    @CatalogInclude
    @RequestMapping(value = "/collections", method = RequestMethod.GET)
    public String renderMyCartPage() {
        request.getSession().setAttribute(Constants.COLLECTIONS, categoriesService.getAllCategories());
        return "pages/collections";
    }


}
