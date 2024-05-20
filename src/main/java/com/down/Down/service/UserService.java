package com.down.Down.service;

import com.down.Down.model.Login;
import com.down.Down.model.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // register  (save)
    UserModel register(UserModel userModel);

    // login

    Authentication login(Login login);
}
