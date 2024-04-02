package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import rodrigo.kevin.R

class RegistroAplicacionActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var txtCorreo: EditText
    lateinit var txtContra: EditText
    lateinit var txtConfirmarContra: EditText
    lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_aplicacion)

        this.txtCorreo = findViewById(R.id.txtCorreo)
        this.txtContra = findViewById(R.id.txtContra)
        this.txtConfirmarContra = findViewById(R.id.txtConfirmContra)
        this.btnRegistrar = findViewById(R.id.btnRegistrarse)

        auth = Firebase.auth

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
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("Exito", "createUserWithEmail:success")
                                    val user = auth.currentUser
                                    Toast.makeText(
                                        baseContext,
                                        "Te has registrado correctamente.",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                    var intent = Intent(this, InicioSesionActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    // If sign in fails, display a message to the user.
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
}