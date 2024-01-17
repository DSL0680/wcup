package org.zerock.wcup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.wcup.util.CustomFileUtil;

@Controller
@Log4j2
@RequiredArgsConstructor
public class UploadTestController {

    private final CustomFileUtil fileUtil;

    @PostMapping("/upload")
    public void upload(java.util.List<MultipartFile> files){

       log.info("---------------");
       log.info(files);

       java.util.List<String> uploadFileNames
                = fileUtil.saveFiles(files);

       log.info(uploadFileNames);



    }//end method

    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> view(@PathVariable("fileName") String fileName) {

        return fileUtil.getFile(fileName);
    }
}
