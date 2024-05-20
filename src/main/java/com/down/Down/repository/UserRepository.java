package com.down.Down.repository;

import com.down.Down.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel> findByEmail(String email);
}



// because here we are taking username as email
