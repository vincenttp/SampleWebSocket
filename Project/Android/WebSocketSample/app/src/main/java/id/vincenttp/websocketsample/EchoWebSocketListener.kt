package id.vincenttp.websocketsample

import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class EchoWebSocketListener: WebSocketListener() {
    override fun onOpen(webSocket: WebSocket?, response: Response?) {
        webSocket!!.send("Hello, it's SSaurel !")
        webSocket!!.send("What's up ?")
        webSocket.send(ByteString.decodeHex("deadbeef"))
        webSocket.close(1000, "Goodbye !")

    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        println("EchoWebSocketListener onFailure $response")
    }

    override fun onClosing(webSocket: WebSocket?, code: Int, reason: String?) {
        println("EchoWebSocketListener onClosing $reason")
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        println("EchoWebSocketListener onMessage $text")
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString?) {
        println("EchoWebSocketListener onMessage ${bytes!!.hex()}")
    }

    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        println("EchoWebSocketListener onClosedv $reason")
    }
}