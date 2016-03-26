package Task014;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Дамир on 25.03.2016.
 */

@Controller
@RequestMapping("/getdate")
public class GetDateController {
    @RequestMapping(method = RequestMethod.GET)
    public String getdate(ModelMap model){
        model.put("date", new java.util.Date().toString());
        return "getdate";

    }
}
