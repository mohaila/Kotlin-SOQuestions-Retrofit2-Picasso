package ca.qc.mtl.mohaila.kotlinsoquestionsretrofit2

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Adapter(private val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>(), Callback<Questions> {
    private var questions = ArrayList<Question>()

    fun getQuestions() {
        val so = SOQuestionsInterface.create()
        so.getQuestions().enqueue(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questions.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = questions[position].title
        Picasso.with(context).load(questions[position].owner.avatar)
            .fit()
            .centerCrop()
            .placeholder(R.drawable.ic_account_circle)
            .error(R.drawable.ic_account_circle_red)
            .into(holder.imageview)
    }

    override fun onFailure(call: Call<Questions>, t: Throwable) {
        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
        questions.addAll(response.body()!!.questions)

        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView = itemView.findViewById<TextView>(R.id.title)
        val cardView = itemView.findViewById<CardView>(R.id.cardview)
        val imageview = itemView.findViewById<ImageView>(R.id.imageview)

        init {
            cardView.setOnClickListener {
                val question = questions[adapterPosition]
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(question.link))
                it.context.startActivity(intent)
            }
        }
    }
}