package com.example.jumpstarter;

import org.springframework.data.repository.CrudRepository;

/**
 * @author alexandru.lungu
 */


public interface ItemRepository extends CrudRepository<Item,Long> {
}
