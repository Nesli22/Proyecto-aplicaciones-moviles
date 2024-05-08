package rodrigo.kevin.aplicacion.vistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.servicios.ServicioUsuarios

class MenuPrincipalActivity : AppCompatActivity() {

    private lateinit var btnPerfil: ImageButton
    private lateinit var btnOrdenarAqui: Button
    private lateinit var txtUsuario: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        btnPerfil = findViewById(R.id.btnPerfil)
        btnOrdenarAqui = findViewById(R.id.btnOrdenar)
        txtUsuario = findViewById(R.id.txtUsuarioInicio)

        if (ServicioUsuarios.usuarioLogueado != null) {
            val usuario = ServicioUsuarios.usuarioLogueado!!
            txtUsuario.setText(usuario.nombre)
        }

        btnPerfil.setOnClickListener {
            val siguiente = Intent(this, PerfilActivity::class.java)
            startActivity(siguiente)
        }

        btnOrdenarAqui.setOnClickListener{
            val siguiente = Intent(this, OrdenarActivity::class.java)
            startActivity(siguiente)
        }

    }
}