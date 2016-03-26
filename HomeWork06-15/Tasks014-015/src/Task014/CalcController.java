package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Дамир on 25.03.2016.
 */
@Controller

@RequestMapping("/{operation:add|mult}/{first:\\d+}/{second:\\d+}")
public class CalcController {
    @RequestMapping(method = RequestMethod.GET)
    public String hiPage(ModelMap model, @PathVariable double first, @PathVariable String operation, @PathVariable double second) {
        model.put("first", first);
        model.put("second", second);
        double result;
        switch (operation) {
            case "add":
                result = first + second;
                operation = "+";
                model.put("operation", operation);
                model.put("result", result);
                break;
            case "mult":
                result = first * second;
                model.put("operation", operation);
                model.put("result", result);
                break;

        }

        return "calc";
    }


}
