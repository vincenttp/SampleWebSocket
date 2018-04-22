package mobile.pintusa.helper

import android.content.Context
import dagger.Module
import mobile.pintusa.BuildConfig

@Module
class SessionProvider(context: Context){
    private val sharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)


}