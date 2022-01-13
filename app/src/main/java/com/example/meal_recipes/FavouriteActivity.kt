package com.example.meal_recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class FavouriteActivity : AppCompatActivity(), Meak_Adapter.FoodClickListener {
    private var recyclerView: RecyclerView? = null
    private var myAdapter: Meak_Adapter? = null
    private var list: ArrayList<DetailsMeal> = ArrayList()
    private var listTransfer: ArrayList<DetailsMeal> = ArrayList()
    var delete = R.drawable.ic_baseline_delete_forever_24
    var like = R.drawable.ic_baseline_favorite_border_24
    var er : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

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
        DetailsMeal.remove.removeAt(position)
        list.removeAt(position)
//        DetailsMeal.we.add(list[position])
        for (o in list){
             er = o.id
        }
        deletefav(er)

        myAdapter?.notifyDataSetChanged()
    }

    override fun deletefav(position: Int) {
    }

//    interface op {
//        fun isClickkk(position: Int)
//    }

}
