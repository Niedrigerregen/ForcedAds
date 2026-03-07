//i don't really know kotlin or java so this is pretty much a hybrid from many tutorials

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.system.exitProcess

//function for the Program to send a request to to the Server
fun main() {

    val url = "http://localhost:8000/get_integer"
    val client = HttpClient.newHttpClient()

    while (true) {

        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
		//if there's a response then the game logs that, if not, it ends the game... or just the script i don't know while writing this
        if (response.statusCode() == 200) {
            println("Int.True")
            Thread.sleep(60000)
        } else {
            println("Int.False")
            exitProcess(0)
        }

    }
}
	