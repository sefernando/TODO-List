package org.generation.todolist.controller;


import org.generation.todolist.controller.dto.ItemDTO;
import org.generation.todolist.repository.entity.Item;
import org.generation.todolist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

//    @RequestMapping("/")
//    public String test(){
//        return "test";
//    }

    final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getAllItems() {
        return itemService.finaAll();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item save(
            @RequestParam(name = "title", required = true) String title,
            @RequestParam(name = "description", required = true) String description,
            @RequestParam(name = "date", required = true) String date
    ) throws IOException {
        ItemDTO itemDTO = new ItemDTO(title, description, date);
        return itemService.save(new Item(itemDTO));
    }

}
