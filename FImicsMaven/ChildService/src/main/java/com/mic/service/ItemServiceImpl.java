package com.mic.service;

import com.mic.dao.ItemMapper;
import com.mic.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemMapper itemMapper;


    public Item findById(int id) {
        return itemMapper.findById(id);
    }
}