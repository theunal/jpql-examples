package com.unal.laptop;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class LaptopController {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // http://localhost:8080/save
    @GetMapping("/save")
    @ResponseBody
    public String save() {
        Laptop laptop = Laptop
                .builder()
                .laptopName("asus")
                .laptopPrice(9500)
                .build();

        Laptop l = laptopRepository.save(laptop);
        log.info("Ürün eklendi: "+l);
        return "Ürün eklendi: <br/><br/>"+l;

    }




    // http://localhost:8080/laptop/findLaptopsByLaptopNameStartsWith/a
    @GetMapping("/laptop/findLaptopsByLaptopNameStartsWith/{name}")
    @ResponseBody
    public String findLaptopsByLaptopNameStartsWith(@PathVariable(name = "name") String name) {

        List<Laptop> entities = laptopRepository.findLaptopsByLaptopNameStartsWith(name);

        if (!entities.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(" ile başlayan ürünler getirildi: <br/><br/>");
            for (var entity : entities) {
                log.info(entity);
                builder.append(entity).append("<br/>");
            }

            return builder + "";
        }
            log.info(name+" ile başlayan ürün bulunamadi.");
            return name+" ile başlayan ürün bulunamadi.";
    }


    // http://localhost:8080/laptop/findLaptopsByLaptopNameEndsWith/a
    @GetMapping("/laptop/findLaptopsByLaptopNameEndsWith/{name}")
    @ResponseBody
    public String findLaptopsByLaptopNameEndsWith(@PathVariable(name = "name") String name) {

        List<Laptop> entities = laptopRepository.findLaptopsByLaptopNameEndsWith(name);

        if (!entities.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(" ile biten ürünler getirildi: <br/><br/>");
            for (var entity : entities) {
                log.info(entity);
                builder.append(entity).append("<br/>");
            }

            return builder + "";
        }
        log.info(name+" ile biten ürün bulunamadi.");
        return name+" ile biten ürün bulunamadi.";
    }

    // http://localhost:8080/laptop/findLaptopsByLaptopNameEquals/asus
    @GetMapping("/laptop/findLaptopsByLaptopNameEquals/{name}")
    @ResponseBody
    public String findLaptopsByLaptopNameEquals(@PathVariable(name = "name") String name) {

        List<Laptop> entities = laptopRepository.findLaptopsByLaptopNameEquals(name);

        if (!entities.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(" laptopName'ine sahip ürünler getirildi: <br/><br/>");
            for (var entity : entities) {
                log.info(entity);
                builder.append(entity).append("<br/>");
            }

            return builder + "";
        }
        log.info(name+" adli ürün bulunamadi.");
        return name+" adli ürün bulunamadi.";
    }


    // http://localhost:8080/laptop/findLaptopsByLaptopNameLike/p
    @GetMapping("/laptop/findLaptopsByLaptopNameLike/{name}")
    @ResponseBody
    public String findLaptopsByLaptopNameLike(@PathVariable(name = "name") String name) {

        List<Laptop> entities = laptopRepository.findLaptopsByLaptopNameLike("%"+name+"%");

        if (!entities.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("İçinde ").append(name).append(" geçen ürünler getirildi: <br/><br/>");
            for (var entity : entities) {
                log.info(entity);
                builder.append(entity).append("<br/>");
            }

            return builder + "";
        }
        log.info("İçinde "+name+" geçen ürün bulunamadi.");
        return "İçinde "+name+" geçen ürün bulunamadi.";
    }



}
