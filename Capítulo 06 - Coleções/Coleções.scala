// Coleções

// Criando uma função
def imprimeFoto(f: Foto) = println(s"Foto: id = ${f.id} owner = ${f.owner}")

val fotos = // coleção qualquer de fotos
fotos.foreach(imprimeFoto)


// Criando uma função
abstract def foreach(f: (A) => Unit): Unit


// Sets

// Declarando variáveis
val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")
val fotos = Set(foto1, foto2, foto3, foto1)

// Imprimindo os valores em tela
fotos.foreach(println)

// Declarando variáveis
val foto4 = new Foto("id4", "jcranky", 1, "ainda mais uma foto dojcranky")
val novasFotos = fotos + foto4

// Declarando variáveis
val fotosIguais = fotos + foto1
fotosIguais == fotos

// Declarando variáveis e removendo um elemento do Set
val menosFotos = fotos - foto1
menosFotos.foreach(println)


// Lists

// Criando uma lista e imprimindo a mesma
val fotos = List(foto1, foto2, foto3, foto1)
fotos.foreach(println)

// Acessando um elemento da lista
println(fotos(1))


// Criando uma função e imprimindo a mesma
def printaLista(lista: List[Foto]): Unit = {
	lista match {
		case head :: Nil =>
			println(head) // ::
		case head :: tail => // ::
			println(head)
			printaLista(tail)
		case Nil =>
	}
}

printaLista(fotos)

// Tuplas

// Declarando uma variável, criando uma Tupla e imprimindo na tela
val dadosFoto = ("jcranky", "reunião dos scaladores")
println(s"owner: ${dadosFoto._1} - title: ${dadosFoto._2}")

// Declarando uma variável, criando uma Tupla e imprimindo na tela
val dadosFoto = (123, "jcranky", "reunião dos scaladores")
println(s"id: ${dadosFoto3._1} - owner: ${dadosFoto3._2} - title: ${dadosFoto3._3}")


// Extraindo dados da Tupla e imprimindo
val dadosFoto4 = (123, "reunião dos scaladores")
val (id, title) = dadosFoto4
println(s"id: $id")
println(s"title: $title")

// Outra forma de acessar os elementos da Tupla
dadosFoto4 match {
	case (id3, title3) => println(s"id: $id3 - title: $title3")
}


// Maps

// Criando uma variável utilizando Map
val services = Map(
	("busca", "flickr.photos.search"),
	("tamanhos", "flickr.photos.getSizes")
)

// Outra forma de declarar a mesma variável
val services2 = Map(
	"busca" -> "flickr.photos.search",
	"tamanhos" -> "flickr.photos.getSizes"
)

println(services == services2)

// Acessando os elementos do Map
val metodoBusca = services("busca")
val metodoBuscaOpt = services.get("busca")

// Tratando uma eventual não existência da chave utilizando um valor padrão
val metodoBusca = services.getOrElse("busca", "método padrão")

val novosServices = services + ("untagged" -> "flickr.photos.getUntagged")

val menosServices = services - "busca"

// Alterando o elemento do Map
val servicesAtualizados = services.updated("busca", "flickr.photos.newSearch")


// Arrays

// Criando variáveis
val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

// Criando uma variável utilizando Array
val fotos = Array(foto1, foto2, foto3, foto1)

// imprimindo na tela o valor
println(fotos(0))


// Coleções

// Coleção imutável
val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")

// Criando um conjunto
val fotos = Set(foto1, foto2, foto3, foto1)

val foto4 = new Foto("id4", "jcranky", 1, "ainda mais uma foto dojcranky")

// Unindo dois conjuntos
val novasFotos = fotos + foto4

// Imprimindo os valores
println(fotos == novasFotos)
