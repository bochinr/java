package com.javaee.ex08.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {
    private List<String> fileList;
    @RequestMapping("/to_file_list")
    public String toFileList(){
        if (fileList == null) fileList = new ArrayList<>();
        return "file/file_list";
    }
    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request, MultipartFile[] files,
                             HttpSession session) throws IOException {
        if (files != null && files.length > 0){
            String path = request.getServletContext().getRealPath("/files/");
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getOriginalFilename();
                File filePath = new File(path, fileName);
                if (!filePath.getParentFile().exists()){
                    filePath.getParentFile().mkdirs();
                }
                files[i].transferTo(new File(path + File.separator + fileName));
                fileList.add(fileName);
            }
            session.setAttribute("fileList", fileList);
            session.setAttribute("uploadStatus", "OK");
        }
        else
            session.setAttribute("uploadStatus", "ERROR");
        return "redirect:to_file_list";
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               String fileName) throws IOException {
        String path = request.getServletContext().getRealPath("/files/");
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName =
                new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment",
                downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
