// Programação Funcional

// Definição do método foreach
abstract def foreach(f: (A) => Unit): Unit

// Definindo o método das coleções utilizando o filter
def filter(p: (A) => Boolean): Set[A]

// Criando uma função
def fotosDoJCranky(foto: Foto) = foto.owner == "jcranky"
val p: (Foto) => Boolean = fotosDoJCranky
fotos.filter(fotosDoJCranky)
fotos.filter(p)

// Criando uma função
def sortWith(lt: (A, A) => Boolean): List[A]

// Ordenando uma lista
val numeros = List(1,3,5,2,4)
val ordenada = numeros.sortWith((x, y) => x < y)

// Outra forma de fazer a mesma função acima
def ehMaior(x: Int, y: Int) = x < y
val numeros = List(1,3,5,2,4)
val ordenada = numeros sortWith ehMaior

// Ordenando as fotos por títulos
val fotosOrdenadas = fotos.sortWith((f1, f2) => f1.title < f2.title)
val fotosOrdenadas = fotos.sortWith(_.title < _.title)

// Criando uma função
def fotoJCranky(foto: Foto) = foto.owner == "jcranky"
val fotosDoJCranky = fotos.filter(fotoJCranky)

// Criando uma variável
val fotosDoJCranky = fotos filter fotoJCranky

// Refatorando a função acima
def fotoDe(owner: String, foto: Foto) = foto.owner == owner
val fotosDoJCranky = fotos.filter(fotoDe("jcranky", _))

// Criando funções
def filter(p: (A) => Boolean): List[A]
def find(p: (A) => Boolean): Option[A]

// Criando variáveis
val fotoDoJCrankyOpt = fotos find fotoJCranky
val fotosDoJCranky = fotos.filter(_.owner == "jcranky")
val fotoDoJCranky = fotos.find(_.owner == "jcranky")

// Map

// Criando uma variável
val lis = fotos.map(foto => <li>{foto.title}</li>)

// Criando uma função
def map[B](f: (A) => B): List[B]
def geraLi(foto: Foto): scala.xml.Elem = <li>{foto.title}</li>

// Criando uma variável
val lis = fotos map geraLi

// Criando uma classe
case class Foto(id: String, owner: String, server: Int, title: String, tags: Option[ List[ String ] ])

// Criando variáveis
val tagsText = foto.tags.map(tags => tags.mkString(","))
val tagsText = foto.tags.map(tags => tags.mkString(",")).getOrElse("")

// Criando uma função
def buscaFotos(tag: Option[String]) = {
	val apiKey = "minha-apiKey"
	val method = "flickr.photos.search"
	val tagText = tag.map("&tags=" + _).getOrElse("")
	val url = s"http://api.flickr.com/services/rest/?method=$method&api_key=$apiKey$tagText"
	Source.fromURL(url).getLines.foreach(println)
}


// Coleções Aninhadas


// Criando uma função
def buscaFotos(tag: Option[String]): List[Foto]

// Criando uma lista
val tags = List("scala", "java", "typesafe")

// Buscando os valores da tag
val fotos = tags.map(tag => buscaFotos(Some(tag)))

val fotosCompactadas = tags.flatMap(tag => buscaFotos(Some(tag)))


// Fold e Reduce

// Criando uma lista de números e na segunda variável somando
val numeros = List(1,2,3,4,5)
val soma = numeros.reduceLeft((acumulado, x) => acumulado + x)

// Aqui seria a assinatura simplificada
def reduceLeft(f: (A, A) => A): A

// Somando a mesma lista acima
val somaPronta = List(1, 2, 3, 4, 5).sum

// Criando uma classe
case class Foto(id: String, owner: String, server: Int, title: String, tags: Option[ List[ String ] ])

val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky", Some(List("livro", "scala")))
val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky", Some(List("scala", "jcranky")))
val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky", Some(List("livro", "jcranky")))

// Criando uma lista com as fotos
val fotos = List(foto1, foto2, foto3)

// Definindo uma estrutura
val tags = fotos.foldLeft(Set.empty[String])((tags, foto) => foto.tags.map(tags ++ _).getOrElse(tags))
