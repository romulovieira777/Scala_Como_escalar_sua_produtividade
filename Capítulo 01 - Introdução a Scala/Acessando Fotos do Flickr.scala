// 2 Acessando Fotos do Flickr

object ClienteFlickr extends App {
val apiKey = "sua-api-key"
val method = "flickr.photos.search"
val tags = "scala"

val url = s"https://api.flickr.com/services/rest/?method=$method&api_key=$apiKey&tags=$tags"

scala.io.Source.fromURL(url).getLines().foreach(println)
}

scalac ClienteFlickr.scala
scala ClienteFlickr


val props = new Properties()
props.load(getClass.getClassLoader.getResourceAsStream("cap02/config.properties"))

val apiKey = props.getProperty("flickr.api.key")


class Foto(val id: Long, val owner: String, val title: String, val farm: Int)

val fotos = parseiaResultado(resultadoServico)
val countFotosFarm7 = fotos.count(foto => foto.farm == 2)
