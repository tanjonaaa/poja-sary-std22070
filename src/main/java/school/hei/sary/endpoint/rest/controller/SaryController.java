package school.hei.sary.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaryController {

    @PutMapping("/blacks/{id}")
    public String turnToBlack(@PathVariable String id){
        return id;
    }

    @GetMapping("/blacks/{id}")
    public String getBlackedImage(@PathVariable String id){
        return id + "is blacked";
    }
}
