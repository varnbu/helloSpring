package com.varn.springHello.HelloSpring.service;

import com.varn.springHello.HelloSpring.c.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class GithubLookupService {
    private static final Logger logger = LoggerFactory.getLogger(GithubLookupService.class);
    private final RestTemplate restTemplate;

    public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Future<User> findUser(String user) throws InterruptedException {
        logger.info("查找用户： " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User result = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);
        return new AsyncResult<>(result);
    }
}
