package dz.labs.controllers;

import dz.labs.Constants;
import dz.labs.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dz.labs.aspects.annotation.CatalogInclude;


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
