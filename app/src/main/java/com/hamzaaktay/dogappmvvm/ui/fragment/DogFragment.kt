package com.hamzaaktay.dogappmvvm.ui.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hamzaaktay.dogappmvvm.DogFragmentViewModel
import com.hamzaaktay.dogappmvvm.DogViewModelFactory
import com.hamzaaktay.dogappmvvm.R
import com.hamzaaktay.dogappmvvm.databinding.FragmentDogBinding
import com.hamzaaktay.dogappmvvm.repository.Repository
import com.hamzaaktay.dogappmvvm.ui.base.BaseFragment
import com.hamzaaktay.dogappmvvm.utils.extensions.load
import com.hamzaaktay.dogappmvvm.utils.extensions.setVisible


class DogFragment : BaseFragment<FragmentDogBinding>(FragmentDogBinding::inflate) {

    private lateinit var viewModel : DogFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = DogViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory)[DogFragmentViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        backgroundAnimation()

        setImage()



    }

    private fun setImage() {

        viewModel.getDogImage()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                with(binding.ivRandomDog) {
                    load(response.body()?.url.toString(), requireContext())
                    setVisible()
                }
                Log.e("Response", response.body()?.status.toString())
            } else {
                Log.e("Response", response.errorBody().toString())
            }

        })

    }

    private fun backgroundAnimation() {
        val animationDrawable: AnimationDrawable = binding.fragmentDog.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }

    }


}