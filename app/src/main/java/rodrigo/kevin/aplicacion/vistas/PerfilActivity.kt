package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.servicios.ServicioUsuarios

class PerfilActivity : AppCompatActivity() {

    lateinit var txtNombre: EditText
    lateinit var txtCorreo: EditText
    lateinit var txtContra: EditText
    lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        txtNombre = findViewById(R.id.txtNombrePerfil)
        txtCorreo = findViewById(R.id.txtCorreoPerfil)
        txtContra = findViewById(R.id.txtContraPerfil)
        btnVolver = findViewById(R.id.btnVolver)

        if (ServicioUsuarios.usuarioLogueado != null) {
            val usuario = ServicioUsuarios.usuarioLogueado!!
            txtNombre.setText(usuario.nombre)
            txtCorreo.setText(usuario.correo)
            txtContra.setText(usuario.contraseña)
        }

        this.btnVolver.setOnClickListener{
            val siguiente = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(siguiente)
        }

    }
}