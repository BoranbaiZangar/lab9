package com.example.lab9.controllers;

import com.example.lab9.dtos.CountryDto;
import com.example.lab9.dtos.ItemDto;
import com.example.lab9.services.CountryService;
import com.example.lab9.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final ItemService itemService;
    private final CountryService countryService;

    @GetMapping({"", "/"})
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("items", itemService.findAll());
        response.put("countries", countryService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/items")
    public List<ItemDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/countries")
    public List<CountryDto> getAllCountries() {
        return countryService.findAll();
    }
}