package com.akkt.ecommerce.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.akkt.ecommerce.delegates.RegisterDelegate
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : AppCompatActivity(),RegisterDelegate, DatePickerDialog.OnDateSetListener, View.OnClickListener {

    private val calender = Calendar.getInstance()
    private val mYear = calender.get(Calendar.YEAR)
    private val mMonth = calender.get(Calendar.MONTH)
    private val mDay = calender.get(Calendar.DAY_OF_MONTH)

    lateinit var mDatePicker: DatePickerDialog
    lateinit var mBirthday: String

    private val mUserModel: UserModel

    init {
        mUserModel = UserModelImpl
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mDatePicker = DatePickerDialog(this, this, mYear, mMonth, mDay)

        mBirthday = mDatePicker.datePicker.dayOfMonth.toString() + "/" +
                (mDatePicker.datePicker.month + 1).toString() + "/" +
                mDatePicker.datePicker.year.toString()

        etActivityRegisterDate.setText(mBirthday)

        etActivityRegisterDate.setOnClickListener(this)
        ivActivityRegisterBack.setOnClickListener { finish() }

        btnActivityRegister.setOnClickListener {
            mUserModel.register(etActivityRegisterName.toString(),
                etActivityRegisterPassword.toString(),
                etActivityRegisterPhone.toString(),
                etActivityRegisterDate.toString(),
                etActivityRegisterLocation.toString(),this)
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

    override fun success(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onFail(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}
