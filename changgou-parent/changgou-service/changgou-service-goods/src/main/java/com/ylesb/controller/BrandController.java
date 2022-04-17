package com.ylesb.controller;
/**
 * @title: BrandController
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1716:21
 */

import com.github.pagehelper.PageInfo;
import com.ylesb.pojo.Brand;
import com.ylesb.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className    : BrandController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 16:21]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 16:21]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brandList= brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询所有成功",brandList);
    }
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "根据id查询成功", brand);
    }
     @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id")Integer id,@RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改成功");
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
    @PostMapping (value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"条件搜索查询成功",brands);
    }
    @GetMapping (value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
       PageInfo<Brand> pageInfo = brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK,"分页查询成功",pageInfo);
    }
}
