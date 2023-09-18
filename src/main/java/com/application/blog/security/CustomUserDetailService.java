package com.application.blog.security;

import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.models.User;
import com.application.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Load user from DB by username
        User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "Username : " + username, -1));

        return user;
    }
}