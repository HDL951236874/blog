package com.edaolin.blog.Config;

import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Username == mail and the real username is not important since it can be defined according to the customer
        User byEmail = userRepository.findByEmail(username);
        if (byEmail == null) {
            throw new UsernameNotFoundException(username);
        }else {
            return org.springframework.security.core.userdetails.User.builder().
                    username(username).
                    password(byEmail.getPassword()).
                    build();
        }
    }
}
