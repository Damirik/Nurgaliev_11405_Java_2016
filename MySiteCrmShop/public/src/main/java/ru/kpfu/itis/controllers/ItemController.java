package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.aspects.annotation.CatalogInclude;
import ru.kpfu.itis.model.Categories;
import ru.kpfu.itis.model.Goods;
import ru.kpfu.itis.services.CategoriesService;
import ru.kpfu.itis.services.GoodsService;
import ru.kpfu.itis.util.Methods;

import javax.mail.MessagingException;


@Controller
public class ItemController extends BaseController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoriesService categoriesService;

    @CatalogInclude
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String renderMyItemPage(@PathVariable("id") Long id) {
        Goods goodById = goodsService.getGoodById(id);
        //дерево категорий
        request.setAttribute(Constants.CATEGORY, Methods.getCategories(goodById));
        //сам предмет
        request.setAttribute(Constants.ITEM, goodById);
        //предеметы в той же категории либо выше
        request.setAttribute(Constants.LIKE, goodsService.getLikeGoods(goodById));

        return "pages/item";
    }

    @ResponseBody
    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void checkItem(Long ID, String company, String description, String name, Float price, String image) throws MessagingException {


        Categories c = new Categories(1L,request.getParameter("category"));

        Goods good = new Goods(name, price, description, company, ID, c, image);
        goodsService.addGoods(good);
    }
}
