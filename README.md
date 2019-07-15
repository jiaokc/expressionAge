# expressionAge
springboot+jpa+mysql

--创建表
CREATE TABLE `CONTAINER` (  
  `id` int(11) NOT NULL AUTO_INCREMENT ,  
  `con_name` varchar(40) COMMENT '储物格号' NOT NULL ,  
  `con_status` CHAR(1)  NOT NULL  default 0 COMMENT '储物格状态',  
  `con_info` varchar(40) COMMENT  '物品信息', 
  `con_auth_code` varchar(40) COMMENT  '验证码',
  `con_error_message` varchar(40) COMMENT  '错误信息',
  PRIMARY KEY (`id`)  
);

--插入测试数据
INSERT INTO `container` VALUES (1, 'C6R7', '', '', 'dsa', '0');
INSERT INTO `container` VALUES (2, '0XL9', NULL, 'dasdsadsadsa', 'dsad', '1');
INSERT INTO `container` VALUES (3, 'IUQ7', NULL, 'dsdsdsds', 'ccc', '1');
