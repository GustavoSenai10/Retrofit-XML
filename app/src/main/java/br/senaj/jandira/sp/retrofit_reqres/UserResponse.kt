package br.senaj.jandira.sp.retrofit_reqres

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class UserResponse (

    //ID
    @SerializedName(
        "id"
    )var id:Int? = 0,

    //E-mail
    @SerializedName(
        "email"
    )var email:String =  "",

    //Primero nome
    @SerializedName(
        "first_name"
    )var first_name:String =  "",

    //Sobrenome
    @SerializedName(
        "last_name"
    )var last_name:String =  "",

    //Foto
    @SerializedName(
        "avatar"
    )var avatar:String =  ""
)