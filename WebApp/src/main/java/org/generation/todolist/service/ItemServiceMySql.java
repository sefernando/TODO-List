package org.generation.todolist.service;

import org.generation.todolist.repository.ItemRepository;
import org.generation.todolist.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySql implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySql(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public Item save(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public void delete(Integer itemId) {
        this.itemRepository.deleteById(itemId);
    }


    @Override
    public List<Item> finaAll() {
        List<Item> items = new ArrayList<>();
        this.itemRepository.findAll().forEach(item -> items.add(item));
        return items;
    }

    @Override
    public Item findById(int itemId) {
        Optional<Item> item = this.itemRepository.findById(itemId);
        return item.orElseThrow();
    }

}
