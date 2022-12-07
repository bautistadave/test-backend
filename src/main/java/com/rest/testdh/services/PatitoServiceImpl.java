package com.rest.testdh.services;

import com.rest.testdh.dtos.PatitoDto;
import com.rest.testdh.models.Patito;
import com.rest.testdh.repositories.PatitoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatitoServiceImpl implements PatitoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatitoRepository patitoRepository;

    @Override
    public PatitoDto create(PatitoDto patitoDto) {
        Patito patito = mapperEntity(patitoDto);
        return mapperDTO(patitoRepository.save(patito));
    }

    @Override
    public PatitoDto getById(Long id) {
        Optional<Patito> patito = patitoRepository.findById(id);
        return mapperDTO(patito.get());
    }

    @Override
    public List<PatitoDto> getAll() {
        return patitoRepository
                .findAll(Sort.by(Sort.Direction.DESC, "cantidad"))
                .stream().map(p -> mapperDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public PatitoDto update(PatitoDto patitoDto, Long id){
        Optional<Patito> patitoOptional = patitoRepository.findById(id);
        Patito patito = patitoOptional.get();

        patito.setColor(patitoDto.getColor());
        patito.setTamanio(patitoDto.getTamanio());
        patito.setCantidad(patitoDto.getCantidad());
        patito.setPrecio(patitoDto.getPrecio());

        Patito patitoU = patitoRepository.save(patito);
        return mapperDTO(patitoU);

    }

    @Override
    public PatitoDto delete(Long id) {
        Optional<Patito> patitoOptional = patitoRepository.findById(id);
        Patito patito = patitoOptional.get();

        patitoRepository.delete(patito);
        return mapperDTO(patito);
    }


    private PatitoDto mapperDTO(Patito patito){
        PatitoDto patitoDto = modelMapper.map(patito, PatitoDto.class);
        return patitoDto;
    }
    private Patito mapperEntity(PatitoDto patitoDto) {
        Patito patito = modelMapper.map(patitoDto, Patito.class);
        return patito;

    }
}
