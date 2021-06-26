package config.controller;

import config.bean.Cat;
import config.bean.Dog;
import config.bean.Fish;
import config.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Dog dog;

    @Autowired
    @Qualifier(value = "cat")
    private Cat myCat;

    @Autowired
    private Fish fish;

    @Autowired
    private Person person;

    @RequestMapping("/index1")
    public String index1()
    {
        return person.toString();
    }

    @RequestMapping("/one")
    public String one()
    {
        return "dog :"+dog.toString()+"\n cat :"+myCat.toString()+"\n fish : "+fish.toString();
    }
}
