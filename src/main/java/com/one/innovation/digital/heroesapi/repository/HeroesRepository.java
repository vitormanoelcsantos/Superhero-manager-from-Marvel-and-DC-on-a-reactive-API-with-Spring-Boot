package com.one.innovation.digital.heroesapi.repository;

import com.one.innovation.digital.heroesapi.model.Heroes;
import org.springframework.data.repository.CrudRepository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String>{
}
