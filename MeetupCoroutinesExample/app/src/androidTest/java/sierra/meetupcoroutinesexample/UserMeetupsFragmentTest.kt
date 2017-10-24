package sierra.meetupcoroutinesexample

import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Copyright (C) 2017 Mauricio Sierra
 */
class UserMeetupsFragmentTest {

    @Test
    fun testPopulateData() {
        val fragment = UserMeetupsFragment()
        runBlocking {
            fragment.populateData()
        }
    }

}