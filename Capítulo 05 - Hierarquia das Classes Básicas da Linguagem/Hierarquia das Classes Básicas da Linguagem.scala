// Hierarquia das Classes Básicas da Linguagem

// Criando uma função
def buscaFotos(tag: Option[String]) = ???

buscaFotos(Some("scala"))
buscaFotos(None)


val tagBusca = tag.getOrElse("sem tag")
val tagBusca = tag.get
val tagExiste = tag.isDefined


// Definindo uma Classe
class Foto(id: String, owner: String, server: Int, title: String)

try {
	buscaFotos(Some("scala"))
} catch {
	case t: Throwable => println("exceção ao tentar buscar fotos")
}


// Segunda opção
try {
	buscaFotos(Some("scala"))
} catch {
	case e: IOException => println("exceção de IO ao tentar buscar fotos")
	case e: Exception => println("exceção indefinida ao tentar buscar fotos")
	case NonFatal(t) => println("alguma outra exceção segura")
}


// Criando uma Classe
class IntDobrado(val x: Int) extends AnyVal {
	def dobrado: Int = x * 2
}

val dobro = new IntDobrado(10).dobrado
println(dobro)


// Outra forma de fazer
val dobro = IntDobrado.dobrado(10)
println(dobro)
