package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import rodrigo.kevin.R

class InicioSesionActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var btnIngresar: Button
    lateinit var tvRegistrarse: TextView
    lateinit var tvRecuperarContra: TextView
    lateinit var txtCorreo: EditText
    lateinit var txtContra: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        this.btnIngresar = findViewById(R.id.btnIngresar)
        this.tvRegistrarse = findViewById(R.id.lblRegistrarse)
        this.tvRecuperarContra = findViewById(R.id.lblOlvidoContra)
        this.txtCorreo = findViewById(R.id.txtCorreo)
        this.txtContra = findViewById(R.id.txtContra)

        this.btnIngresar.setOnClickListener {

            var correo = txtCorreo.text.toString()
            var contra = txtContra.text.toString()

            auth = Firebase.auth

            if (!correo.isEmpty() && !contra.isEmpty()){
                auth.signInWithEmailAndPassword(correo, contra)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d("Exito", "signInWithEmail:success")
                            val user = auth.currentUser
                            Toast.makeText(
                                baseContext,
                                "Se ha iniciado sesión correctamente.",
                                Toast.LENGTH_SHORT,
                            ).show()
                            var intent = Intent(this, MenuPrincipalActivity::class.java)
                          
                            startActivity(intent)
                        } else {
                            Log.w("Error", "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "No se ha iniciado sesión.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }else{
                Toast.makeText(
                    baseContext,
                    "Asegurate que ningun campo este vacio.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }

        this.tvRegistrarse.setOnClickListener{
            var intent = Intent(this, RegistroAplicacionActivity::class.java)
            startActivity(intent)
        }
    }

}