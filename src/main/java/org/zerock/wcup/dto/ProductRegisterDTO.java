package org.zerock.wcup.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ProductRegisterDTO {

    private Long pno;

    private Long sno;

    private String pname;

    private int price;

    //브라우저가 보낸 파일 데이터
    private java.util.List<MultipartFile> files;

    //서버에 업로드된 파일 이름들
    private java.util.List<String> uploadedFileNames;



}
