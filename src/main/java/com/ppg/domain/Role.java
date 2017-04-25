package com.ppg.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 12/18/15.
 */

public class Role {

    private String role;

    private List<User> users = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

      
    }

    public void removeUser(UserJson user){
        this.users.remove(user);
    }

}
