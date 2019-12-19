package org.exercise.driver_rest_api.tutorial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TutorialService {

    Tutorial createOrUpdate(Tutorial tutorial);
    List<Tutorial> getAll();
    Tutorial getOne(Long id);
    Page<Tutorial> getPage(Pageable pageable);
    void delete(Long id);

}
