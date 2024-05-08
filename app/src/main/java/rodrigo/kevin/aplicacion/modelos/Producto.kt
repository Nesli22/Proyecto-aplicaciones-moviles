package rodrigo.kevin.aplicacion.modelos

import android.media.Image
import java.io.Serializable

data class Producto(
    var imagen: Int,
    var nombre: String,
    var cantidad: String,
    var precio: String,
    var descripcion: String

): Serializable
