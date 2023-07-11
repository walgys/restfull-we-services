package com.walgys.restfullwebservices.repositories;

import com.walgys.restfullwebservices.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
