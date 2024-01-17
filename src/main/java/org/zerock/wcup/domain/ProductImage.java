package org.zerock.wcup.domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private int ord;
    private String fileName;
}
