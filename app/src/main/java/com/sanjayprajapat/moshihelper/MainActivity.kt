package com.sanjayprajapat.moshihelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.sanjayprajapat.moshihelper.models.Burger
import com.sanjayprajapat.moshihelper.models.Restaurant
import com.sanjayprajapat.moshihelper.models.User
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.sanjayprajapat.moshi_helper_android.utils.MoshiHelper
//import com.sanjayprajapat.moshi_helper_android.utils.MoshiHelper

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }

    private val moshi by lazy{
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // allow to based on kotlin reflection to serialize any kotlin class
            .build()
    }

    private val moshiHelper by lazy {
        MoshiHelper()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson = Gson()

        val json =
            """{
             "menu": [{"name" : "Classic", "price": 10},
            {"name" : "CheesBurger", "price": 13, "b":"true"},
            {"name" : "Double", "price": "90"}]
            }
            """
        val restaurant = gson.fromJson(json, Restaurant::class.java)
        Log.d(TAG, "onCreate: $restaurant") // Restaurant(menu=[Burger(name=Classic, price=10, b=false), Burger(name=CheesBurger, price=13, b=true), Burger(name=Double, price=90, b=false)])

        val burgerAdapter:JsonAdapter<Burger> = moshi.adapter(Burger::class.java)
        val burgerJson = burgerAdapter.toJson(Burger("Classic", 10, false))
        Log.d(TAG, "burgerJson: $burgerJson") //{"name":"Classic","price":10,"b":false}
        val burger = burgerAdapter.fromJson(burgerJson)
        Log.d(TAG, "burgerObj: $burger") // Burger(name=Classic, price=10, b=false)


        // second Approach
        // using codegen
        val moshi2 = Moshi.Builder().build()
        val userAdapter  = moshi2.adapter(User::class.java)
        val userJson = userAdapter.toJson(User("Sanjay", "23232", arrayListOf("23323","232323")))
        Log.d(TAG, "userJson: $userJson") //{"name":"Sanjay","email":"23232","numbers":["23323","232323"]}
        val user = userAdapter.fromJson(userJson)
        Log.d(TAG, "userObj: $user") //  User(name=Sanjay, email=23232, numbers=[23323, 232323])



        // Moshi Helper
        Log.d(TAG, "convertToJsonByMoshi burgerJson: ${moshiHelper.convertToJsonByMoshi(Burger(name = "Classic",price = 23,b=false))}") // {"name":"Classic","price":23,"b":false}
        Log.d(TAG, "convertFromJsonByMoshi burgerObj: ${moshiHelper.convertFromJsonByMoshi<Burger>("""{"name":"Classic","price":23,"b":false}""")}") //Burger(name=Classic, price=23, b=false)
        val burgerJsonStr = """
            [{"name":"Burger Bum","price":23,"b":false},
            {"name":"Warm Buns","price":23,"b":false},{"name":"Burger Her","price":23,"b":true}]
            """
        Log.d(TAG, "convertFromJsonToListByMoshi burgerObj: ${moshiHelper.convertFromJsonToListByMoshi<Burger>(burgerJsonStr)}") //[Burger(name=Burger Bum, price=23, b=false), Burger(name=Warm Buns, price=23, b=false), Burger(name=Burger Her, price=23, b=true)]
        Log.d(TAG, "convertToJsonByMoshi burgerListJson: ${moshiHelper.convertToJsonByMoshi(getBurgerList())}") // "[{"name":"Bug-Her","price":93,"b":false},{"name":"Burger Bum","price":133,"b":false},{"name":"Warm Buns","price":203,"b":false}]"

        val burgerJsonMap = """
           {"1": {"name":"Burger Bum","price":23,"b":false},
            "2": {"name":"Warm Buns","price":23,"b":false},
            "3": {"name":"Burger Her","price":23,"b":true}
            } 
        """
        Log.d(TAG, "convertFromJsonToMapByMoshi: ${moshiHelper.convertFromJsonToMapByMoshi<Int, Burger>(burgerJsonMap)}") //  {1=Burger(name=Burger Bum, price=23, b=false), 2=Burger(name=Warm Buns, price=23, b=false), 3=Burger(name=Burger Her, price=23, b=true)}



    }


    fun getBurgerList():List<Burger>{
        return listOf(
            Burger("Bug-Her",93,false),
            Burger("Burger Bum",133,false),
            Burger("Warm Buns",203,false)
        )
    }
}