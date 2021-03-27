package com.one.innovation.digital.heroesapi.service;

import com.one.innovation.digital.heroesapi.model.Heroes;
import com.one.innovation.digital.heroesapi.repository.HeroesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAllHeroes(){
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public  Mono<Heroes> findByIdHero(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> createHero(Heroes heroes){
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteByIdHero(String id) {
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }

    public Mono<Heroes> updateAHeroById(String id, Heroes heroes){
        heroes.setId(id);
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }
}
