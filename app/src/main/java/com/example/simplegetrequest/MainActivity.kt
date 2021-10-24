package com.example.simplegetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val responseText = findViewById<TextView>(R.id.textView) as TextView
        val apiInterface = APIClinent().GetClient()?.create(APIInterface::class.java)
        val call: Call<ActivityDetails?>?= apiInterface!!.doGetListResources()

        call?.enqueue(object: Callback<ActivityDetails?>{
            override fun onResponse(call: Call<ActivityDetails?>, response: Response<ActivityDetails?>){
                val result: ActivityDetails?= response.body()

                val activity = result?.activity
                val type = result?.type
                val key = result?.key

                responseText.text = "$activity\n $type\n $key"
            }

            override fun onFailure(call: Call<ActivityDetails?>, t: Throwable?){
                call.cancel()
            }
        })
    }
}
