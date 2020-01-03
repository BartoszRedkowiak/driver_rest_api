package org.exercise.driver_rest_api.user;

import org.exercise.driver_rest_api.tutorial.Tutorial;
import org.exercise.driver_rest_api.tutorial.TutorialDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController()
@RequestMapping(value = "/api/tutorials", produces = "application/json")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    private UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User fromDto(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @GetMapping("/api/users/{username}")
    public ResponseEntity userProfile(@PathVariable String username) throws EntityNotFoundException {
        User user = userService.findByUsername(username);
        return ResponseEntity.status(200).body(toDto(user));
    }

    @PostMapping("/api/users")
    public ResponseEntity newUser(UserDto userDto){
        return null;
    }


}
