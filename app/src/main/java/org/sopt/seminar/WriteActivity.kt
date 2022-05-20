package org.sopt.seminar

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import org.sopt.seminar.databinding.ActivityWriteBinding
import org.sopt.seminar.presentation.home.PictureAdapter
import org.sopt.seminar.presentation.home.PictureData
import org.sopt.seminar.util.BaseActivity

class WriteActivity : BaseActivity<ActivityWriteBinding>(R.layout.activity_write) {
    private lateinit var pictureAdapter: PictureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPictureAdapter()
        changePriceColor()
        changeSuggestButton()
        backClickEvent()
    }

    private fun changePriceColor() {
        binding.etPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length!! > 0) {
                    binding.tvWon.setTextColor(
                        ContextCompat.getColor(
                            this@WriteActivity,
                            R.color.carrot_black
                        )
                    )
                } else {
                    binding.tvWon.setTextColor(
                        ContextCompat.getColor(
                            this@WriteActivity,
                            R.color.squaregray
                        )
                    )
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun changeSuggestButton() {
        binding.btnCheck.setOnClickListener(object : View.OnClickListener {
            var isClicked = false
            override fun onClick(v: View?) {
                isClicked = !isClicked
                if (isClicked) binding.btnCheck.setImageResource(R.drawable.ic_check)
                else binding.btnCheck.setImageResource(R.drawable.ic_no_check)
            }

        })
    }

    private fun initPictureAdapter() {
        pictureAdapter = PictureAdapter()
        binding.rvPicture.adapter = pictureAdapter
    }

    private fun backClickEvent() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

}