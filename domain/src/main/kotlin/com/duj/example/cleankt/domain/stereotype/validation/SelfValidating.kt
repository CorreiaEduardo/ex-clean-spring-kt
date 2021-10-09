package com.duj.example.cleankt.domain.stereotype.validation

import javax.validation.ConstraintViolationException
import javax.validation.Validation
import javax.validation.Validator

abstract class SelfValidating<T> {
    private val validator: Validator

    init {
        val factory = Validation.buildDefaultValidatorFactory()
        validator = factory.validator

        validateSelf()
    }

    @Suppress("UNCHECKED_CAST")
    protected fun validateSelf() {
        val violations = validator.validate(this as T)
        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}