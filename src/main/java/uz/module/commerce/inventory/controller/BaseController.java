package uz.module.commerce.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BaseController {
    @Autowired
    private Environment environment;

    public String getProperty(String key){
        return environment.getProperty(key);
    }

    public Integer getIntProperty(String key){
        return environment.getProperty(key, Integer.class);
    }
}
