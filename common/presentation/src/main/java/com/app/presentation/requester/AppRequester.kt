package com.app.presentation.requester

import androidx.fragment.app.FragmentActivity

class AppRequester(activity: FragmentActivity) {

    private val progressLoading = ProgressLoader(activity)

    val requester by lazy {

        val presenter = object : Presenter {
            override fun showLoading() {
                progressLoading.show()
            }

            override fun hideLoading() {
                progressLoading.hide()
            }

            override fun showError() {

            }

        }

        CoroutinesRequester(presenter)
    }

}