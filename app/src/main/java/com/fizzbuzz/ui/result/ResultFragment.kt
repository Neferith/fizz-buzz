package com.fizzbuzz.ui.result

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fizzbuzz.R
import com.fizzbuzz.model.FizzbuzzEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    companion object {
        const val ARG_ENTITY = "entity"
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            viewModel.init(arguments?.getParcelable(ARG_ENTITY, FizzbuzzEntity::class.java))
        } else {
            @Suppress("DEPRECATION")
            viewModel.init(arguments?.getParcelable(ARG_ENTITY))
        }
    }

    private fun configureRecyclerView(inView: View) {
        recyclerView = inView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ResultAdapter(viewModel.entity)
    }

    inner class ResultAdapter(private val mItem: FizzbuzzEntity) :
        RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // The fizzbuzz string begin at index 1 (Current position +1)
            holder.textView.text = viewModel.generateFitBuzzString(position + 1, mItem)
        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return mItem.limit
        }

        // Holds the views for adding it to image and text
        inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val textView: TextView = itemView.findViewById(R.id.tv_recycler_view_item)
        }
    }

}