package com.mic.dao;

import com.mic.pojo.Item;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemMapper {
    public Item findById(int id);
}