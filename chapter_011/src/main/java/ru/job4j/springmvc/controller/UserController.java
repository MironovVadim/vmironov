package ru.job4j.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.springmvc.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class UserController {

    private List<User> users = new CopyOnWriteArrayList<>();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showItems(ModelMap model) {
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        this.users.add(user);
        return "redirect:users.do";
    }
}
