package paydate.com.paydate

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_my_purchases.*
import kotlinx.android.synthetic.main.content_my_purchases.*
import layout.RecyclerAdapter
import paydate.com.paydate.firebaseClasses.Payment

class MyPurchasesActivity : AppCompatActivity() {
    val MY_PERMISSIONS_REQUEST_INTERNET=1
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataset: Array<String>
    private lateinit var list : MutableList<String>
    private lateinit var paymentIds : MutableList<String>
    private lateinit var paymentList : MutableList<Payment>
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_purchases)
        setSupportActionBar(toolbar)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            askPermission()
        }
        else askPermission();

        initDataset()
        getPurchasesFromFirebase();



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onStart() {
        super.onStart()

    }
    fun toPurchase(view: View){
        val intent = Intent(this, PurchaseActivity::class.java)
        startActivity(intent);
    }
    fun askPermission(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.INTERNET)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.INTERNET),
                        MY_PERMISSIONS_REQUEST_INTERNET)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }
    fun getPurchasesFromFirebase(){

        db.collection("payments")
                .get()
                .addOnSuccessListener { result ->

                    for (document in result) {
                        var payment : Payment=document.toObject(Payment::class.java)

                        paymentList.add(payment)
                        paymentIds.add(document.id)//we need the document id to change the id in the recyclerview
                        list.add(document.data.toString())
//                        dataset[i]=(document.data.toString())
                        Log.d("TAG", "${document.id} => ${document.data}")
                    }
                    dataset=list.toTypedArray()
                    operateAdapter()
                }
                .addOnFailureListener { exception ->
                    Log.d("TAG", "Error getting documents: ", exception)
                }
    }
    private fun initDataset() {
//        dataset = Array(60, {i -> "This is element # $i"})
        list= arrayListOf()
        paymentList= arrayListOf()
        paymentIds = arrayListOf()
    }
    private fun operateAdapter(){

        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerAdapter(paymentList, paymentIds )//dataset

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }


}
