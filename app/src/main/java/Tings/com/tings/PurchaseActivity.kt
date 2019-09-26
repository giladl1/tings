package Tings.com.tings

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class PurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)
    }

    fun pay(view: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted

        } else {
            var sumEditText = findViewById<EditText>(R.id.sumEditText)
            var totalSum = sumEditText.text.toString()
            var sharedEditText = findViewById<EditText>(R.id.sharedSumEditText)
            var sharedAmount = sharedEditText.text.toString()
            var payer_user_id = "03630"
            var sharing_user_id = "072770"
            var business_id = "654654"
            var status = "open"
            var date = getCurrentDate()
            var plusDays:Int=4
            var endDate = changeDate(date,plusDays)

            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val dateFormatted = sdf.format(date)
            val endDateFormatted=sdf.format(endDate)

//
            val db = FirebaseFirestore.getInstance()


        // Create a new user with a first and last name
        val payment = hashMapOf(
                "totalSum" to totalSum,
                "sharedAmount" to sharedAmount,
                "payer_user_id" to payer_user_id,
                "sharing_user_id" to sharing_user_id,
                "business_id" to business_id,
                "status" to status,
                "date" to dateFormatted,
                "endDate" to endDateFormatted

        )

// Add a new document with a generated ID
        db.collection("payments")
                .add(payment)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                    Toast.makeText(this, "payment was added.", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }

        }
    }



//    fun to_purchases(view: View){
//        val intent = Intent(this, MyPurchasesActivity::class.java)
//        startActivity(intent);
//    }
    fun getCurrentDate(): Date? {
        val calendar = Calendar.getInstance()
        return calendar.time


//        return currentDate
    }
    private fun changeDate(date: Date?, plusDays: Int): Date? {
//        val calendar = Calendar.getInstance()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DAY_OF_YEAR, plusDays)

        return cal.time
//        val currentTimestamp = System.currentTimeMillis()
//        currentTimestamp.plus()
//        val endDateStamp=currentTimestamp+plusDays*24*60*60*1000
//        val sdf = SimpleDateFormat("dd/MM/yyyy")
//        val currentDate = sdf.format(endDateStamp)

    }
}
