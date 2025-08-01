package com.workintech.fswebs17d1.controller;
//CONTROLLER PACKAGE2I DIŞ DÜNYAYA AÇTIĞIMIZ KISIMDIR.


//AnimalResource, AnimalRestController olarak da adlandırılabilir.

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//pom.xml'de dependecy olan spring-boot-starter-web paketinden geliyor.

//default host name: http://localhost:8585  --> application.properties kısmında öyle ayarlandığım için.

@RestController
@RequestMapping(path = "/workintech/animal ")
//http://localhost:8585/workintech/animal --> AnimalController 
public class AnimalController {
    private Map<Integer, Animal> animalMap;


    @PostConstruct

}
