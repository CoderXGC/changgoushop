package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className    : PrefFeign
 * @description  : [描述说明该类的功能]
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 20:29]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 20:29]
 * @updateRemark : [描述说明本次修改内容]
 */
@FeignClient(name="goods")
@RequestMapping("/pref")
public interface PrefFeign {

    /***
     * Pref分页条件搜索实现
     * @param pref
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Pref pref, @PathVariable  int page, @PathVariable  int size);

    /***
     * Pref分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param pref
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Pref>> findList(@RequestBody(required = false) Pref pref);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Pref数据
     * @param pref
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Pref pref,@PathVariable Integer id);

    /***
     * 新增Pref数据
     * @param pref
     * @return
     */
    @PostMapping
    Result add(@RequestBody Pref pref);

    /***
     * 根据ID查询Pref数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Pref> findById(@PathVariable Integer id);

    /***
     * 查询Pref全部数据
     * @return
     */
    @GetMapping
    Result<List<Pref>> findAll();
}