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
@RequestMapping("/search/{search:bing|baidu|yahoo|aol}")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String serach(ModelMap modelMap, @PathVariable String search) {

        switch (search) {
            case "bing":
                modelMap.put("form", "<form action=\"https://bing.com/search/\">\n" +
                        "    <input type=\"text\" name = \"q\"/>\n" +
                        "    <input type=\"submit\" value=\"bing.com\"/>\n" +
                        "</form><br>" );
                break;

            case "baidu":
                modelMap.put("form", "<form action=\"https://baidu.com/s/\">\n" +
                        "    <input type=\"text\" name = \"dd\"/>\n" +
                        "    <input type=\"submit\" value=\"baidu.com\"/>\n" +
                        "    </form>");
                break;

            case "yahoo":
                modelMap.put("form", "<form action=\"https://search.yahoo.com/search/\">\n" +
                        "    <input type=\"text\" name = \"p\"/>\n" +
                        "    <input type=\"submit\" value=\"yahoo.com\"/>\n" +
                        "</form>");
                break;

            case "aol":
                modelMap.put("form", "<form action=\"http://search.aol.com/aol/search/\">\n" +
                        "    <input type=\"text\" name = \"q\"/>\n" +
                        "    <input type=\"submit\" value=\" aol.com\"/>\n" +
                        "</form>");
                break;

        }

        return "search";

    }
}
