package com.ylesb;
/**
 * @title: FileApplication
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1910:24
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @className    : FileApplication
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/19 10:24]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/19 10:24]
 * @updateRemark : [描述说明本次修改内容] 
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class,args);
    }
}
