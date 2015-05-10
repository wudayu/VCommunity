package com.vcommunity.server.file.utils;

import com.vcommunity.server.modules.utils.PropertiesLoader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author James
 */
public class UploadUtils {


    public static final String uploadPath = null;
    public static PropertiesLoader propertiesLoader = new PropertiesLoader("classpath:application.properties");

    /**
     * 获得文件名的UUID
     * 生成的uuid其实并没有自己去封装的好用
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static List<String> uploadFile(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        String fileId = null;
        List<String> fileIds = new ArrayList<>();
        if (isMultipartContent) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 出现Exception则向上抛出
            List<FileItem> items = upload.parseRequest(request);
            for (Iterator<FileItem> iterator=items.iterator(); iterator.hasNext();) {
                FileItem item = iterator.next();
                InputStream inputStream = item.getInputStream();
                String fileName = item.getName();
                // 得到当前文件扩展名
                String fileExtension = fileName.substring(fileName.lastIndexOf("."));
                fileId = getUUID();
                fileName = fileId + fileExtension;
                // 存储的路径为application-file.properties当中配置的路径+当前时间的路径
                // 例如properties当中配置的 D:\\那么这里的路径就为D:\\2014\\08\\07
                String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
                String savePath = propertiesLoader.getProperty("file.path") + "/" + datePath + "/";
                File file = new File(savePath);

                if (!file.exists()) {
                    file.mkdirs();
                }

                String trueFile = savePath + fileName;
                file = new File(trueFile);

                // 将数据存入至本地的硬盘内
                FileOutputStream out = new FileOutputStream(file);

                int byteRead = 0;
                byte[] buffer = new byte[8192];
                while ((byteRead = inputStream.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, byteRead);
                }

                inputStream.close();
                out.flush();
                out.close();

                fileId = fileName;
                fileIds.add(fileId);

                break;

            }
        }

        return fileIds;
    }

    public static String uploadFile(InputStream inputStream) throws FileUploadException, IOException {
        String fileId = null;
        fileId = getUUID();
        String fileName = fileId + ".jpg";
        // 存储的路径为application-file.properties当中配置的路径+当前时间的路径
        // 例如properties当中配置的 D:\\那么这里的路径就为D:\\2014\\08\\07
        String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String savePath = propertiesLoader.getProperty("file.path") + "/" + datePath + "/";
        File file = new File(savePath);

        if (!file.exists()) {
            file.mkdirs();
        }

        String trueFile = savePath + fileName;
        file = new File(trueFile);

        // 将数据存入至本地的硬盘内
        FileOutputStream out = new FileOutputStream(file);

        int byteRead = 0;
        byte[] buffer = new byte[8192];
        while ((byteRead = inputStream.read(buffer, 0, 8192)) != -1) {
            out.write(buffer, 0, byteRead);
        }

        inputStream.close();
        out.flush();
        out.close();

        fileId = fileName;

        return fileId;
    }

    public static byte[] getFileContent(String path) throws IOException {
        String fileName = propertiesLoader.getProperty("file.path") + "/" + path;

        File f = new File(fileName);
        if(!f.exists()){
            throw new FileNotFoundException(fileName);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int)f.length());
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while(-1 != (len = in.read(buffer,0,buf_size))){
                bos.write(buffer,0,len);
            }
            return bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally{
            try{
                in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    public static byte[] getFileContent2(String path) throws IOException {

        File f = new File(path);
        if(!f.exists()){
            throw new FileNotFoundException(path);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int)f.length());
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while(-1 != (len = in.read(buffer,0,buf_size))){
                bos.write(buffer,0,len);
            }
            return bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally{
            try{
                in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }


}
