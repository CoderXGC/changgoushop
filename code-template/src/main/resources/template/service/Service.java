package ${package_service};
import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @className    : ${Table}Service
 * @description  : [${Table}业务层接口]
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/17 20:29]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/17 20:29]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface ${Table}Service {

    /***
     * ${Table}多条件分页查询
     * @param ${table}
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size);

    /***
     * ${Table}分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(int page, int size);

    /***
     * ${Table}多条件搜索方法
     * @param ${table}
     * @return
     */
    List<${Table}> findList(${Table} ${table});

    /***
     * 删除${Table}
     * @param id
     */
    void delete(${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table}
     */
    void update(${Table} ${table});

    /***
     * 新增${Table}
     * @param ${table}
     */
    void add(${Table} ${table});

    /**
     * 根据ID查询${Table}
     * @param id
     * @return
     */
     ${Table} findById(${keyType} id);

    /***
     * 查询所有${Table}
     * @return
     */
    List<${Table}> findAll();
}
