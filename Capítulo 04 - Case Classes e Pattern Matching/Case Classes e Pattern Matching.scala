// Case Classes e Pattern Matching

case class Media(value: String)

val fotos = Media("fotos")
val videos = Media("videos")
val all = Media("all")

fotos == new Media("fotos")     // true
videos == new Media("videos")   // true
fotos == videos                 // false

println(videos)


// Refatorando o Código

class Media(value: String)

case object Fotos extends Media("fotos")
case object Videos extends Media("videos")
case object Todas extends Media("all")


// Declarando as Constantes
val FOTOS = 1
val VIDEOS = 2
val TODAS = 3


val midia = 1
midia match {
case FOTOS => println("processando fotos")
case VIDEOS => println("processando videos")
case _ => println("processando qualquer outra coisa")
}


// Outra forma de código 
val midia = 1
val texto = midia match {
case FOTOS => "processando fotos"
case VIDEOS => "processando videos"
case _ => "processando qualquer outra coisa"
}

println(texto)


// Outra forma de código
val midia = 1
val resultado = midia match {
case FOTOS => "processando fotos"
case VIDEOS => "processando videos"
case _ => -1
}

println(resultado)


// Refatorando o código anterior
val midia = Fotos
val texto = midia match {
case Fotos => "processando fotos"
case Videos => "processando videos"
case _ => "processando qualquer outra coisa"
}

println(texto)


// Criando o unapply
class Foto(val id: Int, val owner: String, val title: String, val
farm: Int)
object Foto {
	def unapply(foto: Foto): Option[(Int, String, String, Int)] =
		Some((foto.id, foto.owner, foto.title, foto.farm))
}


// Utilizando o método apply
class Foto(val id: Int, val owner: String, val title: String, val
farm: Int)
object Foto {
	def apply(id: Int, owner: String, title: String, farm: Int) =
		new Foto(id, owner, title, farm)
}

val foto = Foto(1, "jcranky", "foto do jcranky", 7)


// Criando uma lista de fotos
val fotos = List(foto1, foto2, foto3)


// Acessando um elemento da lista
val fotoUm = fotos(0)


// Gera o mesmo resultado
val fotoUm = fotos.apply(0)
