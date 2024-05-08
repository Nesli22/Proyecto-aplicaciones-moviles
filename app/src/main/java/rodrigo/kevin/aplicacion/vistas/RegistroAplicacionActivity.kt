package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.modelos.Usuario
import rodrigo.kevin.aplicacion.servicios.ServicioUsuarios
import java.util.UUID

class RegistroAplicacionActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    lateinit var txtNombre: EditText
    lateinit var txtCorreo: EditText
    lateinit var txtContra: EditText
    lateinit var txtConfirmarContra: EditText
    lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_aplicacion)

        this.txtNombre = findViewById(R.id.txtNombre)
        this.txtCorreo = findViewById(R.id.txtCorreo)
        this.txtContra = findViewById(R.id.txtContra)
        this.txtConfirmarContra = findViewById(R.id.txtConfirmContra)
        this.btnRegistrar = findViewById(R.id.btnRegistrarse)

        auth = Firebase.auth
        database = Firebase.database.reference

        this.btnRegistrar.setOnClickListener {
            var correo = this.txtCorreo.text.toString()
            var contra = this.txtContra.text.toString()
            var confirmarContra = this.txtConfirmarContra.text.toString()

            if (!correo.isEmpty() && !contra.isEmpty() && !confirmarContra.isEmpty()){
                if(contra == confirmarContra){

                    if (contra.length < 6){
                        Toast.makeText(
                            baseContext,
                            "Asegurate que la contraseña sea mayor o igual a 6 caracteres.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }else{
                        auth.createUserWithEmailAndPassword(correo, contra)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {

                                    Log.d("Exito", "createUserWithEmail:success")
                                    val user = auth.currentUser
                                    var userId = generarId()
                                    Toast.makeText(
                                        baseContext,
                                        "Te has registrado correctamente.",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                    crearUsuario(userId, correo, contra)
                                    var intent = Intent(this, InicioSesionActivity::class.java)
                                    startActivity(intent)
                                } else {

                                    Log.w("Error", "createUserWithEmail:failure", task.exception)
                                    Toast.makeText(
                                        baseContext,
                                        "No te has registrado.",
                                        Toast.LENGTH_SHORT,
                                    ).show()

                                }
                            }
                    }

                }else{
                    Toast.makeText(
                        baseContext,
                        "Las contraseñas no son iguales.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }else{
                Toast.makeText(
                    baseContext,
                    "Asegurate que ningun campo este vacio.",
                    Toast.LENGTH_SHORT,
                ).show()
            }



        }

    }

    private fun crearUsuario(usuarioId: String, correo: String, contra: String){
        var nombre = this.txtNombre.text.toString()
        var email = this.txtCorreo.text.toString()
        var contra = this.txtContra.text.toString()
        val usuario = Usuario(nombre, email, contra)

        ServicioUsuarios.usuarioLogueado = usuario

        database.child("usuarios").child(usuarioId).setValue(usuario)
    }

    fun generarId(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }
}