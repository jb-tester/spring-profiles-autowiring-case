package org.example.springprofilesautowiringcase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * First case: same-named non-public beans; injection by type
 */
@RestController
class FirstCase {

    private final FooBean bean;

    public FirstCase(FooBean bean) {
        this.bean = bean;
    }

    @RequestMapping(path = "/foo", method = RequestMethod.GET)
    public ResponseEntity<String> foo() {
        return ResponseEntity.ok("foo:"+bean);
    }
}
@Configuration
@Profile("p1")
class FooConfig1 {
    @Bean
    FooBean foo() {
        return new FooBean("foo_p1");
    }
}
@Configuration
@Profile("p2")
class FooConfig2 {
    @Bean
    FooBean foo() {
        return new FooBean("foo_p2");
    }
}

class FooBean {
    String id;

    @Override
    public String toString() {
        return "FooBean{" +
               "id='" + id + '\'' +
               '}';
    }

   FooBean(String id) {
        this.id = id;
    }
}