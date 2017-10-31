package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUpload {
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void upload(HttpServletRequest request,
                       HttpServletResponse response, ModelMap model) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 得到上传的文件
        MultipartFile mFile = multipartRequest.getFile("file");

        // 得到上传服务器的路径
        String path = request.getSession().getServletContext()
                .getRealPath("/WEB-INF/upload/");
//        // 得到上传的文件的文件名0
        String filename = mFile.getOriginalFilename();
        byte[] b = mFile.getBytes();
        path += "\\" + filename;
//        // 文件流写到服务器端
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(b);
        outputStream.close();
    }
}
