package com.workintech.fswebs17d1.controller;
//CONTROLLER PACKAGE2I DIŞ DÜNYAYA AÇTIĞIMIZ KISIMDIR.


//AnimalResource, AnimalRestController olarak da adlandırılabilir.

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//pom.xml'de dependecy olan spring-boot-starter-web paketinden geliyor.

//default host name: http://localhost:8585  --> application.properties kısmında öyle ayarlandığım için.

@RestController
@RequestMapping(path = "/workintech/animal ")
//http://localhost:8585/workintech/animal --> AnimalController 
public class AnimalController {
    private Map<Integer, Animal> animalMap;



    //SpringBoot projelerinde uygulama ayağa kalkarken bazı seylerin öncesinde setup haline getirilmesi/hazırlanması/load olması istendiğinde
    //bu methodu herhangi bir yerden cagırmaya gerek kalmadan PostConstruct annotaitonıyla proje ayağa kalkarken bu method(loadAll) devreye giriyor
    //...çalışıyor ve içindeki işlemleri execute ediyor. proje ayağa kalktıgında bir tane animalMap HashMap'i hazır ve içinde bir
    //...tane hamster eklenmiş bir şekilde kullanıma hazır halde beklemesini sağlıyor.
    //her controllerda PostConstruct yazma zorunlulugu yok.
    @PostConstruct
    public void loadAll() {
        System.out.println("PostConstruct calisti. ");
        this.animalMap = new HashMap<>();    //animalMap initiliaze ediliyor.
        this.animalMap.put(1, new Animal(1, "hamster")); //içine default olarak bir tane hayvan ekliyoruz.
    }


    //listenin hepsini çekmek için:
    //yani direkt olarak get("/http://localhost:8585/workintech/animal") atarsak bu çalışacak.
    @GetMapping
    public List<Animal> getAnimals() {
        System.out.println("----animals get all triggered!");
        //map'in valuelarını arraylist'e döndürüyoruz:
        return new ArrayList<>(animalMap.values());
    }

    //bu methodda "/http://localhost:8585/workintech/animal" bağlantısını kullanmak için sonuna id göndermemiz gerekecek.
    //yani /http://localhost:8585/workintech/animal/333 gibi, bu path'in karşılığı o id'ye sahip Animal'ı dönecek bu method sayesinde.
    //spesifik bir kaydı almak için:
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable("id") int id) {

    }
}
