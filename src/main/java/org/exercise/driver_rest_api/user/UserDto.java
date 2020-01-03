package org.exercise.driver_rest_api.user;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.tutorial.Tutorial;

import java.util.List;

@Getter
@Setter
@ApiModel(description = "An object with user information")
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private List<Tutorial> tutorials;



}
