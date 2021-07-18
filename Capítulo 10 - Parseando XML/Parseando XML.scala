// Parseando XML

// O Básico de XML em Scala

val fotos =
	<fotos>
		<foto>uma foto</foto>
		<foto>outra foto</foto>
</fotos>

(fotos \ "foto").map(_.text)


// Parseando A Resposta Xml do Flickr

// Criando uma função
def buscaFotos(tag: Option[String]): Seq[Foto]

new XMLParser().parse(Source.fromURL(url).mkString)

// Importando Biblioteca
import scala.xml.XML

val xmlResp = XML.loadString(str)

xmlResp \\ "photo" map { p =>
	Foto(
		(p \ "@id" text).toLong,
		p \ "@owner" text,
		(p \ "@server" text).toInt,
		p \ "@title" text)
}

override def parse(str: String): Seq[Foto] = {
	val xmlResp = XML.loadString(str)

xmlResp \\ "photo" map { p => Foto(
		(p \ "@id" text).toLong,
		p \ "@owner" text,
		(p \ "@server" text).toInt,
		p \ "@title" text)
	}
}
