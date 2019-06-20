package kr.or.kftc.springWeb.web;

import kr.or.kftc.springWeb.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private int index = 4;
    @GetMapping("/{id}")
    public User homePage(@PathVariable(name="id") int id){
        User user = userList.get(id);

        return user;
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        user.setId(index++);
        userList.add(user);
        return user;

    }


    @DeleteMapping
    public String deleteUser(@RequestParam(name="id") int id){
        for (User curUser : userList){
            if (curUser.getId() == id){
                userList.remove(curUser);
            }
        }
        return "success";
    }

    List<User> userList = new ArrayList<>();
    public UserRestController(){
        User user1 = new User(1, "Kang");
        User user2 = new User(2, "Second");
        User user3 = new User(3, "Third");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

}
