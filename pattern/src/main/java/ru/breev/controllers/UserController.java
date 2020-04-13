package ru.breev.controllers;

import ru.breev.entities.User;
import ru.breev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


// http://localhost:8189/app/users/...
@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    // http://localhost:8189/app/users/info/1
    @RequestMapping(path = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Integer id) throws SQLException {
        return userService.findById(id);
    }

    // http://localhost:8189/app/users/show
    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String showAllUsers(Model model) throws SQLException {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all_users";
    }
}