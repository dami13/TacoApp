package com.dami.tacoapp.repository;

import com.dami.tacoapp.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
