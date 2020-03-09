package id.dtprsty.simpleunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        val length = etLength.text.toString().trim()
        val widht = etWidth.text.toString().trim()
        val height = etHeight.text.toString().trim()

        when{
            length.isEmpty() -> etLength.error = "Fill this form"
            widht.isEmpty() -> etWidth.error = "Fill this form"
            height.isEmpty() -> etHeight.error = "Fill this form"

            else -> {
                val l = length.toDouble()
                val w = widht.toDouble()
                val h = height.toDouble()

                btnSave.setOnClickListener {
                    mainViewModel.save(w, l, h)
                    visible()
                }

                btnCalculateCircumference.setOnClickListener {
                    mainViewModel.getCircumference()
                    gone()
                }

                btnCalculateVolume.setOnClickListener {
                    mainViewModel.getVolume()
                    gone()
                }

                btnCalculateSurface.setOnClickListener {
                    mainViewModel.getSurfaceArea()
                    gone()
                }
            }
        }
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
}
