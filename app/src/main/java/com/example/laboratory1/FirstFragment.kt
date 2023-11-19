package com.example.laboratory1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.laboratory1.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: FilmAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Film>()
        list.add(Action("John Wick 4", 4, "The former assassin knows how to win a confrontation with the Clan Board. But before the main character can realize his plans, he will have to pass another test in the battle for survival. This time, John accepts a challenge from a new enemy, who, together with his allies, wants to deal with a retired killer.", R.drawable.wick))
        list.add(Comedy("Alone at home", 5, "Eight-year-old Kevin has a large family, and this comes with many difficult moments. Everyone is going to Paris for Christmas, but before the flight, in the terrible confusion, the boy is forgotten at home. Just the day before, Kevin makes a wish - for the family that constantly annoys him to disappear somewhere, and the next morning everything happens exactly as he wants. The boy is left completely alone in a huge house. At first he enjoys his position, but then...", R.drawable.alone))
        list.add(Drama("Top Gun: Maverick", 5, "For more than thirty years, Pete Mitchell, nicknamed Maverick, has been one of the best pilots in the US Navy. The brave pilot tries his best to avoid raising his rank, because he does not want to leave the sky forever and lose the opportunity to fly. Soon the man begins preparing graduates for a special task and meets among them the son of his deceased comrade, Nick Bradshaw...", R.drawable.maverick))
        list.add(Fantasy("Avatar: The Way of Water", 3, "The plot will continue to focus on the Na'vi people, as well as a former earthling in the body of an avatar named Jake Sully, along with Neytiri, his life partner. But this time the main action of the film will take place in the ocean of Pandora. In the frame you can see not only the Omaticaya forest clan, but also the Metkayina sea clan. New characters will also be shown - teenagers of the Na'vi people.", R.drawable.avatar))
        list.add(Horror("Venom", 2, "Journalist Eddie Brock loses his job after interviewing scientist Carlton Drake. Drake's colleague tells him that in his laboratory, a scientist is using an alien creature in experiments on people. A walk there turns into a real nightmare for him: Eddie turns out to be the carrier of an alien symbiote. But Drake doesn't want to give up his property so easily and begins to pursue Brock.", R.drawable.venom))

        adapter = FilmAdapter { animal, position ->
            val action = FirstFragmentDirections.actionFirstFragmentToDescriptionFragment(animal.name, animal.description, animal.imageResId, animal.age)
            findNavController().navigate(action)
            Toast.makeText(requireContext(), "Clicked element №$position", Toast.LENGTH_SHORT).show()
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

        binding.btnToNext.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDescriptionFragment("Some string", "", R.drawable.placeholder_image, 0))
        }
    }
}


//class FirstFragment : Fragment() {
//    lateinit var binding: FragmentFirstBinding
//    lateinit var adapter: AnimalAdapter
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
//        binding = FragmentFirstBinding.inflate(layoutInflater, container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val list = ArrayList<Animal>()
//        list.add(Dog("Rex", 5))
//        list.add(Cat("Jack", 4))
//        list.add(Bird("Minder", 1))
//        list.add(Fish("Fredy", 3))
//        list.add(Duck("Bosman", 2))
//
//        adapter = AnimalAdapter(){ animal, position ->
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDescriptionFragment(animal.name))
//            Toast.makeText(requireContext(), "Clicked element №$position", Toast.LENGTH_SHORT).show()
//        }
//        adapter.setList(list)
//        binding.rv.adapter = adapter
//
//        binding.btnToNext.setOnClickListener {
//            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDescriptionFragment("Some string"))
//        }
//    }
//}