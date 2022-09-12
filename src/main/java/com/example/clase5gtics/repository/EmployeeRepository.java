package com.example.clase5gtics.repository;

import com.example.clase5gtics.entity.EmpleadoPorPaisDto;
import com.example.clase5gtics.entity.EmpleadosPorRegionDto;
import com.example.clase5gtics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select r.regionDescription as regiondescription, count(e.employeeid) as cantidadempleados\n" +
            "FROM region r\n" +
            "inner join territories t on (r.regionid = t.regionid)\n" +
            "inner join employeeterritories et on (t.territoryid = et.territoryid)\n" +
            "inner join employees e on (e.employeeid = et.employeeid)\n" +
            "group by r.regionid",
            nativeQuery = true)
    List<EmpleadosPorRegionDto> obtenerEmpleadosPorRegionDto();

    @Query(value = "SELECT country as pais, count(*) as cantidad FROM employees GROUP BY country",
            nativeQuery = true)
    List<EmpleadoPorPaisDto> obtenerEmpleadosPorPais();

}