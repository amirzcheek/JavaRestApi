package com.example.restapplication.services;

import com.example.restapplication.entity.Laptop;
import com.example.restapplication.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LaptopService {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> getAllLaptops(){
        return laptopRepository.findAll();
    }

    public Laptop getLaptop(int id){
        return laptopRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addLaptop(Laptop laptop){
        laptopRepository.save(laptop);
    }

    @Transactional
    public void updateLaptop(int id, Laptop laptop){
        laptop.setId(id);
        laptopRepository.save(laptop);
    }

    @Transactional
    public void deleteLaptop(int id){
        laptopRepository.deleteById(id);
    }
}
