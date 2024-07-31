package com.example.restapplication.controllers;

import com.example.restapplication.entity.Laptop;
import com.example.restapplication.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/laptops")
    public List<Laptop> getLaptops(){
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getOnlyLaptop(@PathVariable("id") int id){
        return laptopService.getLaptop(id);
    }

    @PostMapping("/addLaptop")
    public String addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
        return "book is added";
    }

    @PutMapping("/edit/{id}")
    public String updateLaptop(@PathVariable("id") int id, @RequestBody Laptop laptop){
        laptopService.updateLaptop(id, laptop);
        return "Success";
    }

    @DeleteMapping("/{id}")
    public String deleteLaptop(@PathVariable("id") int id) {
        laptopService.deleteLaptop(id);
        return "Laptop is deleted";
    }


}
