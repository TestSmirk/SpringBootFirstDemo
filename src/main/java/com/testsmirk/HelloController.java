package com.testsmirk;

import org.springframework.beans.factory.annotation.Autowired;
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
        userRepository.save(new User(name, age));
        userRepository.findByUsername(name);
        return userRepository.findByUserid(name);
    }
    //查询
    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return userRepository.findByUserid(id);

    }

    private String ObjId = "ObjectId(\"%s\")";

    @RequestMapping(value = {"del_hello"}, method = RequestMethod.DELETE)
    public User delHello(@RequestParam(value = "id") String id) {
        String _id = String.format(ObjId, id);
        System.out.print(_id);
        return userRepository.findAllExceptId(_id);
    }
}
