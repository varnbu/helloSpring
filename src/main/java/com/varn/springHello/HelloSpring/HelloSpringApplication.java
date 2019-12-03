package com.varn.springHello.HelloSpring;

import com.varn.springHello.HelloSpring.c.MdBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class HelloSpringApplication {
    @Value("${my.name}")
    private String name;

    @Autowired
    MdBean md ;

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(this.name.toString());
        System.out.println(md.getName()+md.getWant());
        return "hello";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("========================================> inspect beans:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            System.out.println("数量： " + beanNames.length);
            for (String name : beanNames) {
//                System.out.println(name);
            }
        };
    }
}
