package com.rest.testdh.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PatitoDto {

    private Long id;
    private String color;
    private String tamanio;
    private Double precio;
    private Integer cantidad;
    private boolean borrado;


}
