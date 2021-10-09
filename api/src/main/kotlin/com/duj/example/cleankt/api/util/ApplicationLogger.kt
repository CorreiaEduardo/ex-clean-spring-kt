package com.duj.example.api.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

open class ApplicationLogger {
    protected val logger: Logger = LoggerFactory.getLogger(this::class.java)
}
