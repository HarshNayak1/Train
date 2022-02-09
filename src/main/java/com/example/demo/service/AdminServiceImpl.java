package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.ARole;
import com.example.demo.model.Admin;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.AdminRegistrationDto;
import com.example.demo.web.dto.UserRegistrationDto;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Admin findByEmail(String email){
        return adminRepository.findByEmail(email);
    }

    public Admin save(AdminRegistrationDto aregistration){
        Admin admin = new Admin();
       admin.setFirstName(aregistration.getFirstName());
        admin.setLastName(aregistration.getLastName());
        admin.setEmail(aregistration.getEmail());
        admin.setPassword(passwordEncoder.encode(aregistration.getPassword()));
        admin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        return adminRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(admin.getEmail(),
               admin.getPassword(),
                mapRolesToAuthorities(admin.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}