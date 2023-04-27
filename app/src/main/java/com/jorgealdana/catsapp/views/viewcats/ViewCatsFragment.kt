package com.jorgealdana.catsapp.views.viewcats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorgealdana.catsapp.blocs.viewmodels.ViewCatsViewModel
import com.jorgealdana.catsapp.blocs.viewmodels.adapters.CatListAdapter
import com.jorgealdana.catsapp.databinding.FragmentViewCatsListBinding

class ViewCatsFragment : Fragment() {

    companion object {
        fun newInstance() = ViewCatsFragment()
    }

    private lateinit var viewModel: ViewCatsViewModel
    private lateinit var adapter: CatListAdapter
    private var _binding: FragmentViewCatsListBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewCatsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewCatsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchCats()
        viewModel.cats.observe(viewLifecycleOwner) {
            loadAdapter()
        }
    }
    private fun loadAdapter() {
        adapter = CatListAdapter(requireContext(), viewModel.cats.value!!)
        binding.catListRV.adapter = adapter
        binding.catListRV.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }
}