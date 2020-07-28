package com.example.weatherapp.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.Status
import com.example.weatherapp.ui.base.MainViewModel
import kotlinx.android.synthetic.main.search_fragment.view.*

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    val viewModel by lazy { MainViewModel.get<SearchViewModel>(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, Observer {
                when(it.status){
                    Status.SUCCESS -> Toast.makeText(context,"Successfully added",Toast.LENGTH_SHORT).show()
                    Status.LOADING -> {}
                    Status.ERROR -> Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                }
            }
        )
        view.searchButton.setOnClickListener {
            viewModel.searchWeatherByCity(view.searchView.query.toString())
        }
        view.search_toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}