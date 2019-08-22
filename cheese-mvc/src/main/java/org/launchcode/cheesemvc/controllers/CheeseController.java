package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Category;
import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;



@Controller
@RequestMapping(value = "cheese")
public class CheeseController {
    //Autowired does all the work of initializing and injecting data into the CheeseDao.
    @Autowired
    //Spring recognizes this as a CrudRepository
    CheeseDao cheeseDao;

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "My Cheeses");
        //cheeseDao.findall() is an iterable that will return all the cheeses.
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        //new Cheese() corresponds to th:object${cheese} in add.html form tag.
        //model.addAttribute(new Cheese()) creates an empty form.
        model.addAttribute(new Cheese());
        //Passes in cheese types so the page displays all available values in the select.
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    /*@ModelAttribute calls Class(Cheese) and populates all fields according to
    attributes(name, description, id, etc.) in model so names must match in model, view, and control.
    @Valid makes sure @NotNull and @Size are used to make sure inputs are valid before posting and will throw errors if not.
    Error error allows the check for errors and .hasErrors is boolean that checks for errors.
    If errors exist form will be re-rendered.
     */
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                        Errors errors, Model model, @RequestParam int categoryId) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("categories", categoryDao.findAll());
            return "cheese/add";
        }

        Category cat = categoryDao.findOne(categoryId);

            newCheese.setCategory(cat);
            //Dynamically allows user to add cheeses in add.html form.
            cheeseDao.save(newCheese);
            
            return "redirect:";
        }
    

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/remove";

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] ids){

        for(int id : ids){
            cheeseDao.deleteById(id);
        }

        return "redirect:";
    }

    @RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
    public String category(Model model, @PathVariable int categoryId) {
        model.addAttribute("cheeses", categoryDao.findOne(categoryId));
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditCheeseForm(Model model, @PathVariable int id) {

        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("cheese", cheeseDao.findOne(id));
        model.addAttribute("categories", categoryDao.findAll());


        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String processEditCheeseForm(Model model, Errors errors, @ModelAttribute @Valid Cheese cheese,
                                        @PathVariable int id){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Cheese");
            model.addAttribute("cheese", cheeseDao.findOne(id));
            model.addAttribute("categories", categoryDao.findAll());

            return "cheese/edit";
        }


        /*cheese.setCategory();
        cheese.setName();
        cheese.setDescription();
        cheeseDao.save(cheese);*/

        return "redirect:";
    }


}


