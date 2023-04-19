package com.dami.tacoapp.repository;

import com.dami.tacoapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
