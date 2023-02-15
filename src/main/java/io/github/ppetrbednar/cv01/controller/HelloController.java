package io.github.ppetrbednar.cv01.controller;

import org.springframework.web.bind.annotation.*;

// Rozdíl mezi @RestController a @Controller
/*
* RestController je specializovaná forma Controlleru a určuje, že funkce řešící Mapping vrací defaultně RequestBody.
* */
@RestController
public class HelloController {
   /* @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }*/

    @GetMapping("/query")
    public String printText(@RequestParam("text") String text) {
        return text;
    }

    @GetMapping("/path/{id}")
    public String getFooById(@PathVariable String id) {
        return "ID: " + id;
    }
    @GetMapping("/body")
    public String getBody(@RequestBody SimpleBody simpleBody) {
        return "Object: " + simpleBody;
    }

    // Rozdíl mezi JAML, JSON, XML
    /*
    * JSON je původně JS standard pro serializaci.
    * XML je volnější standard s volným pojmenováváním tagů oproti HTML.
    * JAML je modernější odlehčený jazyk pro zápisy konfigurací.
    * */
}
