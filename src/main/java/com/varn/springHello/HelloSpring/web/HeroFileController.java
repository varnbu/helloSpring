package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.storage.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class HeroFileController {

    private final StorageService storageService;

    public HeroFileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping("test")
    public String test() {
        return "file test";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("fileName") String name) {
        String ru = name;
        return ru;
    }
}
