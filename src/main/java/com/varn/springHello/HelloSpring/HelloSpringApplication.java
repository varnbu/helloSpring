package com.varn.springHello.HelloSpring;

import com.varn.springHello.HelloSpring.c.MdBean;
import com.varn.springHello.HelloSpring.c.SomeStringBean;
import com.varn.springHello.HelloSpring.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
@RestController
public class HelloSpringApplication {
    @Value("${my.name}")
    private String name;

    @Autowired
    MdBean md ;

    @Autowired
    SomeStringBean sb;

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(this.name.toString());
        System.out.println(md.getName());
        System.out.println(md.getWant());
        System.out.println(sb.getName());
        System.out.println(sb.getLabel());
        int a = '2';
        System.out.println(a);
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

    @Bean CommandLineRunner init(StorageService storageService){
        return args -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
