package br.senaj.jandira.sp.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //Botão De GET
        findViewById<Button>(R.id.btnGET).setOnClickListener {
            //Log.e("GETTING-DATA", "TESTE DE BOTÃO")
            getUserByID()
    }

        //Botão De PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener{
            Log.e("PUT-DATA", "TESTE DE BOTÃO")

        }

        //Botão De DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            Log.e("DELETE-DATA", "TESTE DE BOTÃO")

        }


        //Botão De POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener{
            Log.e("POSTING-DATA", "TESTE DE BOTÃO")

        }
    }

    private fun getUserByID() {
        lifecycleScope.launch{
            val result = apiService.getUserByID("2")

            if (result.isSuccessful){
                Log.e("GETTING-DATA", "${result.body()?.data}")
            }else{
                Log.e("GETTING-DATA", "${result.message()}")
            }
        }
    }
}