package com.QAEmre.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

}
