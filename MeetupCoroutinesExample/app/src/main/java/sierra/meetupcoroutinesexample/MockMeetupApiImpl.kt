package sierra.meetupcoroutinesexample

import kotlinx.coroutines.experimental.delay
import java.util.concurrent.TimeUnit

/**
 * Copyright (C) 2017 Mauricio Sierra
 */
class MockMeetupApiImpl : MeetupApi {

    override suspend fun getCurrentUser(): User {
        delay(1, TimeUnit.SECONDS)
        return User("12345", "Mauricio", "Sierra")
    }

    override suspend fun getUserMeetups(userId: String): List<Meetup> {
        delay(2, TimeUnit.SECONDS)
        return listOf(
                Meetup("1", "Kotlin Toronto"),
                Meetup("2", "Ottawa Android")
        )
    }

}