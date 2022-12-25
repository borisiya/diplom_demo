package com.Project.diplom.shared.validation;

import java.util.List;

public interface Validator<E> {
    List<Error> validate(E entity);
}
