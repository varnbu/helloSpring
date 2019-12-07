package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.c.User;
import com.varn.springHello.HelloSpring.service.GithubLookupService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/github")
public class githubController {
    private GithubLookupService githubLookupService;

    public githubController(GithubLookupService githubLookupService) {
        this.githubLookupService = githubLookupService;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getUser(@PathVariable("username") String username) throws InterruptedException, ExecutionException {
        Future<User> page =  githubLookupService.findUser(username);
        System.out.println(page.get());
        return page.get().toString();
    }
}
