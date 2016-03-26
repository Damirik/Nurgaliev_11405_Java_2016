package Task015;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Дамир on 25.03.2016.
 */
@Controller
@RequestMapping("/result")
public class ResultController {
    @RequestMapping(method = RequestMethod.GET)
    public String getResult(ModelMap modelMap, @RequestParam String result) {
        modelMap.get("result");
        modelMap.put("result", result);
        return "result";

    }
}
