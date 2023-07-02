package com.walgys.restfullwebservices.services;

import com.walgys.restfullwebservices.models.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"William", LocalDate.now().minusYears(23)));
        users.add(new User(++userCount,"Samuel", LocalDate.now().minusYears(24)));
        users.add(new User(++userCount,"Jason", LocalDate.now().minusYears(14)));
    }
    public static List<User> findAll(){
        return users;
    }
    public static User findById(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public static User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

}
