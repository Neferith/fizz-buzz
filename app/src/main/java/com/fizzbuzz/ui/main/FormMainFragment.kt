package com.fizzbuzz.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fizzbuzz.R
import com.fizzbuzz.model.FormException
import com.fizzbuzz.ui.ResultActivity
import com.google.android.material.textfield.TextInputLayout

class FormMainFragment : Fragment() {

    companion object {
        fun newInstance() = FormMainFragment()
    }

    private lateinit var viewModel: FormMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun goToResultActivity() {
        activity.let {
            val intent = Intent (it, ResultActivity::class.java)
            intent.putExtra("meta",viewModel.getCurrentItem())
            it?.startActivity(intent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureViewModel()

        configureForm(view)

    }


    private fun configureViewModel() {
        viewModel = ViewModelProvider(this)[FormMainViewModel::class.java]
    }

    private fun configureInput(
        inView:View,
        id:Int,
        defaultValue:String,
        onChange: (value: String) -> FormException?
    ) {


        val layout = inView.findViewById<TextInputLayout>(id)


        val int1View = layout.editText
        int1View?.setText(defaultValue)

        int1View?.doOnTextChanged { text, _, _, _ ->
           val exception = onChange(text.toString())
            submitError(layout,exception)
        }




    }

    private fun submitError(layout: TextInputLayout, exception: FormException?) {
        if(exception != null) {
            layout.error = exception.message
            submitButton.visibility = View.GONE
        } else {
            layout.error = null
            submitButton.visibility = View.VISIBLE
        }


    }

    private lateinit var submitButton:Button
    private fun configureForm(inView:View) {

        configureInput(inView,R.id.textInputLayoutInt1,viewModel.getCurrentItem().int1.toString()) {
           try {
               viewModel.updateInt1(it)
           }catch (e:FormException) {
               return@configureInput e
           }
            return@configureInput null
        }

        configureInput(inView,R.id.textInputLayoutInt2,viewModel.getCurrentItem().int2.toString()) {
            try {
                viewModel.updateInt2(it)
            }catch (e:FormException) {
                return@configureInput e
            }
            return@configureInput null
        }

        configureInput(inView,R.id.textInputLayoutLimit,viewModel.getCurrentItem().limit.toString()) {
            try {
                viewModel.updateLimit(it)
            }catch (e:FormException) {
                return@configureInput e
            }
            return@configureInput null
        }

        configureInput(inView,R.id.textInputLayoutStr1,viewModel.getCurrentItem().str1) {

                viewModel.updateStr1(it)

            return@configureInput null
        }

        configureInput(inView,R.id.textInputLayoutStr2,viewModel.getCurrentItem().str2) {

            viewModel.updateStr2(it)

            return@configureInput null
        }



        submitButton = inView.findViewById(R.id.submit)
        submitButton.setOnClickListener { goToResultActivity() }

    }

}