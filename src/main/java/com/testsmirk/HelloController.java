package com.testsmirk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by testsmirk on 17-1-27.
 */
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.POST)
    public User say(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        System.out.println("HelloController.say " + name + "   age " + age);
        userRepository.save(new User(1L, name, age));
        return userRepository.findByUsername(name);
    }
}
