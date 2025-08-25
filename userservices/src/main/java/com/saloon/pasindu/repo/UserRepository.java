package com.saloon.pasindu.repo;

import com.saloon.pasindu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
