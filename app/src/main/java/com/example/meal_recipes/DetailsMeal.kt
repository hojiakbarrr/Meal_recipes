package com.example.meal_recipes

import java.io.Serializable

class DetailsMeal(
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
        var remove = ArrayList<DetailsMeal>()
        var we = ArrayList<DetailsMeal>()
    }
}

