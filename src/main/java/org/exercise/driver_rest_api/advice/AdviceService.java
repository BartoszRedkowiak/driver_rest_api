package org.exercise.driver_rest_api.advice;

import java.util.List;
import java.util.Optional;

public interface AdviceService {

    void create(Advice advice);
    List<Advice> getAll();
    Optional<Advice> getOne(String id);
    void update(Advice advice);
    void delete(String id);

}
