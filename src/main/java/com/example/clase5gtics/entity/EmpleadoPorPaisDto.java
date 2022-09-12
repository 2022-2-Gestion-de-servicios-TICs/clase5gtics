package com.example.clase5gtics.entity;

public interface EmpleadoPorPaisDto {
    //SELECT country as pais, count(*) as cantidad FROM employees GROUP BY country
    String getPais();
    int getCantidad();
}
