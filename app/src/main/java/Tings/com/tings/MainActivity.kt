package Tings.com.tings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

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
