package name.hampton.mike.modern

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    private var recyclerView: RecyclerView? = null
    private var recyclerviewItemAdapter: RecyclerviewItemAdapter? = null
    private val itemsList = mutableListOf<Items>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleView)
        recyclerviewItemAdapter = RecyclerviewItemAdapter(itemsList)
        with(recyclerView) { this?.setHasFixedSize(true) }
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        with(recyclerView) {
            this?.setLayoutManager(layoutManager)
            this?.setItemAnimator(DefaultItemAnimator())
            this?.setAdapter(recyclerviewItemAdapter)
        }

        recyclerviewItemAdapter!!.setOnItemClickListener(object : ClickListener<Items?> {
            override fun onClick(view: View?, data: Items?, position: Int) {
                if (data != null) {
                    Toast.makeText(
                        applicationContext,
                        "Position = $position Item = ${data.name}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        prepareItems()
//
//        val apiInterface = ApiInterface.create().getMovies()
//
//
//        //apiInterface.enqueue( Callback<List<Movie>>())
//        apiInterface.enqueue( object : retrofit2.Callback<List<Movie>>{
//            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {
//
//                if(response?.body() != null)
//                    recyclerAdapter.setMovieListItems(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
//
//            }
//        })
    }

    private fun prepareItems() {
        for (i in 0..49) {
            val items = Items("Item$i", 20 + i)
            itemsList.add(items)
        }
    }
}