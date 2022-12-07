package com.rest.testdh.controllers;

import com.rest.testdh.dtos.PatitoDto;
import com.rest.testdh.models.Patito;
import com.rest.testdh.repositories.PatitoRepository;
import com.rest.testdh.services.PatitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatitoController {

    @Autowired
    private PatitoRepository patitoRepository;

    @Autowired
    private PatitoService patitoService;


    @GetMapping("/patitos")
    public ResponseEntity<List> getAll(){
        return new ResponseEntity<>(patitoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/patitos/{id}")
    public ResponseEntity<PatitoDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(patitoService.getById(id));
    }

    @PostMapping("/patito")
    public ResponseEntity<PatitoDto> create(@RequestBody PatitoDto patitoDto){
        return new ResponseEntity<>(patitoService.create(patitoDto), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public PatitoDto delete(@PathVariable Long id) {
     return patitoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatitoDto> update(@RequestBody PatitoDto patitoDto, @PathVariable Long id) {
        PatitoDto patitoDtoU = patitoService.update(patitoDto, id);
        return new ResponseEntity<>(patitoDtoU, HttpStatus.OK);
    }





}
