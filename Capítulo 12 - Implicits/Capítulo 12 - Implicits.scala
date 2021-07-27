// Capítulo 12 - Implicits

// Conversões Implicítas
"99".toInt


implicit class PrintableFoto(foto: Foto) {
	def print = println(s"printando foto [$foto]...")
}

Foto(1234, "jcranky", 1234, "Foto 1").print


// Conversões Implicítas Ambíguas
implicit def toPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)

implicit def newPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)


"the xml parser" should {
	"turn the xml into the model class" in {
		val fotosXml = <rsp stat="ok">
<photos>
<photo id="123" owner="jcranky" server="6" title="jcrank
y test"></photo>
</photos>
</rsp>
new XMLParser().parse(fotosXml.toString()) must_== Seq(
	Foto(123, "jcranky", 6, "jcranky test"))
	}
}


// Parâmetros Implicítos
def create(displayName: String, urlName: String) = DB.withConnection {
	implicit c => SQL("INSERT INTO category(display_name, url_name) VALUES({displayName}, {urlName})").on(
		'displayName -> displayName, 'urlName -> urlName).executeUpdate()
}


implicit val c: Connection = ??? // só colocar o objeto de conexão
SQL("INSERT INTO category(display_name, url_name) VALUES({displayName}, {urlName})").on(
'displayName -> displayName, 'urlName -> urlName).executeUpdate(
)


def buscaFotosComImplicits(tag: Option[String])(
	implicit parser: ResponseParser): Seq[Foto] = {
	val method = "flickr.photos.search"

	val tagText = tag.map("&tags=" + _).getOrElse("")

	val params = s"?method=$method&per_page=10&api_key=$apiKey$tagText"

	val url = s"https://api.flickr.com/services/rest/$params"

	parser.parse(Source.fromURL(url).mkString)
}


implicit val parser = new XMLParser()

val fotos = buscaFotosComImplicits(None)

fotos foreach println


// Como o SUM Soma Valores "Somáveis"?
def sum[B >: A](implicit num: Numeric[B]): B = foldLeft(num.zero)(num.plus)


class FotoNumeric extends Numeric[Foto] {
	override def plus(fotoX: Foto, fotoY: Foto): Foto = fotoX.copy(title = fotoX.title + fotoY.title)
	override def fromInt(x: Int): Foto = new Foto(x, "unknown", 0, "unknown")
	// demais operações omitidas
}


object Foto {
	implicit object FotoNumeric extends FotoNumeric
}


val fotos = List(
	Foto(123, "jcranky", 1234, "Foto 1"),
	Foto(124, "jcranky", 4321, "Foto 2")
)

println("Somando fotos: " + fotos.sum)


