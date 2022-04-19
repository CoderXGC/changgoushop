package com.ylesb.utils;
/**
 * @title: FastDFSUtil
 * @projectName changgou
 * @description: TODO
 * @author White
 * @site : [www.ylesb.com]
 * @date 2022/4/1910:52
 */

import com.ylesb.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @className    : FastDFSUtil
 * @description  : [描述说明该类的功能]  
 * @author       : [XuGuangchao]
 * @site         : [www.ylesb.com]
 * @version      : [v1.0]
 * @createTime   : [2022/4/19 10:52]
 * @updateUser   : [XuGuangchao]
 * @updateTime   : [2022/4/19 10:52]
 * @updateRemark : [描述说明本次修改内容] 
 */

public class FastDFSUtil {
    static {

        try {
            String filename= new ClassPathResource("fdfs_client.conf").getPath();
           ClientGlobal.init("filename");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    public static void fileUpload(FastDFSFile file) throws IOException, MyException {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        storageClient.upload_file(file.getContent(),file.getExt(),meta_list);
    }
}
