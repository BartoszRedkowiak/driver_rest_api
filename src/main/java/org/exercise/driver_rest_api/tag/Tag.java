package org.exercise.driver_rest_api.tag;

import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.tutorial.Tutorial;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Tutorial> tutorials;
}
