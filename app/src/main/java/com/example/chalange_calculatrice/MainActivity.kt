package com.example.chalange_calculatrice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var  firstNum:Double=0.0
    var operation:String=""
//numbers
    lateinit var n0:Button
    lateinit var n1:Button
    lateinit var n2:Button
    lateinit var n3:Button
    lateinit var n4:Button
    lateinit var n5:Button
    lateinit var n6:Button
    lateinit var n7:Button
    lateinit var n8:Button
    lateinit var n9:Button

    lateinit var point:Button
    lateinit var on:Button
    lateinit var off:Button
    lateinit var del:Button
    lateinit var ac:Button

    lateinit var div:Button
    lateinit var substract:Button
    lateinit var plus:Button
    lateinit var multiple:Button
    lateinit var equal:Button

    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        n0 = findViewById(R.id.num0)
        n1 = findViewById(R.id.num1)
        n2 = findViewById(R.id.num2)
        n3 = findViewById(R.id.num3)
        n4 = findViewById(R.id.num4)
        n5 = findViewById(R.id.num5)
        n6 = findViewById(R.id.num6)
        n7 = findViewById(R.id.num7)
        n8 = findViewById(R.id.num8)
        n9 = findViewById(R.id.num9)

        point = findViewById(R.id.point)
        on = findViewById(R.id.on)
        off = findViewById(R.id.Off)
        del = findViewById(R.id.del)
        ac = findViewById(R.id.ac)

        div = findViewById(R.id.div)
        multiple = findViewById(R.id.multiple)
        substract = findViewById(R.id.substract)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)

        textView = findViewById(R.id.screen)

        ac.setOnClickListener({
            firstNum = 0.0
            textView.setText("O")
        })
        off.setOnClickListener({
            textView.visibility = View.GONE
        })
        on.setOnClickListener({
            textView.visibility = View.VISIBLE
            textView.setText("0")
        })
        del.setOnClickListener({
            val num:String = textView.text.toString()
            if (num.length > 1){
                textView.setText(num.substring(0,num.length - 1))
            }
            if (num.length == 1 && num != "0") {
                textView.text = "0"
            }
        })
        point.setOnClickListener({
            if (!textView.text.toString().contains(".")){
                textView.setText(textView.text.toString() + ".")
            }
        })
        var nums:ArrayList<Button> = ArrayList()
        nums.add(n0)
        nums.add(n1)
        nums.add(n2)
        nums.add(n3)
        nums.add(n4)
        nums.add(n5)
        nums.add(n6)
        nums.add(n7)
        nums.add(n8)
        nums.add(n9)
        for (btn in nums){
            btn.setOnClickListener({
                if (textView.text.toString() != "0") {
                    textView.setText(textView.text.toString() + btn.text.toString())
                } else {
                    textView.text = btn.text.toString()
                }
            })
        }
        val opers:ArrayList<Button> = ArrayList()
        opers.add(plus)
        opers.add(substract)
        opers.add(multiple)
        opers.add(div)
        for(btn in opers){
            btn.setOnClickListener({
                firstNum = textView.text.toString().toDouble()
                operation = btn.text.toString()
                textView.setText("0")
            })
        }
        equal.setOnClickListener({
            val secondNum:Double = textView.text.toString().toDouble()
            val resultat :Double
            if (operation == "/"){
                resultat = firstNum / secondNum
            }
            else if (operation == "x"){
                resultat = firstNum * secondNum
            }
            else if (operation == "+"){
                resultat = firstNum + secondNum
            }
            else if(operation == "-"){
                resultat = firstNum - secondNum
            }
            else{
                resultat = firstNum + secondNum
            }
            textView.setText(resultat.toString())
            firstNum = resultat
        })
    }
}