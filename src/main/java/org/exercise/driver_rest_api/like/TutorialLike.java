package org.exercise.driver_rest_api.like;

import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.tutorial.Tutorial;
import org.exercise.driver_rest_api.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TutorialLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tutorial tutorial;

}
