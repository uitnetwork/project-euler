package com.uitnetwork.pe.solution

import org.junit.Rule
import org.junit.rules.Timeout

abstract class AbstractPESolutionTest {
    @Rule
    @JvmField
    var globalTimeout: Timeout = Timeout.millis(200)
}