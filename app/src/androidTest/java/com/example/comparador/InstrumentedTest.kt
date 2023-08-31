package com.example.comparador

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.comparador.view.MainActivity
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainActivityTest {

    @get:Rule
    val rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testResultadoIguales() = runTest {
        onView(
            withId(R.id.editTextUno)
        ).perform(
            typeText("mensaje de prueba"), closeSoftKeyboard()
        )

        onView(
            withId(R.id.editTextDos)
        ).perform(
            typeText("mensaje de prueba"), closeSoftKeyboard()
        )


        onView(
            withId(R.id.button10)
        ).perform(click()
        )



        onView(
            withId(R.id.textView_result_compare)
        ).check(
            matches(withText(R.string.iguales)))

        onView(
            withId(R.id.textView_result_compare)
        ).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
    }

}