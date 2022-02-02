package com.example.meal_recipes.Base

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "meal_database")
data class DetailsMeal(
    @PrimaryKey
    var id: Int = 0,
    var imageId: Int = 0,
    var title: String = "",
    var description: String = "",
    var gotovit: String = "",
    var likeIdImage: Int = 0,
    var podgotovka: String = "",
    var kkal: String = "",
    var porcii: String = "",
    var ingridienty: String = "",
    var metod: String = "",
    var isSelected: Boolean = false



) : Serializable{
    companion object{
        var remove : MutableList<DetailsMeal> = ArrayList()
    }
}

