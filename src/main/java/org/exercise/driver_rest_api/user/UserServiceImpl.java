package org.exercise.driver_rest_api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getOne(Long id) {
        return null;
    }

    @Override
    public User createOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findByUsername(String username) throws EntityNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            throw new EntityNotFoundException("Couldn't find user with given username");
        }
        return user.get();
    }
}
