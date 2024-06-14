package uz.takhir.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

//Rest API
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    // /hello-world

    //"Hello World"
    //@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    // Path Parameters
    // /users/{id}/todos/{id}
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello "+name);
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return "Hello World V2!";
    }
}

// internationalization - i18n
