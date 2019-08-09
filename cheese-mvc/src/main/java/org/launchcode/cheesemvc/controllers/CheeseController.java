package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {
    //List accessible to all methods.
    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model){

        /*cheeses.add added cheeses to cheeses ArrayList.
        cheeses.add("American");
        cheeses.add("Cheddar");
        cheeses.add("Mozzarella");*/
        //model passes data into view.

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    //@RequestParam String cheeseName is getting parameter info in form named cheeseName in add.html.
    public String processAddCheeseForm(@RequestParam String cheeseName){
        //Dynamically allows user to add cheeses using cheeseName in add.html form.
        cheeses.add(cheeseName);
        return "redirect:";
    }
}

