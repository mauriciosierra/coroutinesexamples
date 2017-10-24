package sierra.meetupcoroutinesexample

/**
 * Copyright (C) 2017 Mauricio Sierra
 */

data class User(val id : String,
                val firstName : String,
                val lastName : String)


data class Meetup(val id : String,
                  val name : String) {

    override fun toString(): String {
        return name
    }

}