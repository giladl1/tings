package paydate.com.paydate.DialogFragment
import android.content.ContentValues
//import javafx.scene.layout.GridPane.getColumnIndex

import android.content.DialogInterface
import android.os.Bundle
import android.R.string.cancel
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.database.sqlite.SQLiteDatabase
import android.view.View
import androidx.fragment.app.DialogFragment
import android.view.ViewGroup
import android.widget.*
import com.google.common.collect.Iterables
import kotlinx.android.synthetic.main.dialog_pay_back.*
import paydate.com.paydate.R
import paydate.com.paydate.SpecificPurchaseActivity

class PaybackDialogFragment : DialogFragment() {

        internal var mNum: Int = 0
        var organization: String =""
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mNum = arguments!!.getInt("num")

            // Pick a style based on the num.
            var style = DialogFragment.STYLE_NORMAL
            var theme = 0
            when ((mNum - 1) % 6) {
                1 -> style = DialogFragment.STYLE_NO_TITLE
                2 -> style = DialogFragment.STYLE_NO_FRAME
                3 -> style = DialogFragment.STYLE_NO_INPUT
                4 -> style = DialogFragment.STYLE_NORMAL
                5 -> style = DialogFragment.STYLE_NORMAL
                6 -> style = DialogFragment.STYLE_NO_TITLE
                7 -> style = DialogFragment.STYLE_NO_FRAME
                8 -> style = DialogFragment.STYLE_NORMAL
            }
            when ((mNum - 1) % 6) {
                4 -> theme = android.R.style.Theme_Holo
                5 -> theme = android.R.style.Theme_Holo_Light_Dialog
                6 -> theme = android.R.style.Theme_Holo_Light
                7 -> theme = android.R.style.Theme_Holo_Light_Panel
                8 -> theme = android.R.style.Theme_Holo_Light
            }
            setStyle(style, theme)
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val v = inflater.inflate( R.layout.dialog_pay_back, container, false)
//            val tv = v.findViewById(R.id.text)
//            (tv as TextView).text = ("Dialog #" + mNum + ": using style "
//                    + getNameForNum(mNum))
            val radioButton1= v.findViewById(R.id.radBut1) as RadioButton
            radioButton1.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    spinner.visibility=View.GONE
//                    (activity as SpecificPurchaseActivity).cancelDialo()
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            val radioButton2= v.findViewById(R.id.radBut2) as RadioButton
            radioButton2.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    spinner.visibility=View.VISIBLE
                    fillSpinner()

//                    (activity as SpecificPurchaseActivity).cancelDialo()
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            // Watch for button clicks.
            val cancelButton = v.findViewById(R.id.cancelButton) as Button
            cancelButton.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    // When button is clicked, call up to owning activity.
                    (activity as SpecificPurchaseActivity).cancelDialog() //showDialog()
                    //
                }
            })
            val applyButton = v.findViewById(R.id.applyButton) as Button
            applyButton.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View) {
                    val sharedSum: String = editTextSharedSum.text.toString()
                    //todo if{ user chose organization and wrote the sum}
                    (activity as SpecificPurchaseActivity).applyDialog(sharedSum,organization)
                }
            })

            return v
        }

        fun fillSpinner(){
            var list_of_items = arrayOf("Al-Sam", "Latet", "Bet Hashanti")
            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    spinner.setSelection(position)
                    organization=list_of_items[position]
                }

            }

            val aa = ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, list_of_items)
            // Set layout to use when the list of choices appear
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            spinner!!.setAdapter(aa)


        }

//        companion object {
//
//            /**
//             * Create a new instance of MyDialogFragment, providing "num"
//             * as an argument.
//             */
//            internal fun newInstance(num: Int): PaybackDialogFragment {
//                val f = PaybackDialogFragment()
//
//                // Supply num input as an argument.
//                val args = Bundle()
//                args.putInt("num", num)
//                f.arguments = args
//
//                return f
//            }
//        }


//    fun showDialog() {
//        mStackLevel++
//
//        // DialogFragment.show() will take care of adding the fragment
//        // in a transaction.  We also want to remove any currently showing
//        // dialog, so make our own transaction and take care of that here.
//        val ft = fragmentManager!!.beginTransaction()
//        val prev = fragmentManager!!.findFragmentByTag("dialog")
//        if (prev != null) {
//            ft.remove(prev)
//        }
//        ft.addToBackStack(null)
//
//        // Create and show the dialog.
//        val newFragment = MyDialogFragment.newInstance(mStackLevel)
//        newFragment.show(ft, "dialog")
//    }
}