package com.example.minhasanotaeskotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferencias: AnotacoesPreferencias
    private lateinit var editAnotacao: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editAnotacao = findViewById(R.id.editAnotacao)
        preferencias = AnotacoesPreferencias(applicationContext)

        fab.setOnClickListener { view ->

            val textoRecuperado = editAnotacao.text.toString()

            //Validando se o campo tem anotação
            if(textoRecuperado.equals("")) {
                Snackbar.make(view, "Digite alguma anotação!!", Snackbar.LENGTH_LONG).show()
            } else {
                preferencias.salvarNome(textoRecuperado)
                Snackbar.make(view, "Anotação salva com sucesso!!", Snackbar.LENGTH_LONG).show()
            }
        }

        val anotacao: String? = preferencias.retornarNome()

        if(!anotacao.equals("")) {
            editAnotacao.setText(anotacao)
        }
    }
}
