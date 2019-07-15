package com.example.demo.service;

import com.example.demo.entity.Container;

import java.util.List;

public interface ContainerService {

    Container save(Container container);
    void delete(Integer id);
    Container findByConId(Integer id);
    Container findBynull();
    List<Container> findConAll();

    List<Container> check(String code);



}
