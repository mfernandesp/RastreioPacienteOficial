package com.example.rastreiopacienteoficial

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rastreiopaciente.Banco.Banco
import com.example.rastreiopaciente.Banco.Paciente

class ProcurarPaciente : AppCompatActivity() {

    lateinit var banco: Banco
    lateinit var listaPaciente: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procurar_paciente)

        banco = Room.databaseBuilder(applicationContext, Banco::class.java, "RastreioPaciente").allowMainThreadQueries().build()

        listaPaciente = findViewById<ListView>(R.id.listViewPesquisa)

        var adapter: ArrayAdapter<String>

        var selectBanco: List<Paciente>
        selectBanco = banco.pacienteCrud().listarPacientes()


        var dado: MutableList<String> = ArrayList()

        for(paciente in selectBanco) {
            dado.add(paciente.nome!!)
        }

        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, dado)

        listaPaciente.adapter = adapter

        //listaPaciente.setOnItemClickListener()
    }
}
