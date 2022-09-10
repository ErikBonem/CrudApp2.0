package web.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.Model.User;
import web.Service.UserService;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/people")
public class Controller {
    private final UserService us;

    @Autowired
    public Controller(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", us.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", us.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "people/new";
        } else {
            us.save(user);
            return "redirect:/people";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", us.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            return "people/edit";
        } else {
            us.update(user);
            return "redirect:/people";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        us.delete(id);
        return "redirect:/people";
    }
}
