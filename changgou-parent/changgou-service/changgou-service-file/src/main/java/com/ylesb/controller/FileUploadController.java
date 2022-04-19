package com.ylesb.controller;
/**
 * @title: FileUploadController
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1911:29
 */

import com.ylesb.file.FastDFSFile;
import com.ylesb.utils.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.csource.common.MyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @className    : FileUploadController
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/19 11:29]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/19 11:29]
 * @updateRemark : [描述说明本次修改内容] 
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class FileUploadController {
    @PostMapping
    public Result upload(@RequestParam("file")MultipartFile file) throws IOException, MyException {
        FastDFSFile fastDFSFile = new FastDFSFile(file.getOriginalFilename(), file.getBytes(), StringUtils.getFilenameExtension(file.getOriginalFilename()));
        String[] uploads=FastDFSUtil.fileUpload(fastDFSFile);
        String url = "http://192.168.137.176:8080/"+uploads[0]+"/"+uploads[1];

        return new Result<>(true, StatusCode.OK,"上传成功",url);
    }
}
