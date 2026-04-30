package com.calcados51.app

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test to verify app context is set up correctly.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun appContext_hasCorrectPackageName() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.calcados51.app", appContext.packageName)
    }
}
