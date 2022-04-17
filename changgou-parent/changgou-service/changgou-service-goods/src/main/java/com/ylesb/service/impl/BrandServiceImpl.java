package com.ylesb.service.impl;
/**
 * @title: BrandServiceImpl
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1716:20
 */

import com.ylesb.dao.BrandMapper;
import com.ylesb.pojo.Brand;
import com.ylesb.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @className    : BrandServiceImpl
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 16:20]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 16:20]
 * @updateRemark : [描述说明本次修改内容] 
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && !brand.getName().equals("")) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            if (brand.getLetter() != null && !brand.getLetter().equals("")) {
                criteria.andEqualTo("letter", "%" + brand.getLetter() + "%");
            }

        }
        return brandMapper.selectByExample(example);
    }
}
