package com.myclass.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
   @NotBlank(message = "Title cannot be blank")
    private String title;
   @NotBlank(message = "Summary cannot be blank")
    private String summary;
   @NotBlank(message = "Type cannot be blank")
    private String type;

    private Date createdAt;
    private Date updatedAt;
    @NotBlank(message = "Content cannot be blank")
    private String content;
    private String image;
}
