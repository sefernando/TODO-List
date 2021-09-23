package org.generation.todolist.repository;

import org.generation.todolist.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Integer> {

}
