package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className    : UndoLogFeign
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
@RequestMapping("/undoLog")
public interface UndoLogFeign {

    /***
     * UndoLog分页条件搜索实现
     * @param undoLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) UndoLog undoLog, @PathVariable  int page, @PathVariable  int size);

    /***
     * UndoLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param undoLog
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<UndoLog>> findList(@RequestBody(required = false) UndoLog undoLog);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改UndoLog数据
     * @param undoLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody UndoLog undoLog,@PathVariable Long id);

    /***
     * 新增UndoLog数据
     * @param undoLog
     * @return
     */
    @PostMapping
    Result add(@RequestBody UndoLog undoLog);

    /***
     * 根据ID查询UndoLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<UndoLog> findById(@PathVariable Long id);

    /***
     * 查询UndoLog全部数据
     * @return
     */
    @GetMapping
    Result<List<UndoLog>> findAll();
}