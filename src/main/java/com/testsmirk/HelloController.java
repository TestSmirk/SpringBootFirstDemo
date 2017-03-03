package com.testsmirk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by testsmirk on 17-1-27.
 */
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/hi1"}, method = RequestMethod.GET)
    public GirlProperties say() {
        return girlProperties;
    }
}
