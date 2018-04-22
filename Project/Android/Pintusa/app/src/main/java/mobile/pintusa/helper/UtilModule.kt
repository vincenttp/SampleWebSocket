package mobile.pintusa.helper

import android.content.Context
import android.widget.Toast
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Module
class UtilModule @Inject constructor(){
    @Singleton
    fun toastShort(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Singleton
    @Provides
    fun currentTimeString(): String{
        val date = Date(System.currentTimeMillis())
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dateFormatted = formatter.format(date)
        return dateFormatted
    }
}