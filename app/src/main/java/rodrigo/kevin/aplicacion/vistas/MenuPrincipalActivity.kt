package rodrigo.kevin.aplicacion.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.adaptadores.adapterProductos
import rodrigo.kevin.aplicacion.modelos.Producto
import rodrigo.kevin.aplicacion.servicios.ServicioProductos

class MenuPrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.contenedorProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterProductos(ServicioProductos.listaProductosGeneral)
    }
}