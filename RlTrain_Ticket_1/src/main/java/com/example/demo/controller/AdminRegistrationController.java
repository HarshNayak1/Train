package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.web.dto.AdminRegistrationDto;

@Controller
@RequestMapping("/aregistration")
public class AdminRegistrationController {

    @Autowired
    private AdminService adminService;

    @ModelAttribute("admin")
    public AdminRegistrationDto adminRegistrationDto() {
        return new AdminRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "aregistration";
    }

    @PostMapping
    public String registerAdminAccount(@ModelAttribute("admin") @Valid AdminRegistrationDto adminDto,
                                      BindingResult result){

        Admin existing = adminService.findByEmail(adminDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "aregistration";
        }

        adminService.save(adminDto);
        return "redirect:/aregistration?success";
    }

}

