package org.exercise.driver_rest_api.validator;

import org.exercise.driver_rest_api.tutorial.TutorialDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateTutorialValidator")
public class TutorialValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        TutorialDto tutorial = (TutorialDto) o;
        if (checkInputString(tutorial.getTitle())){
            errors.rejectValue("title", "title.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
