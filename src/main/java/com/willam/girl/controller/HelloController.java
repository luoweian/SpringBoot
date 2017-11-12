package com.willam.girl.controller;

import com.willam.girl.properties.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController 对应一个web页面
 */
@RestController
@RequestMapping(value = "/say")
public class HelloController {

    @Autowired
    private Girl girl;



//    @RequestMapping(value = "hi/{id}", method = RequestMethod.GET)
//    public String say(){                  //localhost:8080/say/hi/123
//        return girl.getCupSize();
//    }

//  @RequestMapping(value = "/hi", method = RequestMethod.GET)
//    public String say(@RequestParam("id") Integer id){      //localhost:8080/say/hi?id=100
//        return "id: " + id;
//    }

//    @RequestMapping(value = "/hi", method = RequestMethod.GET)
//    public String say(@RequestParam(value = "id", required = false,
//            defaultValue = "0") Integer id){      //localhost:8080/say/hi //localhost:8080/say/hi?id=13
//        return "id: " + id;
//    }

    @GetMapping(value = "/hi")
    public Integer say(@RequestParam(value = "id", required = false,
            defaultValue = "0") Integer id){      //localhost:8080/say/hi //localhost:8080/say/hi?id=13
        return girl.getAge();
    }
}
