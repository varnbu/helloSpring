package com.varn.springHello.HelloSpring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloSpringApplicationTests {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Test
    void contextLoads() {
    }

    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//        assertThat(response.getBody(), equalTo("hello"));
    }

}
