package org.example.springprofilesautowiringcase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Second case: public beans with different names; injection by type
 */
@RestController
class SecondCase {

    private final BarBean bean;

    public SecondCase(BarBean bean) {
        this.bean = bean;
    }

    @RequestMapping(path = "/bar", method = RequestMethod.GET)
    public ResponseEntity<String> bar() {
        return ResponseEntity.ok("bar:"+bean);
    }
}
@Configuration
class BarConfig1 {
    @Bean
    @Profile("p1")
    public BarBean bar1() {
        return new BarBean("bar_p1");
    }
    @Bean
    @Profile("p2")
    public BarBean bar2() {
        return new BarBean("bar_p2");
    }
}

class BarBean {
    String id;

    @Override
    public String toString() {
        return "BarBean{" +
               "id='" + id + '\'' +
               '}';
    }

   BarBean(String id) {
        this.id = id;
    }
}