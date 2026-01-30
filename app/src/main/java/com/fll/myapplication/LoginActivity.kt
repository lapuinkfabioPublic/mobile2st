package com.fll.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fll.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            insets
        }

        //se aprendemos com tentativas e acertos, não aprenderemos nada com A.I

        binding.btnLogin.setOnClickListener ( this )
        binding.btnCadastro.setOnClickListener ( this )
    }

    //tratando ev
    override fun onClick(v: View?) {

        if (v?.id == R.id.btnLogin)
        {
            val email = binding.editMail.text.toString()
            val password = binding.editSenha.text.toString()

            if(!email.isNullOrEmpty() && !password.isNullOrEmpty())
            {
                val intent :  Intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, R.string.toast_msg_informe_dados, Toast.LENGTH_SHORT).show()
            }
        }
        else if (v?.id == R.id.btnCadastro){
            //trata do registro
        }
    }



}