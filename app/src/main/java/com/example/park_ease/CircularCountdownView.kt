package com.example.park_ease



import android.content.Context
import android.graphics.*
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.View

class CircularCountdownView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paintCircle = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 20f
        isAntiAlias = true
    }

    private val paintArc = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 20f
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.WHITE
        textSize = 48f
        textAlign = Paint.Align.CENTER
        isAntiAlias = true
    }

    private var sweepAngle = 0f
    private var timeMillis: Long = 3 * 60 * 60 * 1000 // 3 hours
    private var remainingTime: Long = timeMillis

    private val timer = object : CountDownTimer(timeMillis, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            remainingTime = millisUntilFinished
            sweepAngle = 360f * (1f - millisUntilFinished.toFloat() / timeMillis)
            invalidate()
        }

        override fun onFinish() {
            remainingTime = 0
            sweepAngle = 360f
            invalidate()
        }
    }

    init {
        timer.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(centerX, centerY) - 40f

        canvas.drawCircle(centerX, centerY, radius, paintCircle)

        val rect = RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(rect, -90f, sweepAngle, false, paintArc)

        val hours = (remainingTime / 1000) / 3600
        val minutes = ((remainingTime / 1000) % 3600) / 60
        val seconds = (remainingTime / 1000) % 60

        val timeText = String.format("%02d : %02d : %02d", hours, minutes, seconds)
        canvas.drawText(timeText, centerX, centerY + 16f, textPaint)

        // Labels
        textPaint.textSize = 28f
        canvas.drawText("Hours", centerX - 100f, centerY + 80f, textPaint)
        canvas.drawText("Minutes", centerX, centerY + 80f, textPaint)
        canvas.drawText("Seconds", centerX + 100f, centerY + 80f, textPaint)
    }
}
