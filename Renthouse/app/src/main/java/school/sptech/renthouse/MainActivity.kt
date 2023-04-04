package school.sptech.renthouse

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        imageView = findViewById(R.id.imageView)

        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.fundo_roxo)
        val blurredBitmap = blurBitmap(this, bitmap, 25f) // 25f é o raio do efeito de desfoque

        imageView.setImageBitmap(blurredBitmap)
    }

    @Suppress("DEPRECATION")
    private fun blurBitmap(context: Context, bitmap: Bitmap, radius: Float): Bitmap {
        val renderScript = RenderScript.create(context)
        val inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        val outputAllocation = Allocation.createTyped(renderScript, inputAllocation.type)
        val blurScript = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
        blurScript.setInput(inputAllocation)
        blurScript.setRadius(radius)
        blurScript.forEach(outputAllocation)
        outputAllocation.copyTo(bitmap)
        return bitmap
    }
}
