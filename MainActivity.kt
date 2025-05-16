package com.example.flashcards

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcards.R.id


abstract class WelcomeActivity() : AppCompatActivity()
{


    abstract fun setOnclickListener(function: () -> Unit)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val startButton= findViewById<Button>(id.btnStart)
        startButton.setOnClickListener{
            val intent=(Intent(this, QuestionActivity::class.java))
                     this.intent

        }


    }

    protected abstract fun setOnclickListener()


}


    class QuestionActivity:AppCompatActivity(){
    private val questions=arrayOf(
        "Nelson Mandela was the president in 1994",
        "World War || ended in 1945",
        "The Berlin Wall Fell in 1989",
        "The Roman Empire lasted over 2000 years",
        "The Great Fire of London occurred in 1666"
    )


    private val answers =  arrayOf(true, true, true, false, true)

         private var currentIndex = 0
         private var score = 0


        @SuppressLint("MissingInflatedId")
        private lateinit var tvQuestion: TextView
        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
            super.onCreate(savedInstanceState, persistentState)
             setContentView(R.layout.activity_question)

            val tvQuestion = findViewById<TextView>(id.tvQuestion)
            tvQuestion.text="Hello, this is your question!"

            val  tvFeedback = findViewById<TextView>(id.tvFeedback)
            val btnTrue=findViewById<Button>(id.btnTrue)
             val btnFalse = findViewById<Button>(id.btnFalse)
             val btnNext = findViewById<Button>(id.btnNext)

             fun loadQuestion()
             {
                 questions[this.currentIndex]
                 tvFeedback.text = ""
             }

             btnTrue.setOnClickListener {
                checkAnswer(true, tvFeedback)
            }
            btnFalse.setOnClickListener {
                checkAnswer(false, tvFeedback)
            }
            btnNext.setOnClickListener {
                currentIndex++
                if (currentIndex < questions.size) {
                    loadQuestion()
                } else {
                    val intent = Intent(this, ScoreActivity::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
loadQuestion()
        }



        private fun checkAnswer(userAnswer: Boolean, feedbackView: TextView) {
            if (userAnswer == answers[currentIndex]) {
                "Correct!".also { feedbackView.text = it }
                score++
            } else {
                "Incorrect".also { feedbackView.text = it }

            }

        }
    }


class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score=intent.getIntExtra("score",0)
        val tvScore=findViewById<TextView>(id.tvScore)
        val tvFeedback=findViewById<TextView>(id.tvFinal-Feedback)
    val btnReview=findViewById<Button>(id.btnReview)
        val btnExit=findViewById<Button>(id.btnExit)
        tvScore.text= buildString {
            append("Your score:")
            append(score)
            append("/5")
        }
        tvFeedback.text= if (score>=3)
        {
            "Great job!"
        } else{
            "keep practising!"
        }
    btnReview.setOnClickListener{
        startActivity(intent())
    }
        btnExit.setOnClickListener{
            finishAffinity()
        }
    }

}

private fun ScoreActivity.intent(
): Intent
{
    TODO("Not yet implemented")
}


class ReviewActivity:
        AppCompatActivity()
{
    private lateinit var tvReview: TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)


        tvReview = findViewById(id.tvReview)
        booleanArrayOf(true, true, true, false, true)

        val questions = listOf(
            "Nelson Mandela was the president in 1994",
            "World War || ended in 1945",
            "The Berlin Wall Fell in 1989",
            "The Roman Empire lasted over 2000 years",
            "The Great Fire of London occurred in 1666"
        )

        val builder = StringBuilder()

        for (i in questions.indices)
        {

            builder.append(
                "${i + 1}.$ { questions[i] } - ${
                    if (answers())
                        "True"
                    else "False"
                }/ n"
            )
        }
        tvReview.text = builder.toString()


    }

    private fun answers(): Boolean
    {
        return true
    }
}












