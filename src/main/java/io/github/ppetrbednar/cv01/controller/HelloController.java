package io.github.ppetrbednar.cv01.controller;

import io.github.ppetrbednar.cv01.dto.SimpleBody;
import org.springframework.web.bind.annotation.*;

// Rozdíl mezi @RestController a @Controller
/*
 * RestController je specializovaná forma Controlleru a určuje, že funkce řešící Mapping vrací defaultně RequestBody.
 * */
@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/path/{message}")
    public String helloPathParams(@PathVariable String message) {
        return "Hello with path params: " + message;
    }

    @GetMapping("/query")
    public String helloQueryParams(@RequestParam String message) {
        return "Hello with query params: " + message;
    }

    @GetMapping("/body")
    public String helloRequestBody(@RequestBody SimpleBody body) {
        return "Hello with request body " + body.toString();
    }

    // Rozdíl mezi JAML, JSON, XML
    /*
     * JSON je původně JS standard pro serializaci.
     * XML je volnější standard s volným pojmenováváním tagů oproti HTML.
     * JAML je modernější odlehčený jazyk pro zápisy konfigurací.
     * */
}
