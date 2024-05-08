package rodrigo.kevin.aplicacion.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.modelos.Producto

class adapterProductos(private val listaProductos: List<Producto>): RecyclerView.Adapter<viewHolderProducto>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderProducto {
        val layoutInflater = LayoutInflater.from(parent.context)
        return viewHolderProducto(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }

    override fun getItemCount(): Int = listaProductos.size


    override fun onBindViewHolder(holder: viewHolderProducto, position: Int) {
        val item = listaProductos[position]
        holder.obtenerProducto(item)
    }
}