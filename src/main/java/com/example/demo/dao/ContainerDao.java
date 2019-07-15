package com.example.demo.dao;
import com.example.demo.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ContainerDao extends  JpaRepository<Container,Integer> {
    @Query(value ="select * from Container  cs where cs.con_status='0' ",nativeQuery = true)
    List<Container>findbynull();

    @Query(value ="select * from Container  cs where cs.con_auth_code=? ",nativeQuery = true)
      List<Container>findbyCode(String code);

}
