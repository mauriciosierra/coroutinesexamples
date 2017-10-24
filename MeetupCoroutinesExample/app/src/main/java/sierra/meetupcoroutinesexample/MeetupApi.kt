package sierra.meetupcoroutinesexample

/**
 * Copyright (C) 2017 Mauricio Sierra
 */
interface MeetupApi {

    suspend fun getCurrentUser() : User
    suspend fun getUserMeetups(userId : String) : List<Meetup>

}