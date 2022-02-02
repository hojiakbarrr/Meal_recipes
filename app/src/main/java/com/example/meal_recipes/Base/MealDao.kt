package com.example.meal_recipes.Base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MealDao {

    @Insert
    fun addFavMeal(meal : DetailsMeal)

    @Delete
    fun delete (meal : DetailsMeal)

    @Query("select * from meal_database")
    fun getAllMeal(): MutableList<DetailsMeal>?

    @Query("select * from meal_database where id ==:mealId")
    fun getMeal(mealId : String) : DetailsMeal

}