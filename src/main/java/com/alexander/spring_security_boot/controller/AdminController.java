package com.alexander.spring_security_boot.controller;

import com.alexander.spring_security_boot.Service.UserService;
import com.alexander.spring_security_boot.model.Role;
import com.alexander.spring_security_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String userController(Model model) {
        List<User> list = userService.allUsers();
        model.addAttribute("list", list);
        return "users";
    }

    @GetMapping("/addUser")
    public String getAllUsers(Model model) {
        model.addAttribute("newUser", new User());
        List<User> list = userService.allUsers();
        model.addAttribute("users", list);
        return "addPerson";
    }

    @PostMapping("/addUser")
    public String savePerson(Model model, User user) {
        String username = user.getUsername();
        String password = user.getPassword();
//        Set<Role> setRole = new HashSet<>();
//        Role role = userService.findByRoleName("ROLE_USER");
//        setRole.add(role);

        User newUser = new User(username, password);
        userService.saveUser(newUser);
        return "redirect:/admin/users";

    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin/users";
    }
}
