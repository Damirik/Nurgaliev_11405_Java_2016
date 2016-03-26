package Task015;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Дамир on 25.03.2016.
 */

@Controller
@RequestMapping("/process")
public class ProcessController {

    @RequestMapping(method = RequestMethod.POST)
    public String postprpcess( ModelMap modelMap, @RequestParam String operation, @RequestParam String text){



        switch (operation){
            case "paragraph":
                String [] paragraphs = text.split("\n");
                modelMap.put("result",paragraphs.length);

                break;

            case "words":
                String[] words = text.split(" ");
                modelMap.put("result", words.length);
                break;

            case "character":
                modelMap.put("result", text.length());
                break;

            case "sentences":
                String[] sentences = text.split(".");
                modelMap.put("result", sentences.length);
                break;
        }

        modelMap.put("text", text);

        return "redirect:/result";

    }



    @RequestMapping(method = RequestMethod.GET)
    public String getProcess(){
        return "process";
    }


}
