package rodrigo.kevin.aplicacion.modelos
import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Usuario(
    var nombre: String,
    var correo: String,
    var contraseña: String

): Serializable
