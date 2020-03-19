package com.kendo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kendone
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message","Hello Spring Boot");
        return "index";
    }

}
