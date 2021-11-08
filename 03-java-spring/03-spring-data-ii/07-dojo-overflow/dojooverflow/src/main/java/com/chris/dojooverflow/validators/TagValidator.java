package com.chris.dojooverflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.chris.dojooverflow.models.Question;

@Component
public class TagValidator {
	 // 1
 
    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }
    
    // 2

    public void validate(Object target, Errors errors) {
        Question question = (Question) target;
        
        String[] tags = question.getUserTags().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("userTags", "too many", "Must be 3 or less");
        }
    }
}
