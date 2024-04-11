package rodrigo.kevin.aplicacion.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.modelos.Producto
class adapterProductos(private val productos: List<Producto>) :
    RecyclerView.Adapter<adapterProductos.viewHolderProducto>() {

    inner class viewHolderProducto(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imagenProducto)
        val nombre: TextView = itemView.findViewById(R.id.nombreProducto)
        val cantidad: TextView = itemView.findViewById(R.id.cantidadProducto)
        val precio: TextView = itemView.findViewById(R.id.precioProducto)
        val descripcion: TextView = itemView.findViewById(R.id.descripcionProducto)

        fun obtenerProducto(producto: Producto) {
            // Asignar los datos del producto a las vistas
            nombre.text = producto.nombre
            cantidad.text = producto.cantidad
            precio.text = producto.precio.toString() // Convertir el valor Double a cadena de texto
            descripcion.text = producto.descripcion

            // Cargar la imagen del producto (puedes usar una biblioteca como Glide o Picasso)
            // Glide.with(itemView.context).load(producto.imagen).into(imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderProducto {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return viewHolderProducto(view)
    }

    override fun onBindViewHolder(holder: viewHolderProducto, position: Int) {
        holder.obtenerProducto(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }
}