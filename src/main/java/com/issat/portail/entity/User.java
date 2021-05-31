package com.issat.portail.entity;

import com.issat.portail.utils.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Status status;

    @DBRef
    private List<Category> categories = new ArrayList<>();

    @DBRef
    private List<User> friends = new ArrayList<>();


    public void addCategory(Category category){
        categories.add(category);
    }
    public void addFriend(User friend){
        friends.add(friend);
    }
    public void deleteCategory(Category category){
        categories.remove(category);
    }
}
