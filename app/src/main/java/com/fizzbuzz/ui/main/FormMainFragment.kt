package com.fizzbuzz.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.fizzbuzz.R
import com.fizzbuzz.model.FormException
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormMainFragment : Fragment() {

    private val viewModel by viewModels<FormMainViewModel>()
    private lateinit var resultFragmentContainer: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureFragmentResultContainer(view)
        configureForm(view)
    }

    private fun configureFragmentResultContainer(view: View) {
        resultFragmentContainer = if (view.findViewById<View>(R.id.result_nav_container) != null) {
            view.findViewById(R.id.result_nav_container)
        } else {
            view.findViewById(R.id.main)
        }
    }

    private data class InputValidate(
        val isValidate: Boolean,
        val message: String?
    )

    private fun configureInput(
        inView: View,
        id: Int,
        defaultValue: String,
        onChange: (value: String) -> InputValidate
    ) {

        val layout = inView.findViewById<TextInputLayout>(id)
        val int1View = layout.editText
        int1View?.setText(defaultValue)

        int1View?.doOnTextChanged { text, _, _, _ ->
            val result = onChange(text.toString())
            processInputValidation(layout, result)
        }

    }

    private fun processInputValidation(layout: TextInputLayout, result: InputValidate) {
        if (!result.isValidate) {
            layout.error = result.message
            submitButton.visibility = View.GONE
        } else {
            layout.error = null
            submitButton.visibility = View.VISIBLE
        }
    }

    private lateinit var submitButton: Button
    private fun configureForm(inView: View) {

        configureInput(
            inView,
            R.id.textInputLayoutInt1,
            viewModel.getCurrentItem().int1.toString()
        ) {
            try {
                viewModel.updateInt1(it)
            } catch (e: FormException) {
                return@configureInput InputValidate(
                    false,
                    requireContext().resources.getString(R.string.form_error)
                )
            }
            return@configureInput InputValidate(true, null)
        }

        configureInput(
            inView,
            R.id.textInputLayoutInt2,
            viewModel.getCurrentItem().int2.toString()
        ) {
            try {
                viewModel.updateInt2(it)
            } catch (e: FormException) {
                return@configureInput InputValidate(
                    false,
                    requireContext().resources.getString(R.string.form_error)
                )
            }
            return@configureInput InputValidate(true, null)
        }

        configureInput(
            inView,
            R.id.textInputLayoutLimit,
            viewModel.getCurrentItem().limit.toString()
        ) {
            try {
                viewModel.updateLimit(it)
            } catch (e: FormException) {
                return@configureInput InputValidate(
                    false,
                    requireContext().resources.getString(R.string.form_error)
                )
            }
            return@configureInput InputValidate(true, null)
        }

        configureInput(
            inView,
            R.id.textInputLayoutStr1,
            viewModel.getCurrentItem().str1
        ) {

            viewModel.updateStr1(it)

            return@configureInput InputValidate(true, null)
        }

        configureInput(
            inView,
            R.id.textInputLayoutStr2,
            viewModel.getCurrentItem().str2
        ) {

            viewModel.updateStr2(it)

            return@configureInput InputValidate(true, null)
        }
        submitButton = inView.findViewById(R.id.submit)
        submitButton.setOnClickListener { submitResult() }
    }

    private fun submitResult() {
        val bundle = Bundle()

        //TODO : Async
        viewModel.submit()
        resultFragmentContainer.findNavController()
            .navigate(R.id.result_fragment, bundle)
    }
}