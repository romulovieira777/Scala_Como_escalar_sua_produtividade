// 3 Classes e Objetos

// Definindo uma classe
class FlickrCaller {
	val apikey: String = "sua-api-key"
}


// Definindo uma função
def buscaFotos(tag: String): Seq[Foto] = {
	// algoritmo (complexo?) de acesso ao Flickr aqui
	return ???
}


// Definindo duas funções de soma
def soma(x: Int, y: Int) = x + y  // Omiti o tipo de retorno

def soma(x: Int, y: Int): Int = x + y  // Define o tipo de retorno como Int

def soma(x: Int, y: Int) = x + y + 1.0  // Omiti o tipo de retorno que será Double


// Definindo uma função
def usuarioAtual() = usuarioOpt match {
case Some(usuario) => usuario
case None => "anônimo"
}


val usuario1 = usuarioAtual()
val usuario2 = usuarioAtual


// Definindo uma classe
class FlickrCaller(api: String) {
def this() = this("")
}


def buscaFotos(tag: String = "", userId: String = "") = ???

buscaFotos("scala")
buscaFotos(userId = "userid")
buscaFotos("scala", userId = "userid")


// Criando um objeto
object Media {
val fotos = "fotos"
val videos = "videos"
val todas = "all"
}

println(Media.fotos)
println(Media.videos)
println(Media.todas)


// Criando uma classe
abstract class Media(val value: String)


// Criando objetos
object Fotos extends Media("fotos")
object Videos extends Media("videos")
object Todas extends Media("all")


