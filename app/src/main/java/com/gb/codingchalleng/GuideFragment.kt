package com.gb.codingchalleng

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_guides.*

class GuideFragment: Fragment() {

    private lateinit var viewModel: GuideViewModel
    private lateinit var guideAdapter: GuideRecyclerAdapter

    companion object {
        fun newInstance(): GuideFragment {
            return GuideFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_guides, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.getGuides()
    }

    private fun subscribeObservers() {
        viewModel = ViewModelProvider(this)[GuideViewModel::class.java]
        viewModel.guideLiveData.observe(viewLifecycleOwner, ResourceViewObserver(getGuidesResourceView))
    }

    private fun initRecyclerView(list: Guides) {
        guideAdapter = GuideRecyclerAdapter(list)
        guideRecyclerView.layoutManager = LinearLayoutManager(this@GuideFragment.context)
        guideRecyclerView.adapter = guideAdapter
    }

    private val getGuidesResourceView = object : Resource.ResourceView<Guides> {
        override fun showData(data: Guides) {
            initRecyclerView(data)
        }
        override fun showLoading(isLoading: Boolean) { Log.i("JSONListFragment", "loading: $isLoading") }
        override fun showError(error: Throwable) { Log.i("JSONListFragment",
            error.message.toString()
        ) }
    }
}