package com.example.meal_recipes.Base

import androidx.room.Database
import androidx.room.RoomDatabase


@Database (entities = [DetailsMeal :: class], version = 1)
abstract class Meal_Base: RoomDatabase (){

    abstract fun getMealDao() : MealDao
}