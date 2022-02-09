package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.Admin;
import com.example.demo.web.dto.AdminRegistrationDto;

public interface AdminService extends UserDetailsService {

    Admin findByEmail(String email);

    Admin save(AdminRegistrationDto aregistration);
}
