package com.careerit.jfs.cj.exception;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User("john", "john@1243", "john@careerit.com"));
        users.add(new User("krishna", "krishna@1243", "krishna@careerit.com"));
        users.add(new User("ramesh", "ramesh@1243", "ramesh@careerit.com"));
        users.add(new User("charan", "charan@1243", "charan@careerit.com"));
        users.add(new User("manoj", "manoj@1243", "manoj@careerit.com"));
    }

    public String loginUser(String email, String password) throws UserNotFoundException, BadCredentitalException {
        try {
            User user = loadUser(email);
            if (user.password().equals(password)) {
                return user.username();
            }else{
                throw new BadCredentitalException("Invalid email or password");
            }
        } catch (UserNotFoundException e) {
            throw e;
        }

    }

    public User loadUser(String email) throws UserNotFoundException {

        return users.stream()
                .filter(user -> user.email().equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));


    }

}
