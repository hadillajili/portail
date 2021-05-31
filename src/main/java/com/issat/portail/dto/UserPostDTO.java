package com.issat.portail.dto;

import com.issat.portail.entity.Category;
import com.issat.portail.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {

    @NotNull
    private String description;
    private String imageUrl;
    @NotNull
    private String user;
    @NotNull
    private String category;
}
