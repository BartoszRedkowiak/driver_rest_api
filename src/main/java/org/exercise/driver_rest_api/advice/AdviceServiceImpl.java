package org.exercise.driver_rest_api.advice;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;

    @Autowired
    public AdviceServiceImpl(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    @Override
    public void create(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public List<Advice> getAll() {
        return null;
    }

    @Override
    public Optional<Advice> getOne(String id) {
        return adviceRepository.findById(id);
    }

    @Override
    public void update(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public void delete(String id) {
        adviceRepository.deleteById(id);
    }
}
