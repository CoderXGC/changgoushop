package com.ylesb.file;
/**
 * @title: FastDFSFile
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1910:48
 */

import java.io.Serializable;

/**
 * @className    : FastDFSFile
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/19 10:48]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/19 10:48]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class FastDFSFile implements Serializable {
    private static final long serialVersionUID = -5833891451145224550L;
    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;
    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
    public FastDFSFile(String name, byte[] content, String ext, String md5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.md5 = md5;
        this.author = author;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
