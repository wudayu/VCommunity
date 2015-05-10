package com.vcommunity.android.rest;

import com.vcommunity.android.entity.Attachment;
import com.vcommunity.android.service.AttachmentService;
import com.vcommunity.server.file.utils.UploadUtils;
import com.vcommunity.server.modules.utils.PropertiesLoader;
import com.vcommunity.server.rest.Message;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author James Chow
 * @createdate 2015/4/25
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Controller
@RequestMapping(value = { "/api" })
public class UploadFileRestController {

    private static Logger logger = LoggerFactory.getLogger(UploadFileRestController.class);

    public static PropertiesLoader propertiesLoader = new PropertiesLoader("classpath:application-mimetype.properties");

    private AttachmentService attachmentService;

    @RequestMapping("/upload/file")
    public @ResponseBody Message upload(HttpServletRequest request, HttpServletResponse response) {
        Message message = new Message();
        try {
            List<String> uploadFileNames = UploadUtils.uploadFile(request, response);
            message.setMessage("Upload file success.");
            message.setSuccess(true);
            message.setMessageType(Message.MESSAGE_TYPE_NORMAL);

            List<String> fileIds = new ArrayList<>();
            uploadFileNames.forEach(fileId -> {
                String fileName = fileId;
                if (fileId.indexOf(".") >= 0) {
                    fileId = fileId.substring(0, fileId.lastIndexOf("."));
                }
                fileIds.add(fileId);
                Attachment attachment = new Attachment();
                attachment.setUuid(fileId);
                attachment.setModifyDate(new Date());
                attachment.setCreateDate(new Date());
                attachment.setFileName(fileName);

                String extension = null;
                if (fileName.lastIndexOf(".") >= 0) {
                    extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                }
                String mimeType = propertiesLoader.getProperty(extension);
                attachment.setMimeType(mimeType);

                attachmentService.save(attachment);

            });

            message.setData(fileIds);
        } catch (FileUploadException e) {
            logger.error(e.getMessage());
            message.setSuccess(false);
            message.setMessage(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
            message.setSuccess(false);
            message.setMessage(e.getMessage());
        }

        return message;
    }

    @RequestMapping("/download/file/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") String id) {
        Attachment attachment = attachmentService.findOne(id);
        String filePath = new SimpleDateFormat("yyyy/MM/dd/").format(attachment.getCreateDate()) + attachment.getFileName();
        byte[] content = null;
        ResponseEntity<byte[]> entity = null;
        try {
            content = UploadUtils.getFileContent(filePath);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", attachment.getMimeType());
            httpHeaders.setContentDispositionFormData("attachment", new String(attachment.getFileName().getBytes(), "iso8859-1"));
            entity = new ResponseEntity<>(content, httpHeaders, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return entity;
    }

    @Autowired
    public void setAttachmentService(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    public AttachmentService getAttachmentService() {
        return attachmentService;
    }
}
