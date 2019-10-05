package layout

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Tings.com.tings.R
import Tings.com.tings.SpecificPurchaseActivity
//import Tings.com.tings.firebaseClasses.Payment
import Tings.com.tings.json.mov
import Tings.com.tings.room.Movie
import Tings.com.tings.room.Movies


class RecyclerAdapter(private val myDataset: MutableList<Movie> ) ://Array<String>//
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val v: View,val context: Context) : RecyclerView.ViewHolder(v) {
        val textView: TextView
        val textView2: TextView
        val textView3: TextView
        val textView4: TextView
        val textView5: TextView
        val textView6: TextView
//        val textView7: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = v.findViewById(R.id.textView)
            textView2 = v.findViewById(R.id.textView2)
            textView3 = v.findViewById(R.id.textView3)
            textView4 = v.findViewById(R.id.textView4)
            textView5 = v.findViewById(R.id.textView5)
            textView6 = v.findViewById(R.id.textView6)
//            textView7 = v.findViewById(R.id.textView7)
            v.setOnClickListener {
                Log.d("RecyclerAdapter", "Element $adapterPosition clicked.")
                val intent = Intent(context, SpecificPurchaseActivity::class.java)
                intent.putExtra("title",textView.text)//textViewNotVisible.text)
                intent.putExtra("image",textView4.text)
                intent.putExtra("rating",textView2.text)
                intent.putExtra("releaseYear",textView3.text)

                intent.putExtra("genre0",textView2.text)
                intent.putExtra("genre1",textView3.text)
                intent.putExtra("genre2",textView3.text)//not set yet
//                intent.putExtra("status",textView7.text)

                context.startActivity(intent)

            }
        }
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecyclerAdapter.MyViewHolder {
        // create a new view //textView

        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item_row, parent, false) //as TextView
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(textView,parent.context)//,myDatasetIds
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.textView.text = myDataset[position].title
        holder.textView2.text = myDataset[position].rating.toString()
        holder.textView3.text = myDataset[position].releaseYear.toString()
        holder.textView4.text = myDataset[position].image
//        holder.textView5.text = myDataset[position].sharedAmount.toString()
//        holder.textView6.text = myDataset[position].sharing_user_id
//        holder.textView7.text = myDataset[position].status

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}

