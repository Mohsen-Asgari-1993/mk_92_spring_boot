package ir.maktabsharif92.springboot.base.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, TYPE_USE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = MobileNumber.MobileNumberValidator.class)
@Documented
@SuppressWarnings("unused")
public @interface MobileNumber {

    String message() default "invalid mobileNumber";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean required() default true;

    class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {

        public static final String REGEX = "09\\d{9}";

        private boolean required;

        @Override
        public void initialize(MobileNumber constraintAnnotation) {
            this.required = constraintAnnotation.required();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return required ? checkRequired(value) : checkNotRequired(value);
        }

        private boolean checkRequired(String value) {
            return StringUtils.isNotBlank(value) && value.matches(REGEX);
        }

        private boolean checkNotRequired(String value) {
            return StringUtils.isBlank(value) || value.matches(REGEX);
        }
    }
}
