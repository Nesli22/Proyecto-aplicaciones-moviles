package rodrigo.kevin.aplicacion.adaptadores

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.modelos.Producto

class viewHolderProducto(val view: View) : RecyclerView.ViewHolder(view){

    val imagen = view.findViewById<ImageView>(R.id.imagenProducto)
    val nombre = view.findViewById<TextView>(R.id.nombreProducto)
    val cantidad = view.findViewById<TextView>(R.id.cantidadProducto)
    var precio = view.findViewById<TextView>(R.id.precioProducto)
    val descripcion = view.findViewById<TextView>(R.id.descripcionProducto)

    fun obtenerProducto(producto: Producto){
        nombre.text = producto.nombre
        cantidad.text = producto.cantidad
        precio.text = producto.precio.toString()
        descripcion.text = producto.descripcion
    }
}