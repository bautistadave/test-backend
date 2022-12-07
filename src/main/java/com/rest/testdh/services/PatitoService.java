package com.rest.testdh.services;

import com.rest.testdh.dtos.PatitoDto;
import com.rest.testdh.models.Patito;
import com.rest.testdh.repositories.PatitoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatitoService {

     List<PatitoDto> getAll();
     PatitoDto create(PatitoDto patitoDto);
     PatitoDto getById(Long id);
     PatitoDto update(PatitoDto patitoDto, Long id);
     PatitoDto delete(Long id);


}
