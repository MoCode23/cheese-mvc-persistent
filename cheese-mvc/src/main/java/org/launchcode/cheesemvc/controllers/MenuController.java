package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.Menu;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.launchcode.cheesemvc.models.data.MenuDao;
import org.launchcode.cheesemvc.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;



@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Menus");
        model.addAttribute("menus", menuDao.findAll());

        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu newMenu,
                      Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";
        }

        menuDao.save(newMenu);
        return "redirect:view/" + newMenu.getId();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int id) {

        Menu menu = menuDao.findOne(id);

        model.addAttribute("title", menu.getName());
        model.addAttribute("menu", menu);
        return "menu/view";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int menuId) {

        Menu menu = menuDao.findOne(menuId);

        AddMenuItemForm itemForm = new AddMenuItemForm(menu, cheeseDao.findAll());

        model.addAttribute("title", "Add item to menu: " + menu.getName());
        model.addAttribute("form", itemForm);

        return "menu/add-item";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm itemForm,
                          Errors errors, @PathVariable int menuId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            return "menu/add-item/" + menuId;
        }

        Menu menu = menuDao.findOne(itemForm.getMenuId());
        Cheese cheese = cheeseDao.findOne(itemForm.getCheeseId());

        menu.addItem(cheese);
        menuDao.save(menu);

        return "redirect:../view/" + menu.getId();
    }
}
