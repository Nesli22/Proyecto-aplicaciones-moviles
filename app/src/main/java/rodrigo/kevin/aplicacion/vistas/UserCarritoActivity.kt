package rodrigo.kevin.aplicacion.vistas

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.adaptadores.adapterProductos
import rodrigo.kevin.aplicacion.modelos.Producto

class UserCarritoActivity : AppCompatActivity() {

    private lateinit var adapterProductos: adapterProductos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_carrito)

        // Obtener la lista de productos desde el intent o una fuente de datos
        val productos = getProductos()

        // Configurar el RecyclerView y el adaptador
        val rvProductos = findViewById<RecyclerView>(R.id.rvProductos)
        adapterProductos = adapterProductos(productos)
        rvProductos.adapter = adapterProductos
        rvProductos.layoutManager = LinearLayoutManager(this)
    }

    private fun getProductos(): List<Producto> {
        // Devuelve una lista de productos desde una fuente de datos
        // Por ejemplo, desde una base de datos, una API o un archivo local
        return listOf(
            Producto("imagen1", "Producto 1", "10", 19.99, "Descripción del producto 1"),
            Producto("imagen2", "Producto 2", "5", 29.99, "Descripción del producto 2"),
            Producto("imagen3", "Producto 3", "20", 9.99, "Descripción del producto 3")
        )
    }
}





//    // Elementos de la interfaz de usuario
//    private lateinit var tvCarritoTitle: TextView
//    private lateinit var rvProductosCarrito: RecyclerView
//    private lateinit var tvTotalCarrito: TextView
//    private lateinit var btnRealizarPedido: Button
//
//    // Datos del carrito
//    private val productosCarrito = mutableListOf<Producto>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_carrito)
//
//        // Inicializar elementos de la interfaz de usuario
//        tvCarritoTitle = findViewById(R.id.tvCarritoTitle)
//        rvProductosCarrito = findViewById(R.id.rvProductosCarrito)
//        tvTotalCarrito = findViewById(R.id.tvTotalCarrito)
//        btnRealizarPedido = findViewById(R.id.btnRealizarPedido)
//
//        // Configurar RecyclerView
//        rvProductosCarrito.layoutManager = LinearLayoutManager(this)
//        val productoAdapter = ProductoAdapter(productosCarrito)
//        rvProductosCarrito.adapter = productoAdapter
//
//        // Calcular total del carrito
//        calcularTotalCarrito()
//
//        // Configurar botón de realizar pedido
//        btnRealizarPedido.setOnClickListener {
//            realizarPedido()
//        }
//    }
//
//    // Método para calcular el total del carrito
//    private fun calcularTotalCarrito() {
//        var total = 0.0
//        for (producto in productosCarrito) {
//            total += producto.precio * producto.cantidad
//        }
//        tvTotalCarrito.text = "Total: $" + total
//    }
//
//    // Método para realizar el pedido
//    private fun realizarPedido() {
//        // Aquí puedes implementar la lógica para realizar el pedido
//        // Por ejemplo, enviar los datos del carrito a un servidor o procesar el pago
//        Toast.makeText(this, "Pedido realizado", Toast.LENGTH_SHORT).show()


