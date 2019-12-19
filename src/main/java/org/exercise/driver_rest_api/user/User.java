package org.exercise.driver_rest_api.user;

import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.tutorial.Tutorial;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "creator")
    private List<Tutorial> tutorials;


}
