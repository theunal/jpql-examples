package com.unal.laptop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

    List<Laptop> findLaptopsByLaptopNameStartsWith(String name);
    List<Laptop> findLaptopsByLaptopNameEndsWith(String name);
    List<Laptop> findLaptopsByLaptopNameEquals(String name);
    List<Laptop> findLaptopsByLaptopNameLike(String name);
}


    //ödev
//    List<Laptop> findLaptopsByLaptopNameStartsWith(String name);
//    List<Laptop> findLaptopsByLaptopNameEndsWith(String name);
//    List<Laptop> findLaptopsByLaptopNameEquals(String name);
//    List<Laptop> findLaptopsByLaptopNameLike(String name);