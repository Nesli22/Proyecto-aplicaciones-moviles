package rodrigo.kevin.aplicacion.servicios

import rodrigo.kevin.R
import rodrigo.kevin.aplicacion.modelos.Producto

class ServicioProductos {

    companion object{
       val listaProductosGeneral = listOf<Producto>(

           Producto(R.drawable.cafechilon, "Cafe Chilón, Chiapas.", "250gr", "$182", "Sabor Ácidez cítrica, miel."),
           Producto(R.drawable.cafehuatusco, "Cafe Huatusco, Veracruz.", "250gr", "$132", "Sabor clásico, caramelo, chocolate."),
           Producto(R.drawable.cafeoxchuc, "Cafe Oxchuc, Chiapas. ", "250gr", "$182", "Sabor Pera, uva verde, té de jazmín caramelo suave."),
           Producto(R.drawable.cafesimojovel, "Cafe Simojovel, Chiapas.", "250gr", "$182", "Sabor Manzana roja, frutos rojos, chocolate.")

       )
    }
}