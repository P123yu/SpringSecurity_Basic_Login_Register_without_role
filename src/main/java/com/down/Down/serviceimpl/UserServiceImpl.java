package com.down.Down.serviceimpl;

import com.down.Down.model.Login;
import com.down.Down.model.UserModel;
import com.down.Down.repository.UserRepository;
import com.down.Down.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserModel register(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        UserModel user=userRepository.save(userModel);
        return user;
    }


    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public Authentication login(Login login) {
        System.out.println(login.getEmail()+" "+login.getPassword());
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
            return authentication;
    }
}
