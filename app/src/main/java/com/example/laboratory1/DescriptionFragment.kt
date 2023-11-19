package com.example.laboratory1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.laboratory1.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {
    private val args: DescriptionFragmentArgs by navArgs()
    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            tvName.text = getString(R.string.name_template, args.filmName)
            tvAge.text = getString(R.string.rating_template, args.filmrating)
            tvDescription.text = getString(R.string.description_template, args.description)
            imageView2.setImageResource(args.filmImage)

        }
    }
}