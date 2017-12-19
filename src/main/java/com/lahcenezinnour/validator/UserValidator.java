package com.lahcenezinnour.validator;

import com.lahcenezinnour.domain.Users;
import com.lahcenezinnour.service.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 * Created by lahcen on 6/18/17.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }

    /**
     * Validate the supplied {@code target} object, which must be
     * of a {@link Class} for which the {@link #supports(Class)} method
     * typically has (or would) return {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors.
     *
     * @param target the object that is to be validated (can be {@code null})
     * @param errors contextual state about the validation process (never {@code null})
     * @see ValidationUtils
     */
    @Override
    public void validate(Object target, Errors errors) {
        Users user = (Users) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "NotEmpty");
        if (EmailValidator.getInstance().isValid(user.getUserEmail())) {
            System.out.println("////////");
            errors.rejectValue("userEmail", "Valid.user.email");
        }
        if (userService.findByUserEmail(user.getUserEmail()) != null) {
            errors.rejectValue("userEmail", "Duplicate.user.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFirstName", "NotEmpty");
        if (user.getUserFirstName().length() < 6 || user.getUserFirstName().length() > 32) {
            errors.rejectValue("userFirstName", "Size.user.userFirstName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLastName", "NotEmpty");
        if (user.getUserLastName().length() < 6 || user.getUserLastName().length() > 32) {
            errors.rejectValue("userLastName", "Size.user.userLastName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "NotEmpty");
        if (user.getUserPassword().length() < 8 || user.getUserPassword().length() > 32) {
            errors.rejectValue("userPassword", "Size.user.userPassword");
        }
       /* System.out.println(user.getUserPasswordConfirm());
        System.out.println(user.getUserPassword());
        if (!user.getUserPasswordConfirm().equals(user.getUserPassword())) {
            errors.rejectValue("userPasswordConfirm", "These passwords don't match.");
        }*/
    }
}
