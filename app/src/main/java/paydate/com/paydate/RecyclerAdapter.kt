package layout

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import paydate.com.paydate.PurchaseActivity
import paydate.com.paydate.R
import paydate.com.paydate.SpecificPurchaseActivity
import paydate.com.paydate.firebaseClasses.Payment
import paydate.com.paydate.inflate


class RecyclerAdapter(private val myDataset: MutableList<Payment>,public val myDatasetIds: MutableList<String> ) ://Array<String>
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val v: View,val context: Context,myDatasetIds: MutableList<String>) : RecyclerView.ViewHolder(v) {
        val textView: TextView
        val textView2: TextView
        val textView3: TextView
        val textView4: TextView
        val textView5: TextView
        val textView6: TextView
        val textView7: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = v.findViewById(R.id.textView)
            textView2 = v.findViewById(R.id.textView2)
            textView3 = v.findViewById(R.id.textView3)
            textView4 = v.findViewById(R.id.textView4)
            textView5 = v.findViewById(R.id.textView5)
            textView6 = v.findViewById(R.id.textView6)
            textView7 = v.findViewById(R.id.textView7)
            v.setOnClickListener {
                Log.d("RecyclerAdapter", "Element $adapterPosition clicked.")
                val intent = Intent(context, SpecificPurchaseActivity::class.java)
                intent.putExtra("paymentId",myDatasetIds[adapterPosition])//textViewNotVisible.text)
                intent.putExtra("totalSum",textView4.text)
                intent.putExtra("business_id",textView.text)
                intent.putExtra("sharedAmount",textView5.text)

                intent.putExtra("date",textView2.text)
                intent.putExtra("endDate",textView3.text)
                intent.putExtra("partner",textView6.text)//not set yet
                intent.putExtra("status",textView7.text)

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

        return MyViewHolder(textView,parent.context,myDatasetIds)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.textView.text = myDataset[position].business_id
        holder.textView2.text = myDataset[position].date
        holder.textView3.text = myDataset[position].endDate
        holder.textView4.text = myDataset[position].totalSum
        holder.textView5.text = myDataset[position].sharedAmount.toString()
        holder.textView6.text = myDataset[position].sharing_user_id
        holder.textView7.text = myDataset[position].status

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}

