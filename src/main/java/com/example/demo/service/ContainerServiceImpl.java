package com.example.demo.service;

import com.example.demo.dao.ContainerDao;
import com.example.demo.entity.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    private ContainerDao containerDao;

    @Override
    public Container save(Container container) {
        return containerDao.save(container);
    }

    @Override
    public void delete(Integer id) {
        containerDao.deleteById(id);
    }

    @Override
    public Container findByConId(Integer id) {
        return containerDao.getOne(id);
    }

    @Override
    public Container findBynull() {
        List<Container> containerList=containerDao.findbynull();
        if (null!=containerList&&containerList.size()>0){
            return containerList.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<Container> findConAll(){

        return  containerDao.findAll();
    }
    @Override
    public  List<Container>  check(String code){
        return  containerDao.findbyCode(code);

    }


}
