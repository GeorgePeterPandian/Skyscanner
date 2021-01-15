package com.android.skyscanner.uk

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.android.skyscanner.core.extensions.activityViewModel
import com.android.skyscanner.core.presentation.Resource
import com.android.skyscanner.uk.databinding.ActivityMainBinding
import com.android.skyscanner.uk.flights.di.FlightsUIInjector
import com.android.skyscanner.uk.flights.list.FlightsAdapter
import com.android.skyscanner.uk.flights.model.FlightsUIM
import com.android.skyscanner.uk.flights.model.FlightsViewModel.Companion.CONNECTION_ERROR

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FlightsAdapter

    private lateinit var viewBinding: ActivityMainBinding

    private val viewModel by activityViewModel(FlightsUIInjector.component.getFlightsViewModelFactory())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        setUpToolBar()
        setupRecyclerView()
        setUpOnClickListeners()
        with(viewModel) {
            flightsLiveData.observe(this@MainActivity, Observer(::updateUI))
            loadBreeds()
        }
    }

    private fun setUpToolBar() {
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setTitle(R.string.app_name)
    }

    private fun setupRecyclerView() {
        with(viewBinding) {
            adapter = FlightsAdapter().also { recyclerView.adapter = it }
            recyclerView.setHasFixedSize(true)
        }
    }

    private fun setUpOnClickListeners() {
        with(viewBinding) {
            errorView.setOnRetryClickListener { viewModel.retry() }
        }
    }

    private fun updateUI(resource: Resource<List<FlightsUIM>>) {
        when (resource.state) {
            is Resource.State.Loading -> onShowLoading()
            is Resource.State.Success -> onShowData(resource)
            is Resource.State.Error -> onShowError(resource.message)
        }
    }

    private fun onShowLoading() {
        with(viewBinding) {
            loading.visibility = VISIBLE
            errorView.visibility = GONE
            emptyView.visibility = GONE
            recyclerView.visibility = GONE
        }
    }

    private fun onShowData(resource: Resource<List<FlightsUIM>>) {
        with(viewBinding) {
            loading.visibility = GONE
            errorView.visibility = GONE
            val flights = resource.data.orEmpty()
            when {
                flights.isNotEmpty() -> {
                    recyclerView.visibility = VISIBLE
                    emptyView.visibility = GONE
                    adapter.submitList(resource.data)
                }
                else -> {
                    recyclerView.visibility = GONE
                    emptyView.visibility = VISIBLE
                }
            }
        }
    }


    private fun onShowError(errorMessage: String?) {
        with(viewBinding) {
            loading.visibility = GONE
            errorView.visibility = VISIBLE
            emptyView.visibility = GONE
            recyclerView.visibility = GONE
        }
        when (errorMessage) {
            CONNECTION_ERROR -> setConnectionError()
            else -> setUnknownError()
        }
    }

    private fun setUnknownError() {
        with(viewBinding.errorView) {
            setTitle(context.getString(R.string.error_view_title_generic))
            setSubtitle(context.getString(R.string.error_view_subtitle_generic))
        }
    }

    private fun setConnectionError() {
        with(viewBinding.errorView) {
            setTitle(context.getString(R.string.error_view_connection_title))
            setSubtitle(context.getString(R.string.error_view_connection_description))
        }
    }
}