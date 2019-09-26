package paydate.com.paydate

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_specific_purchase.*
import kotlinx.android.synthetic.main.content_specific_purchase.*

//import javafx.scene.Cursor.cursor
import android.content.Intent
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.model.value.IntegerValue
import paydate.com.paydate.DialogFragment.PaybackDialogFragment


class SpecificPurchaseActivity : AppCompatActivity() {
    var pbdf = PaybackDialogFragment()
    var paymentId:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_purchase)
        setSupportActionBar(toolbar)
        paymentId= intent.getStringExtra("paymentId")
        val totalSum:String = intent.getStringExtra("totalSum")
        val business_id:String = intent.getStringExtra("business_id")
        val sharedAmount:String = intent.getStringExtra("sharedAmount")

        val date:String = intent.getStringExtra("date")
        val endDate:String = intent.getStringExtra("endDate")
        val partner:String = intent.getStringExtra("partner")
        val status:String = intent.getStringExtra("status")

        textViewTotalPrice.text="Total Sum: " + totalSum
        textViewDate.text= date
        textViewEndDate.text="End Date: " + endDate
        textViewBusiness.text= business_id
        textViewPartner.text= partner
        textViewStatus.text="Status: " + status
        if(sharedAmount.equals(""))
            textViewPaybackSum.text=textViewPaybackSum.text.toString()+" 0"

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

//        show_dialog_frag()
    }

    fun show_dialog_frag(view: View) {
//        pbdf = PaybackDialogFragment()
        val args = Bundle()
//        args.putString("count_id", count_id)
//        args.putString("name", count_name)
        pbdf.setArguments(args)
        pbdf.show(supportFragmentManager, "counts")//fragmentManager
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent?) {
        if(data!=null) {
            var stam: Int = 8
        }

    }
    fun cancelDialog(){
        pbdf.dismiss()
    }
    fun applyDialog(sharedsum: String,organization: String ){
        textViewPaybackSum.text ="Payback Sum: " + sharedsum.toString() +
                " payed to: "+organization
//        editButton.isClickable=false
        pbdf.dismiss()
        updateTransaction(sharedsum,organization)
    }

    private fun updateTransaction(sharedsum: String, organization: String) {
        val data = hashMapOf("donateOrganization" to organization,"sharedAmount" to sharedsum)
        val db = FirebaseFirestore.getInstance()
        db.collection("payments").document(paymentId)
                .set(data, SetOptions.merge())

    }

}
