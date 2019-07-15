package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.entity.Container;
import com.example.demo.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * add by jiaokc
 * 20190715
 * 快递柜demo控制器
 */
@RestController
@RequestMapping("/con")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    /**
     * 存货
     * @param container
     */
    @PostMapping("/add") //post请求
    public String save(Container container) {
        System.out.println(container.getId());
        System.out.println(container.getCon_info());
        Container container1=containerService.findByConId(container.getId());
        System.out.println(container1.getId());
        container1.setCon_status("1");//有货物 状态置为1
        container1.setCon_info(container.getCon_info());
        container1.setCon_auth_code(getcode());
        containerService.save(container1);
        return (container1.getId().toString());
    }

    /**
     * 取货
      * @return
     */
   @GetMapping("/query")
   public Container query() {
       Container container=containerService.findBynull();
       if (container==null){
           container=new Container();
           container.setCon_error_message("1");
           return container;
       }
       return container;
   }

    /**
     * 所有货物展示
     * @return
     */
    @GetMapping("/queryAll")
    public List<Container> queryall() {
        return containerService.findConAll();
    }

    /**
     * 取货，假设验证码唯一
     * 校验验证码返回对应货架
     * @return
     */
    @GetMapping("/check/{code}")
    public Container check(@PathVariable String code) {
         List<Container> containerList=containerService.check(code);
         if (containerList!=null&&containerList.size()>0){
             Container container=null;
             container=containerList.get(0);
             container.setCon_status("0");//验证码正确，打开对应货架，设货架状态为0
             container.setCon_info("");//清空货物信息
             containerService.save(container);//更新数据
             return  container;
         }else {
             //验证码不对，前台返回提醒
             Container container=new Container();
             container.setCon_error_message("1");
             return container;
         }
    }
    /**
     * 生成4位验证码
     * @return
     */
   public  String getcode(){

       String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
       StringBuilder sb=new StringBuilder(4);
       for(int i=0;i<4;i++)
       {
           char ch=str.charAt(new Random().nextInt(str.length()));
           sb.append(ch);
       }
      return sb.toString();
   }



}
