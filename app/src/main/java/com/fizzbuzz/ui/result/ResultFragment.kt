package com.fizzbuzz.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fizzbuzz.R
import com.fizzbuzz.model.FizzbuzzEntity

class ResultFragment : Fragment() {

    companion object {
        fun newInstance(entity: FizzbuzzEntity?): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putParcelable("entity", entity)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var viewModel: ResultViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureViewModel()
        configureRecyclerView(view)

    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this)[ResultViewModel::class.java]
        viewModel.init(arguments?.getParcelable("entity"))
    }

    private fun configureRecyclerView(inView: View) {
        recyclerView = inView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ResultAdapter(viewModel.entity)
    }

}