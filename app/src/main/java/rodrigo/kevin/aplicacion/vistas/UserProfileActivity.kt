package rodrigo.kevin.aplicacion.vistas

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import rodrigo.kevin.R

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Find views by ID
        val ivProfilePicture = findViewById<ImageView>(R.id.ivProfilePicture)
        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhoneNumber = findViewById<TextView>(R.id.tvPhoneNumber)
        val btnEditProfile = findViewById<Button>(R.id.btnEditProfile)

        // Set data for views
        ivProfilePicture.setImageResource(R.drawable.perfil)
        tvUserName.text = "John Doe"
        tvEmail.text = "johndoe@example.com"
        tvPhoneNumber.text = "+1 123 456 7890"

        // Set click listener for edit profile button
        btnEditProfile.setOnClickListener {
            // Handle edit profile button click
        }
    }
}