package com.akkt.ecommerce.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.mvp.presenters.IRegisterPresenter
import com.akkt.ecommerce.mvp.presenters.impl.RegisterPresenter
import com.akkt.ecommerce.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : BaseActivity(), RegisterView, DatePickerDialog.OnDateSetListener, View.OnClickListener {

    private val calender = Calendar.getInstance()
    private val mYear = calender.get(Calendar.YEAR)
    private val mMonth = calender.get(Calendar.MONTH)
    private val mDay = calender.get(Calendar.DAY_OF_MONTH)

    lateinit var mDatePicker: DatePickerDialog
    lateinit var mBirthday: String

    private val mRegisterPresenter: IRegisterPresenter = RegisterPresenter(this)

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterPresenter.onCreate()

        mDatePicker = DatePickerDialog(this, this, mYear, mMonth, mDay)

        mBirthday = mDatePicker.datePicker.dayOfMonth.toString() + "/" +
                (mDatePicker.datePicker.month + 1).toString() + "/" +
                mDatePicker.datePicker.year.toString()

        etActivityRegisterDate.setText(mBirthday)

        etActivityRegisterDate.setOnClickListener(this)
        ivActivityRegisterBack.setOnClickListener { mRegisterPresenter.onTapBackButton() }

        btnActivityRegister.setOnClickListener {
            mRegisterPresenter.onTapRegisterButton(
                etActivityRegisterName.toString(),
                etActivityRegisterPassword.toString(),
                etActivityRegisterPhone.toString(),
                etActivityRegisterDate.toString(),
                etActivityRegisterLocation.toString()
            )
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        mBirthday = dayOfMonth.toString() + "/" + (month + 1).toString() + "/" + year.toString()

        etActivityRegisterDate.setText(mBirthday)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.etActivityRegisterDate -> mDatePicker.show()
        }
    }

    override fun displayFailMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun displaySuccessMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        finishActivity()
    }

    override fun finishActivity() {
        finish()
    }
}
