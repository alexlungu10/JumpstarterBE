package com.example.jumpstarter;

import org.apache.logging.log4j.util.Strings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author alexandru.lungu
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class JumpstarterApplicationTests {

    @Autowired
    ItemService itemService;

    @Before
    public void setup() {
       /* for (Item item : itemService.getItems()) {
            itemService.delete(item);
        }*/
        //itemService.getItems().forEach(item -> itemService.delete(item.getId()));
        itemService.getItems().forEach(itemService::delete);
    }

    @Test
    public void contextLoads() {

        //Create exercise
        // itemService.save(new Item("VW2", 5));

        //Create
        Item savedItem = itemService.save(new Item("VW", 3));
        Assert.assertTrue(savedItem.getId() != null && savedItem.getId() > 0);
        int updatedQuantity = 22;
        savedItem.setQuantity(updatedQuantity);

        //Read
        Assert.assertTrue(itemService.getItems().size() == 1);

        //Update
        Item updatedSaved = itemService.save(savedItem);
        Assert.assertTrue(updatedSaved.getQuantity() == updatedQuantity);

        //Delete
        Assert.assertTrue(itemService.delete(savedItem.getId()));
        Assert.assertTrue(itemService.getItems().size() == 0);
        //Account not found
        Assert.assertFalse(itemService.delete(savedItem.getId()));


    }

}
