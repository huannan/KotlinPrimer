package com.nan.kotlinprimer.day18_coroutines

import android.graphics.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nan.kotlinprimer.R
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class CoroutinesActivity : AppCompatActivity() {

    companion object {
        const val TAG = "CoroutinesActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        test2()
    }

    private fun test2() {
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap: Deferred<Bitmap> = async { getImageFromNetwork() }
            val imageDesc = async { getImageDescFromNetwork() }
            updateUI(bitmap.await(), imageDesc.await())
        }
    }

    private fun test1() {
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = getImageFromNetwork()
            val bitmapWithWatermark = createWatermark(bitmap, "小楠总")
            updateUI(bitmap, "")
        }
    }

    private fun test0() {
        // 方法一通常适用于单元测试的场景，而业务开发中不会用到这种方法，因为它是线程阻塞的。
        runBlocking {
            Log.e(TAG, "threadName=${Thread.currentThread().name}")
        }

        // 方法二和使用 runBlocking 的区别在于不会阻塞线程。但在 Android 开发中同样不推荐这种用法，因为它的生命周期会和 app 一致，且不能取消（什么是协程的取消后面的文章会讲）。
        GlobalScope.launch {
            Log.e(TAG, "threadName=${Thread.currentThread().name}")
        }

        // 方法三是比较推荐的使用方法，我们可以通过 context 参数去管理和控制协程的生命周期（这里的 context 和 Android 里的不是一个东西，是一个更通用的概念，会有一个 Android 平台的封装来配合使用）。
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            Log.e(TAG, "threadName=${Thread.currentThread().name}")
        }
    }

    private suspend fun getImageFromNetwork() = withContext(Dispatchers.IO) {
        val url = URL("http://img.taopic.com/uploads/allimg/130331/240460-13033106243430.jpg")
        val connection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream
        BitmapFactory.decodeStream(inputStream)
    }

    private suspend fun getImageDescFromNetwork(): String {
        delay(2000L)
        return "this is a fun image"
    }

    private fun updateUI(bitmap: Bitmap, imageDesc: String) {
        imageView.setImageBitmap(bitmap)
        textView.text = imageDesc
    }

    private suspend fun createWatermark(bitmap: Bitmap, mark: String) = withContext(Dispatchers.IO) {
        val w = bitmap.width
        val h = bitmap.height
        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        val paint = Paint()
        // 水印颜色
        paint.color = Color.parseColor("#C5FF0000")
        // 水印字体大小
        paint.textSize = 150F
        //抗锯齿
        paint.isAntiAlias = true
        //绘制图像
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        //绘制文字
        canvas.drawText(mark, 0f, (h / 2).toFloat(), paint)
        canvas.save()
        // canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore()
        bmp
    }

}