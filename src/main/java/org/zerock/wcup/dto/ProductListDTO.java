package org.zerock.wcup.dto;

import lombok.Data;

@Data
public class ProductListDTO {
    //p.pno, p.pname, p.price, pi.fileName
    private Long pno;
    private String pname;
    private int price;
    private String fileName;

    public ProductListDTO(Long pno, String pname, int price, String fileName) {
        this.pno = pno;
        this.pname = pname;
        this.price = price;
        this.fileName = fileName;
    }
}
