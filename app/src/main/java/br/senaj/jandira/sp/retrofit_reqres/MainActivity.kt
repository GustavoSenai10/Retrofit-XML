package br.senaj.jandira.sp.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
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

            //Log.e("PUT-DATA", "TESTE DE BOTÃO")
            updateUser()
        }

        //Botão De DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{

            //Log.e("DELETE-DATA", "TESTE DE BOTÃO")
            deleteUser()
        }


        //Botão De POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener{

            //Log.e("POSTING-DATA", "TESTE DE BOTÃO")
            createUser()
        }
    }

    //Listagem de usuário
    private fun getUserByID() {

        lifecycleScope.launch{
            val result = apiService.getUserByID("2")

            if (result.isSuccessful){

                Log.e("GETTING-DATA", "${result.body()?.data}")
            }
            else{

                Log.e("GETTING-DATA", "${result.message()}")
            }
        }
    }

    //INSERE USUÁRIO
    private fun createUser(){

        lifecycleScope.launch {

            val body = JsonObject().apply{
                addProperty(
                    "name",
                    "Gustavo Souza "
                )

                addProperty(
                    "job",
                    "SENAI"
                )
            }

            val result =apiService.createUser(body)

            if (result.isSuccessful){

                Log.e("CREATE-DATA", "${result.body()}")
            }
            else{

                Log.e("CREATE-DATA", "${result.message()}")
            }
        }

    }

    //Altera usuário
    private fun updateUser(){

        lifecycleScope.launch {


            val body = JsonObject().apply{
                addProperty(
                    "name",
                    "Cavalo "
                )

                addProperty(
                    "job",
                    "FATEC"
                )
            }

            val result = apiService.updateUser("2", body)

            if (result.isSuccessful){

                Log.e("UPDATE-DATA", "${result.body()}")
            }
            else{

                Log.e("UPDATE-DATA", "${result.message()}")
            }
        }
        }


    //Excluir Usuário

    private fun deleteUser(){
        lifecycleScope.launch{
            val result = apiService.deleteUser("2")

            if (result.isSuccessful){

                Log.e("DELETE-DATA", "${result}")
            }
            else{

                Log.e("DELETE-DATA", "${result.message()}")
            }
        }
    }

    }