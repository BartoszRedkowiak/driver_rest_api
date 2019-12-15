package org.exercise.driver_rest_api.advice;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ApiModel(description = "Content of and advice article")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String youTubeUrl;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @PrePersist
    private void prePersist(){ createdDate = LocalDateTime.now();}



}
