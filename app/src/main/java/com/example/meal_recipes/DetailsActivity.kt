package com.example.meal_recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    var foto: ImageView ?=null
    var name: TextView ?=null
    var timeCook:TextView ?=null
    var prep:TextView ?=null
    var kcall:TextView ?=null
    var portchi:TextView ?=null
    var ingridients:TextView ?=null
    var metods:TextView ?=null
    var isClick = ArrayList<DetailsMeal>()
    var isClick_2 = ArrayList<DetailsMeal>()
    var se: Int = 0
    var ab: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        foto = findViewById(R.id.imageView4)
        name = findViewById(R.id.textView5)
        timeCook = findViewById(R.id.textView8)
        prep = findViewById(R.id.textView9)
        kcall = findViewById(R.id.textView13)
        portchi = findViewById(R.id.textView16)
        ingridients = findViewById(R.id.textView18)
        metods = findViewById(R.id.textView21)

        isClick = intent.getSerializableExtra("zakaz") as ArrayList<DetailsMeal>
//        isClick_2 = intent.getSerializableExtra("order") as ArrayList<DetailsMeal>



        for (o in isClick){
            se = o.imageId
            foto?.setImageResource(se)
            name?.text = o.title
            timeCook?.text = o.gotovit
            prep?.text = o.podgotovka
            kcall?.text = o.kkal
            portchi?.text = o.porcii
            ingridients?.text = o.ingridienty
            metods?.text = o.metod

        }

//        for (o in isClick_2){
//            ab = o.imageId
//            foto?.setImageResource(ab)
//            name?.text = o.title
//            timeCook?.text = o.gotovit
//            prep?.text = o.podgotovka
//            kcall?.text = o.kkal
//            portchi?.text = o.porcii
//            ingridients?.text = o.ingridienty
//            metods?.text = o.metod
//
//        }






    }
}