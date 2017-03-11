package com.testsmirk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sun.rmi.runtime.Log;

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

    @Configuration
    public class CORSConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedHeaders("*")
                            .allowedMethods("*")
                            .allowedOrigins("*");
                }
            };
        }
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

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST )
    public User login(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        System.out.printf("username+ " + username + " password" + password);
        User user = new User(username, password);
        userRepository.save(user);
        return user;
    }
}
