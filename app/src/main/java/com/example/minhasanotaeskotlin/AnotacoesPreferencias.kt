package com.example.minhasanotaeskotlin

import android.content.Context
import android.content.SharedPreferences

data class AnotacoesPreferencias(var context: Context) {

    private val NOME_ARQUIVO: String = "anotacao.preferencias"
    private val CHAVE_NOME: String = "nome"

    private var preferences: SharedPreferences = context.getSharedPreferences(NOME_ARQUIVO,0)
    private var editor: SharedPreferences.Editor = preferences.edit()

    fun salvarNome(anotacao: String){
        editor.putString(CHAVE_NOME,anotacao)
        editor.commit()
    }

    fun retornarNome(): String? {
        return preferences.getString(CHAVE_NOME,"")
    }
}