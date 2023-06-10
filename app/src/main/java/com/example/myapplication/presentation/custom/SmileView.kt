package com.example.myapplication.presentation.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * TODO Refactor
 * - add companion object
 * - apply kotlin
 * - single responsibility
 * - naming parameters
 * - use internal - и изучить что это
 *
 */
internal class SmileView(context: Context, attributes: AttributeSet) : View(context, attributes){

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val faceColor = Color.YELLOW
    private val eyesColor = Color.BLACK
    private val mouthColor = Color.BLACK
    private val borderColor = Color.BLACK

    private var borderWidth = 4.0f

    //TODO do homework?
    private var size = 320
    private val radius = size / 2f


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //TODO зависит от задачи
        size = Math.min(measuredWidth, measuredHeight)

        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        paint.apply {
            color = faceColor
            style = Paint.Style.FILL
        }

        canvas.drawCircle(radius, radius, radius, paint)

        paint.apply {
            color = borderColor
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
        }

        canvas.drawCircle(radius, radius, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        paint.apply {
            color = eyesColor
            style = Paint.Style.FILL
        }
        drawEyesRect(canvas)
    }

    private fun drawMouth(canvas: Canvas) {
        val mouthPath = Path().apply {
            moveTo(size * 0.22f, size * 0.7f)
            quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
            quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)
        }

        paint.apply {
            color = mouthColor
            style = Paint.Style.FILL
        }
        canvas.drawPath(mouthPath, paint)
    }

    private fun drawEyesRect(canvas: Canvas) {
        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEyeRect, paint)
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEyeRect, paint)
    }
}