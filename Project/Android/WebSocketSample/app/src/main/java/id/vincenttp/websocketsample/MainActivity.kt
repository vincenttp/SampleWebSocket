package id.vincenttp.websocketsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class MainActivity : AppCompatActivity() {
    lateinit var request: Request
    lateinit var ws: WebSocket
    var client = OkHttpClient()
    val echoWebSocketListener = EchoWebSocketListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        request = Request.Builder().url("ws://socket.bg.grvty.space/v1/ws/homepage").build()
        ws = client.newWebSocket(request, echoWebSocketListener)
        client.dispatcher().executorService().shutdown()

    }
}
