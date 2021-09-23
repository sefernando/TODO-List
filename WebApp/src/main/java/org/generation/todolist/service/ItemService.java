package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);

    void delete(Integer itemId);

    List<Item> finaAll();

    Item findById(int itemId);

}
