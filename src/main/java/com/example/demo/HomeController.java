package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ListRepository listRepository;

    @RequestMapping("/")
    public String listToDoList(Model model){
        model.addAttribute("todolist", listRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String todolistForm(Model model){
        model.addAttribute("todolist", new ToDoList());
        return "todolistform";
    }
   @PostMapping("/process")
   public String processForm(@Valid ToDoList todolist, BindingResult result){
        if (result.hasErrors()){
            return "todolistform";
        }
        listRepository.save(todolist);
        return "redirect:/";
   }
}
