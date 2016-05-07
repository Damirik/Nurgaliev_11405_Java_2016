package ru.kpfu.itis.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Constants;
import ru.kpfu.itis.model.Users;
import ru.kpfu.itis.pojo.SumAndCount;
import ru.kpfu.itis.services.CartsService;
import ru.kpfu.itis.services.CategoriesService;

import javax.servlet.http.HttpServletRequest;


/**
 * АОП для наличия суммы и кол-ва элементов корзины в профиле
 */
@Aspect
@Component
public class AttsIncludeAspect {
    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CartsService cartsService;

    @Autowired
    HttpServletRequest request;

    @Pointcut("@annotation(ru.kpfu.itis.aspects.annotation.AttsInclude)")
    public void attsIncludeMethod() {

    }

    @Before("attsIncludeMethod()")
    public void attsInclude() {
        if (request.isUserInRole("ROLE_USER")) {
            SumAndCount sumAndCountOfCartByUserId = cartsService.getSumAndCountOfCartByUserId((Users) request.getSession().getAttribute(Constants.SESSION_USER));
            request.getSession().setAttribute(Constants.SUM_CART, sumAndCountOfCartByUserId.getSum());
            request.getSession().setAttribute(Constants.COUNT_CART, sumAndCountOfCartByUserId.getCount());
        }
    }

}
