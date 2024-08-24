package org.example.springprofilesautowiringcase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Third case: non-public beans with different names; injection by type: ERROR
 * https://youtrack.jetbrains.com/issue/IDEA-358182
 */
@RestController
class ThirdCase {


    private final Buzz buzz;

    public ThirdCase(Buzz buzz) {
        this.buzz = buzz;
    }

    @RequestMapping(path = "/buzz", method = RequestMethod.GET)
    public ResponseEntity<String> buzz() {
        return ResponseEntity.ok("buzz:"+buzz);
    }
}

@Configuration
class BuzzConfiguration {

    @Profile("p1")
    @Bean
    Buzz bean1() {
        return new Buzz("buzz_p1");
    }

    @Profile("p2")
    @Bean
    Buzz bean2() {
        return new Buzz("buzz_p2");
    }
}

class Buzz {
    String id;

    public Buzz(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Buzz{" +
               "id='" + id + '\'' +
               '}';
    }
}