package com.ylesb.service;
/**
 * @title: BrandService
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1716:20
 */

import com.ylesb.pojo.Brand;

import java.util.List;

/**
 * @className    : BrandService
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 16:20]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 16:20]
 * @updateRemark : [描述说明本次修改内容] 
 */
public interface BrandService {
   List<Brand> findAll();
   Brand findById(Integer id);
   void add(Brand brand);
   void update(Brand brand);
   void delete(Integer id);
   List<Brand> findList(Brand brand);

}

