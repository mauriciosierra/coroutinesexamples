package sierra.meetupcoroutinesexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class UserMeetupsFragment : Fragment() {

    private val api : MeetupApi
    private val userId : String
    private var updateJob : Job? = null


    init {
        api = MockMeetupApiImpl()
        userId = "12345"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        updateJob = launch (UI) {
            populateData()
        }
    }

    override fun onPause() {
        updateJob?.cancel()
        super.onPause()
    }

    suspend fun populateData() {
        progress_indicator.visibility = VISIBLE

        val user = fetchCurrentUser()
        updateUserName(user)

        val meetups = fetchMeetupsForUser(user)
        updateMeetups(meetups)

        progress_indicator.visibility = GONE
    }

    suspend fun fetchCurrentUser() : User {
        return async {
            api.getCurrentUser()
        }.await()
    }

    suspend fun fetchMeetupsForUser(user: User) : List<Meetup> {
        return async {
            api.getUserMeetups(user.id)
        }.await()
    }

    fun updateUserName(user: User) {
        user_name.text = getString(R.string.name_format, user.firstName, user.lastName)
    }

    fun updateMeetups(meetups: List<Meetup>) {
        meetups_text.text = meetups.joinToString(separator = "\n- ", prefix = "- ")
    }

}