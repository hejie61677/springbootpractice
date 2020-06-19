package com.hejie.springbootpractice.controller;

import com.hejie.springbootpractice.util.FileUtil;
import com.hejie.springbootpractice.util.FormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @Program: springbootpractice
 * @Description: 控制器(文件上传)
 * @Author: hejie
 * @Create: 2020-05-21 09:17
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping(value = "/uploadSubmit", method = RequestMethod.POST)
    public String uploadSubmit(Model model, HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
        try {
            String fileName = FormatUtil.formatDateFileName(new Date()) + "." + FileUtil.getFileSuffix(file.getOriginalFilename());
            String targetFileName = "E:\\myResourceLibrary\\TEMP\\log\\upLoadDir" + File.separator + fileName;
            File targetFile = new File(targetFileName);
            targetFile.getParentFile().mkdirs();
            file.transferTo(targetFile);
            model.addAttribute("fileName", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "uploadSuccess";
    }

    @GetMapping(value = "/loadFile/{fileName}")
    public void loadFile(@PathVariable(value = "fileName") String fileName, HttpServletResponse response) {
        try {
            FileInputStream fis = new FileInputStream("E:\\myResourceLibrary\\TEMP\\log\\upLoadDir" + File.separator +fileName);
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int num;
            while ((num = fis.read(buffer)) != -1) {
                os.write(buffer, 0, num);
                os.flush();
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
