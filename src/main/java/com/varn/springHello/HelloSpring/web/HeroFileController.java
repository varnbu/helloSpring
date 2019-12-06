package com.varn.springHello.HelloSpring.web;

import com.varn.springHello.HelloSpring.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> saveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, ";filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("fileName") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        System.out.println(file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("msg", "you successfully upload " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }
}
