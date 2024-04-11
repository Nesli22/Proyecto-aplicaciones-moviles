package rodrigo.kevin.aplicacion.modelos

import java.io.Serializable

data class Producto(
    var imagen: String,
    var nombre: String,
    var cantidad: String,
    var precio: Double,
    var descripcion: String

): Serializable
