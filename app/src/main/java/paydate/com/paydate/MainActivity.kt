package paydate.com.paydate

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.FirebaseFirestore
import paydate.com.paydate.R.layout.activity_purchase

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("main","main2")


    }

    override fun onStart() {
        super.onStart()
        getTransaction()
    }


    fun getTransaction(){
        val TAG="getTransaction"
        val db = FirebaseFirestore.getInstance()
        db.collection("payments")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                        Log.d(TAG,"${document.data.get("totalSum")}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "Error getting documents: ", exception)
                }



    }
//    fun onPurchase(view: View){
//        val downloadIntent = Intent(this, DownloadService::class.java).apply {
//            data = Uri.parse(fileUrl)
//
//            val intent= Intent(this, PurchaseActivity::class)
//    }
}
