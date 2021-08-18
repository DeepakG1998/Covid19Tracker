package com.blogspot.devofandroid.covid19tracker.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.devofandroid.covid19tracker.R
import com.blogspot.devofandroid.covid19tracker.adapter.CaseListAdapter
import com.blogspot.devofandroid.covid19tracker.dataClass.GetData
import com.blogspot.devofandroid.covid19tracker.dataModel.ModelData
import com.blogspot.devofandroid.covid19tracker.dataModel.SetData
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidTrackListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_track_list)

        val recyclerView = findViewById<RecyclerView>(R.id.case_list_view)
        val serviceGenerator = SetData.buildService(ModelData::class.java)
        val call = serviceGenerator.getPosts()

        call.enqueue(object : Callback<MutableList<GetData>> {
            override fun onResponse(
                call: Call<MutableList<GetData>>,
                response: Response<MutableList<GetData>>
            ) {
                if (response.isSuccessful) {
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@CovidTrackListActivity)
                        adapter = CaseListAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<GetData>>, t: Throwable) {
                t.printStackTrace()
                Log.e("Error", t.message.toString())
            }


        })


    }


}