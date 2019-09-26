package paydate.com.paydate.firebaseClasses

import android.provider.ContactsContract

data class Payment(
        val business_id: String? = null,
        val payer_user_id: String? = null,
        val sharedAmount: String? = null,
        val sharing_user_id: String? = null,
        val totalSum: String? = null,
        val date: String? = null,
        val donateOrganization: String?=null,
        val endDate: String? = null,
        val status: String? = null

)