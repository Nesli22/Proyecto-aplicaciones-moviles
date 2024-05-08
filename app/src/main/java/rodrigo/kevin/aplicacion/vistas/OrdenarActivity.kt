package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.adaptadores.adapterProductos
import rodrigo.kevin.aplicacion.servicios.ServicioProductos

class OrdenarActivity : AppCompatActivity() {

    private lateinit var btnInicio: ImageButton
    private lateinit var btnPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordenar)

        btnInicio = findViewById(R.id.btnInicio)
        btnPerfil = findViewById(R.id.btnPerfil)

        btnInicio.setOnClickListener{
            val siguiente = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(siguiente)
        }

        btnPerfil.setOnClickListener{
            val siguiente = Intent(this, PerfilActivity::class.java)
            startActivity(siguiente)
        }

        initRecyclerView()


    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.contenedorProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterProductos(ServicioProductos.listaProductosGeneral)
    }


}