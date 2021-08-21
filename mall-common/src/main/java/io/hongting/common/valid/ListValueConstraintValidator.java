package io.hongting.common.valid;

import org.hibernate.validator.internal.engine.validationcontext.ValidatorScopedContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hongting
 * @create 2021 06 22 9:32 AM
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {

    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] values = constraintAnnotation.values();
        if (values.length != 0 ) {
            for (int value : values) {
                set.add(value);
            }
        }
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }
}
