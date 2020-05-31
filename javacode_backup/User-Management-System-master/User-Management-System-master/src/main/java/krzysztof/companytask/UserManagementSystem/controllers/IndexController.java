package krzysztof.companytask.UserManagementSystem.controllers;

import krzysztof.companytask.UserManagementSystem.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private UsersService usersService;

    public IndexController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping({"", "/index"})
    public String showUsersListPage(Model model){
        model.addAttribute("users" ,usersService.getUsers());
        return "index";
    }
}
