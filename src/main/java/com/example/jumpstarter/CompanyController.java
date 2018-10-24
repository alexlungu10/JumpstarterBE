package com.example.jumpstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    ItemService itemService;

    public static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);


    @RequestMapping(path = "/postItem", method = RequestMethod.POST)
    public Item postItem(@RequestBody Item item) {
        Item savedItem = itemService.save(item);
        return savedItem;
    }

    @RequestMapping(path = "/getItems", method = RequestMethod.GET)
    public Iterable<Item> getItems() {
        return itemService.getItems();

    }

    @RequestMapping(path = "/putItem", method = RequestMethod.PUT)
    public Item putItem(@RequestBody Item item) {


        Item savedItem = itemService.save(item);
        return savedItem;
    }

    @RequestMapping(path = "/deleteItem", method = RequestMethod.DELETE)
    public boolean deleteItem(@RequestParam(value = "id") String id) {
        return itemService.delete(Long.valueOf(id));

    }


}
