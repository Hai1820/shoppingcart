package com.myclass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String title;
    private String summary;
    @Column(length = 10)
    private String type;

    private Date createdAt;
    private Date updatedAt;
    private String content;
    private String image;

    @PrePersist
    protected void onCreatedAt(){
        this.createdAt= new Date();
    }
    @PreUpdate
    protected void onUpdatedAt(){
        this.updatedAt = new Date();
    }
}
