package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody

public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String greetingWithName = HelloController.createMessage(name, language);
        return greetingWithName;
        //THIS IS CONFUSING SO THE CONTROLLER CAN CALL ITSELF?!
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                    "<option value='English'>English</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Hindi'>Hindi</option>" +
                    "<option value='Japanese'>Japanese</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    public static String createMessage(String name, String language) {
        switch(language) {
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour, " + name;
            case "Hindi":
                return "Namaste, " + name;
            case "Japanese":
                return "Konnichiwa, " + name;
            case "English":
            default:
                return "Hello, " + name;
        }
    }
}

/*
<label for="pet-select">Choose a pet:</label>

<select name="pets" id="pet-select">
    <option value="">--Please choose an option--</option>
    <option value="dog">Dog</option>
    <option value="cat">Cat</option>
    <option value="hamster">Hamster</option>
    <option value="parrot">Parrot</option>
    <option value="spider">Spider</option>
    <option value="goldfish">Goldfish</option>
</select>

 */