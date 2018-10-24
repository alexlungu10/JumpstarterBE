package com.example.jumpstarter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author alexandru.lungu
 */


@Service
public class ItemService {
    public static Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    ItemRepository itemRepository;

    @LogMetricsInfo
    List<Item> getItems() {
        LOGGER.info("get items ");
        return  (List) itemRepository.findAll();
    }

    @LogMetricsInfo
    public Item save(Item item) {
        LOGGER.info("save item : {}", item);
        return itemRepository.save(item);
    }

    @LogMetricsInfo
    public boolean delete(long id) {
        LOGGER.info("delete item : {}", id);
        try{
            itemRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            System.out.println("Data not found");
            return false;
        }
        return true;
    }

    @LogMetricsInfo
    public void delete(Item item) {

        LOGGER.info("delete item : {}", item);
        delete(item.getId());
    }
}
