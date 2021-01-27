package com.erbatyr.crud_app.controller;

import com.erbatyr.crud_app.model.User;
import com.erbatyr.crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersList(Model model) {
        List<User> userList = userService.userList();
        model.addAttribute("users", userList);
        return "users_list";
    }

    @GetMapping("/user/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users_get";
    }

    @GetMapping("/user/new")
    public String newUserGET(Model model) {
        model.addAttribute("user", new User());
        return "users_new_user";
    }

    @PostMapping("/user/new")
    public String newUserPOST(@RequestParam String login, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, Model model) {
        userService.addUser(new User(login, firstName, lastName, email));
        return "redirect: /crud_app_war_exploded";
    }

    @GetMapping("/user/{id}/edit")
    public String editUserGET(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users_edit";
    }

    @PostMapping("/user/{id}/edit")
    public String editUserPOST(@PathVariable("id") int id, @RequestParam String login, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, Model model) {
        User user = new User(id, login, firstName, lastName, email);
        userService.editUser(user);
        return "redirect: /crud_app_war_exploded/user/" + id;
    }

    @GetMapping("/user/{id}/delete")
    public String deleteUserGET(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users_delete";
    }

    @PostMapping("/user/{id}/delete")
    public String articleDeletePost(@PathVariable(value = "id") int id, Model model) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect: /crud_app_war_exploded";
    }

}
