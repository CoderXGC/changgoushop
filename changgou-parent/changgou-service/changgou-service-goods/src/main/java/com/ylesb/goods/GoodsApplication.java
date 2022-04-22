package com.ylesb.goods;
/**
 * @title: GoodsApplication
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1716:04
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @className    : GoodsApplication
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 16:04]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 16:04]
 * @updateRemark : [描述说明本次修改内容] 
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ylesb.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
