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
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

fun CharSequence?.castToLong(): Long =
    if (this != null && this.isNotEmpty()) java.lang.Long.parseLong(
        this,
        0,
        this.lastIndex + 1,
        10
    ) else throw NumberFormatException()

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

    private fun configureInputString(
        inView: View,
        id: Int,
        defaultValue: String,
        onChange: (value: String) -> Unit
    ) {

        val layout = inView.findViewById<TextInputLayout>(id)
        val input = layout.editText
        input?.setText(defaultValue)

        input?.doOnTextChanged { text, _, _, _ ->
            onChange(text.toString())
            processInputValidation(layout, InputValidate(true, null))
        }
    }

    private fun configureInputLong(
        inView: View,
        id: Int,
        defaultValue: Long,
        onChange: (value: Long) -> Unit
    ) {

        val layout = inView.findViewById<TextInputLayout>(id)
        val input = layout.editText
        input?.setText(defaultValue.toString())
        input?.doOnTextChanged { text, _, _, _ ->
            try {
                onChange(text.castToLong())
                processInputValidation(
                    layout,
                    InputValidate(true, null)
                )
            } catch (e: NumberFormatException) {
                processInputValidation(
                    layout,
                    InputValidate(
                        false,
                        requireContext().resources.getString(R.string.form_error)
                    )
                )
            }
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

        configureInputLong(
            inView,
            R.id.textInputLayoutInt1,
            viewModel.getCurrentItem().int1
        ) { viewModel.updateInt1(it) }

        configureInputLong(
            inView,
            R.id.textInputLayoutInt2,
            viewModel.getCurrentItem().int2
        ) { viewModel.updateInt2(it) }

        configureInputLong(
            inView,
            R.id.textInputLayoutLimit,
            viewModel.getCurrentItem().limit
        ) { viewModel.updateLimit(it) }

        configureInputString(
            inView,
            R.id.textInputLayoutStr1,
            viewModel.getCurrentItem().str1
        ) { viewModel.updateStr1(it) }

        configureInputString(
            inView,
            R.id.textInputLayoutStr2,
            viewModel.getCurrentItem().str2
        ) { viewModel.updateStr2(it) }

        submitButton = inView.findViewById(R.id.submit)
        submitButton.setOnClickListener { submitResult() }
    }

    private fun submitResult() {
        val bundle = Bundle()

        viewModel.submit()
        resultFragmentContainer.findNavController()
            .navigate(R.id.result_fragment, bundle)
    }
}