package com.kendo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author kendone
 */
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String email = user.getEmail();
        if ("kendo@163.com".equals(email)) {
            errors.rejectValue("email", "email.exists",
                    new Object[]{"email"}, "Email " + email + " is already in use"
            );
        }
    }
}
