package com.ylesb.goods.pojo;
/**
 * @title: Goods
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/249:34
 */

import java.io.Serializable;
import java.util.List;

/**
 * @className    : Goods
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/24 9:34]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/24 9:34]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;
    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }



    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }
}
