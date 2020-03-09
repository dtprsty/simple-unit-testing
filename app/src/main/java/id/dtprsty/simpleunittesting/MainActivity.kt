package id.dtprsty.simpleunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        btnSave.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculateSurface.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
    }

    private fun visible(){
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateSurface.visibility = View.VISIBLE
        btnSave.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
    }

    private fun gone(){
        btnCalculateVolume.visibility = View.GONE
        btnCalculateSurface.visibility = View.GONE
        btnSave.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        val length = etLength.text.toString().trim()
        val widht = etWidth.text.toString().trim()
        val height = etHeight.text.toString().trim()

        when{
            length.isEmpty() -> etLength.error = "Field can not empty"
            widht.isEmpty() -> etWidth.error = "Field can not empty"
            height.isEmpty() -> etHeight.error = "Field can not empty"

            else -> {
                val l = length.toDouble()
                val w = widht.toDouble()
                val h = height.toDouble()

                when{
                    v?.id == R.id.btnSave -> {
                        mainViewModel.save(w, l, h)
                        visible()
                    }
                    v?.id == R.id.btnCalculateCircumference -> {
                        tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    v?.id == R.id.btnCalculateVolume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    v?.id == R.id.btnCalculateSurface -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                }
            }
        }
    }
}
