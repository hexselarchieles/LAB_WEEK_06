package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    // Adapter
    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Pasang swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan 10 data
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.Bengal, "Leo", "Always on the move", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.Siamese, "Luna", "Loves attention", "https://cdn2.thecatapi.com/images/ai6Jps4sx.jpg"),
                CatModel(Gender.Male, CatBreed.MaineCoon, "Thor", "Majestic and lazy", "https://cdn2.thecatapi.com/images/MTgwODA1OQ.jpg"),
                CatModel(Gender.Female, CatBreed.Persian, "Bella", "Fluffy and grumpy", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Male, CatBreed.Sphynx, "Rocky", "Naked but proud", "https://cdn2.thecatapi.com/images/BDb8ZXb1v.jpg"),
                CatModel(Gender.Female, CatBreed.Ragdoll, "Molly", "Chill and charming", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Unknown, CatBreed.ScottishFold, "Milo", "Folded ears, full of curiosity", "https://cdn2.thecatapi.com/images/6q3.jpg")
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
