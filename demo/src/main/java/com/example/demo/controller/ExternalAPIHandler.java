package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExternalAPIService;

@RestController

@RequestMapping("api/v1/")
public class ExternalAPIHandler{

    @Autowired
    private ExternalAPIService externalAPIService;

@GetMapping
public String getAllData(){
    return externalAPIService.getAllData();
}
}
