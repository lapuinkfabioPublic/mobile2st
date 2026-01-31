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
import com.fll.myapplication.business.UserBusiness
import com.fll.myapplication.databinding.ActivityLoginBinding
import com.fll.myapplication.util.AppConstants

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            insets
        }
        //se aprendemos com tentativas e acertos, não aprenderemos nada com A.I
        binding.btnLogin.setOnClickListener(this)
        binding.btnCadastro.setOnClickListener(this)
    }


    override fun onClick(v: View?) {

        if (v?.id == R.id.btnLogin) {
            val email = binding.editMail.text.toString()
            val password = binding.editSenha.text.toString()

            if (UserBusiness().checkCredencials(email, password)) {
                val bundle =  Bundle()
                bundle.putString(AppConstants.EMAIL_KEY, email)
                val intent: Intent = Intent(this, HomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, R.string.toast_msg_informe_dados, Toast.LENGTH_SHORT).show()
            }
        } else if (v?.id == R.id.btnCadastro) {
            //trata do registro
        }
    }


}