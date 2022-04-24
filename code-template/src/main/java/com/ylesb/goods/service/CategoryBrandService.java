package com.ylesb.goods.service;
import com.ylesb.goods.pojo.CategoryBrand;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @className    : CategoryBrandService
 * @description  : [CategoryBrand业务层接口]
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 20:29]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 20:29]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface CategoryBrandService {

    /***
     * CategoryBrand多条件分页查询
     * @param categoryBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryBrand> findPage(CategoryBrand categoryBrand, int page, int size);

    /***
     * CategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<CategoryBrand> findPage(int page, int size);

    /***
     * CategoryBrand多条件搜索方法
     * @param categoryBrand
     * @return
     */
    List<CategoryBrand> findList(CategoryBrand categoryBrand);

    /***
     * 删除CategoryBrand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改CategoryBrand数据
     * @param categoryBrand
     */
    void update(CategoryBrand categoryBrand);

    /***
     * 新增CategoryBrand
     * @param categoryBrand
     */
    void add(CategoryBrand categoryBrand);

    /**
     * 根据ID查询CategoryBrand
     * @param id
     * @return
     */
     CategoryBrand findById(Integer id);

    /***
     * 查询所有CategoryBrand
     * @return
     */
    List<CategoryBrand> findAll();
}
