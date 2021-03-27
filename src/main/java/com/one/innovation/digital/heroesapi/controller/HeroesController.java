package com.one.innovation.digital.heroesapi.controller;


import com.one.innovation.digital.heroesapi.model.Heroes;
import com.one.innovation.digital.heroesapi.repository.HeroesRepository;
import com.one.innovation.digital.heroesapi.service.HeroesService;
import static com.one.innovation.digital.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class HeroesController {
    HeroesService heroesService;

    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> findAllHeroes() {
        log.info("Requesting the list off all heroes");
        return heroesService.findAllHeroes();

    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new Hero was created");
        return heroesService.createHero(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteByIdHero(@PathVariable String id) {
        heroesService.deleteByIdHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

    @PutMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<Heroes> updateHeroById(@PathVariable String id, @RequestBody Heroes heroes){
        return heroesService.updateAHeroById(id, heroes);
    }
}
