package com.testsmirk;

import com.testsmirk.model.ErrorModel;
import com.testsmirk.model.MessageModel;
import com.testsmirk.utils.TextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sun.plugin2.message.Message;

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
        return null;
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
        return null;

    }

    private String ObjId = "ObjectId(\"%s\")";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"del_hello"}, method = RequestMethod.DELETE)
    public User delHello(@RequestParam(value = "id") String id) {
        String _id = String.format(ObjId, id);
        System.out.print(_id);
        return null;
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    private Object login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password

    )

    {
        logger.debug(username + "  " + password);

        return true;
    }

    @RequestMapping(value = {"/regist"}, method = RequestMethod.POST)
    public Object regist(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {

        if (userRepository.findByUsername(username) != null) {
            return new ErrorModel("用户已存在", 2);


        } else {
            if (!TextUtil.isEmpty(username) && !TextUtil.isEmpty(password)) {
                User user = new User(username, password);
                userRepository.save(user);
                MessageModel messageModel = new MessageModel();
                messageModel.setMessage("success");
                messageModel.setCode(1);
                return messageModel;
            }
        }
        return new ErrorModel();

    }
}
