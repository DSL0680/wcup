package org.zerock.wcup.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(exclude = {"store", "images"})
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    private String pname;

    private int price;

    @ElementCollection
    @Builder.Default
    private Set<ProductImage> images = new HashSet<>();

    public void addImage(String fileName){
        images.add(new ProductImage(images.size(), fileName));
    }

    public void clearImages(){
        this.images.clear();
    }


}













