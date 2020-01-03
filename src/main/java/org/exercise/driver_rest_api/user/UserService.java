package org.exercise.driver_rest_api.user;

public interface UserService {

    User getOne(Long id);
    User createOrUpdate (User user);
    void delete(Long id);
    User findByUsername(String username);

}
