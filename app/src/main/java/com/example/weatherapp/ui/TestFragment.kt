package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.R
import com.example.weatherapp.Resource
import com.example.weatherapp.Status
import com.example.weatherapp.ui.base.MainViewModel
import kotlinx.android.synthetic.main.test_fragment.view.*

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }
    val viewModel by lazy { MainViewModel.get<TestViewModel>(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    view.test.text = (it.data as WeatherResponse).toString()

                }
            }
        })
    }
}