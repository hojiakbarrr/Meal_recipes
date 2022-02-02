package com.example.meal_recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.meal_recipes.Base.DetailsMeal
import com.example.meal_recipes.Base.Meal_Base
import java.io.Serializable

class FavouriteActivity : AppCompatActivity(), Meak_Adapter.FoodClickListener {
    private var recyclerView: RecyclerView? = null
    private var myAdapter: Meak_Adapter? = null
    private var list : MutableList<DetailsMeal> = ArrayList()
    private var listTransfer: ArrayList<DetailsMeal> = ArrayList()
    var delete = R.drawable.ic_baseline_delete_forever_24
    var er : Int = 0
    var database: Meal_Base? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        database = Room.databaseBuilder(this,
            Meal_Base :: class.java,
            "mealDb").allowMainThreadQueries()
            .build()

        list = database?.getMealDao()?.getAllMeal()!!

//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.rec2)
        list = intent.getSerializableExtra("perehod") as ArrayList<DetailsMeal>

        for (o in list) {
            o.likeIdImage = delete
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
        myAdapter = Meak_Adapter(list, this)

        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = myAdapter
        myAdapter?.notifyDataSetChanged()


    }

    override fun fonItemClick(position: Int) {
        val intent = Intent(this@FavouriteActivity, DetailsActivity::class.java)
        for (i in list.indices) {
            if (i == position) {
                listTransfer.add(list[position])
                intent.putExtra("zakaz", listTransfer as Serializable)
                startActivity(intent)
            }
        }
    }

    override fun fonLikeClick(position: Int) {
//        DetailsMeal.remove.removeAt(position)
        list.removeAt(position)


        var newMeal = DetailsMeal()
        newMeal = list[position]
        database?.getMealDao()?.delete(newMeal)

//        var deleteMeal = list.get(position)
//
//            database!!.getMealDao().delete(deleteMeal)


        myAdapter?.notifyDataSetChanged()
    }

}
