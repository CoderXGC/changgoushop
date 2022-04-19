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
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
           ClientGlobal.init(filename);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    public static String[] fileUpload(FastDFSFile file) throws IOException, MyException {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String[] uploads=storageClient.upload_file(file.getContent(),file.getExt(),meta_list);

        return uploads;
    }
    public static FileInfo getFile(String groupName,String remoteFileName) throws IOException, MyException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        return  storageClient.get_file_info(groupName,remoteFileName);
    }
    public static InputStream downloadFile(String groupName, String remoteFileName) throws IOException, MyException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);
        return new ByteArrayInputStream(bytes);

    }
    public static void deleteFile(String groupName, String remoteFileName) throws IOException, MyException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        storageClient.delete_file(groupName, remoteFileName);

    }
    public static StorageServer getStorage() throws IOException, MyException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorage(trackerServer);

    }
    public static void main(String[] args) throws IOException, MyException {
        FileInfo fileInfo=getFile("group1","M00/00/00/wKiJsGJeRauABOtBAAM8owwHOLU023.png");
       System.out.println(fileInfo.getSourceIpAddr()); //获取文件的存储服务器IP地址
        System.out.println(fileInfo.getFileSize()); //获取文件的大小
        InputStream is=downloadFile("group1","M00/00/00/wKiJsGJeRauABOtBAAM8owwHOLU023.png");
        FileOutputStream fos=new FileOutputStream("D:\\test.png");
        byte[] bytes=new byte[1024];
        while (is.read(bytes)!=-1){
            fos.write(bytes);
        }
        fos.flush();
        fos.close();
        is.close();



    }


}
