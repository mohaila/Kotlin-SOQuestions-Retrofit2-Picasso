package ca.qc.mtl.mohaila.kotlinsoquestionsretrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        val adapter = Adapter(this)
        recyclerview.adapter = adapter
        adapter.getQuestions()
    }
}
