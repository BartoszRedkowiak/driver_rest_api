package org.exercise.driver_rest_api.advice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Advice {

    @Id
    private String id;
    private String title;
    private String content;
    private String imgPath;
    private LocalDateTime created;


}
