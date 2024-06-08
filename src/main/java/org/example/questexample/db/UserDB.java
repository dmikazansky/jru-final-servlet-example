package org.example.questexample.db;

import lombok.Data;
import org.example.questexample.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class UserDB {

    private static List<User> users;

    private UserDB() {

    }
    public boolean addUser(User user) {
        for (User user1 : users) {
            Objects.equals(user, user1);
            return false;
        }
        users.add(user);
        return true;
    }
    public static boolean validateUser(User user) {
        for (User user1 : users) {
            if (Objects.equals(user, user1)) {
                return true;
            }
        }
        return false;
    }
    public static List<User> createUsers() {
        if(users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
