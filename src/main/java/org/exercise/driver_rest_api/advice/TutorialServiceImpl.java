package org.exercise.driver_rest_api.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Tutorial createOrUpdate(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    @Override
    public List<Tutorial> getAll() {
        List<Tutorial> tutorials = tutorialRepository.findAll();
        if (tutorials == null){
            throw new EntityNotFoundException("Database does not contain any records");
        }
        return tutorials;
    }

    @Override
    public Page<Tutorial> getPage(Pageable pageable){
        Page<Tutorial> page =  tutorialRepository.findAll(pageable);
        if (page == null){
            throw new EntityNotFoundException("No more pages");
        }
        return page;
    }

    @Override
    public Tutorial getOne(Long id) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);
        if (!tutorial.isPresent()){
            throw new EntityNotFoundException("Database does not contain record with id: " + id);
        }
        return tutorial.get();
    }

    @Override
    public void delete(Long id) {
        tutorialRepository.deleteById(id);
    }
}
