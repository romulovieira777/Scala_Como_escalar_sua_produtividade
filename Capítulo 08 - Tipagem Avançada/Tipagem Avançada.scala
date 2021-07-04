// Tipagem Avançada

// Tipos Parametrizados

// Declarando variáveis
val foto1 = new Foto("id1", "jcranky", 1, "uma foto do jcranky")
val foto2 = new Foto("id2", "jcranky", 1, "outra foto do jcranky")
val foto3 = new Foto("id3", "jcranky", 1, "mais uma foto do jcranky")
val fotos = Set(foto1, foto2, foto3)

// Criando uma lista vazia
val listaStringVazia = List.empty[String]


// Limites de Tipos: Type Bounds

// Criando funções
def map[B](f: (A) => B): List[B]
def reduceLeft[B >: A](f: (B, A) => B): B


trait Media {
	val tags: Set[String]
}
case class Foto(id: Int, tags: Set[String]) extends Media
case class Video(id: Int, tags: Set[String]) extends Media

// Criando sets
val fotos = Set(Foto(1, Set("scala", "jcranky")), Foto(2, Set("jvm", "jcranky")))
val videos = Set(Video(1, Set("praia", "ipanema")), Video(2, Set("campo", "ferias")))

// Criando uma função
def acumulaTags(media: Media, outraMedia: Media): Media = new Media { val tags = media.tags ++ outraMedia.tags }

// Declarando duas variáveis
val tagsFotos = fotos.reduceLeft(acumulaTags)
val tagsVideos = videos.reduceLeft(acumulaTags)

// Criando uma função
def reduceLeft[B >: Foto](f: (B, Foto) => B): B

// Criando funções 
def printaFotos(medias: Set[Media]) = medias.foreach(println)
def printaFotos2[T <: Media](medias: Set[T]) = medias.foreach(println)

// Declarando uma variável
val setDeFotos: Set[Foto] = Set(Foto(1, Set.empty))


// Tipos Invariantes, Covariantes e Contravariantes

// Criando um set de fotos
val fotos = Set(Foto("1", "jcranky", 123, "scalax", None))
def printaFotos(fotos: Set[Foto]) = fotos foreach println
printaFotos(fotos)

// Criando uma classe de fotos
class FotoDetalhada(id: Int, owner: String, server: Int, title: String, 
	tags: Set[String], detalhes: String) extends Foto(id, tags)
val fotosDet = Set(new FotoDetalhada(2, "jcranky", 321, "scalax2", Set.empty, "detalhes da foto"))

// Declarando a coleção de fotos
val fotos = List(new Foto(1, Set.empty))
val fotosDetalhadas = List(new FotoDetalhada(2, "jcranky", 321, "scalax2", Set.empty, "detalhes da foto"))

// Definindo o método print
def printFotos(fotos: List[Foto]) = fotos foreach println
printFotos(fotos)
printFotos(fotosDetalhadas)
