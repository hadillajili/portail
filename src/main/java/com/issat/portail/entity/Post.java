package com.issat.portail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String description;
    private String imageUrl;
    @DBRef
    private User user;
    @DBRef
    private Category category;

}
