// Um pouco de Açúcar: For Comprehensions

// Percorrendo Múltiplas Coleções de Forma Legível

// Declarando duas variáveis
val caller = new FlickrCaller()
val tags = Set("scala", "java", "jvm")

// Criando um loop para pegar as fotos e depois imprimir
tags.foreach { tag =>val fotos = caller.buscaFotos(tag)
fotos foreach println
}

// Excrevendo o mesmo código só que usando agora for comprehensions
for {
	tag <- tags
	foto <- caller.buscaFotos(Some(tag))
} println (foto)


// Mantendo a Imutabilidade
val fotos = tags.flatMap(tag => caller.buscaFotos(tag).map(_.title))
fotos foreach println

// Usando for comprehensions
val fotos = for {
	tag <- tags
	foto <- caller.buscaFotos(tag)
} yield foto.title

fotos foreach println

// Declarando variáveis
val nomesFiltrados = tags.filter(_.startsWith("j")).flatMap(tag => caller.buscaFotos(tag).map(_.title))

nomesFiltrados foreach println

// Usando for comprehensions
val nomesFiltradosFor = for {
	tag <- tags if tag.startsWith("j")
	foto <- caller.buscaFotos(tag)
} yield foto.title

nomesFiltradosFor foreach println


// O Segredo do For: Monads
val tagText = tag.map("&tags=" + _).getOrElse("")

// Usando for comprehensions:
val tagText = for {
	t <- tag
} yield "&tags=" + t

// Declarando variáveis
val userOpt = Option("jcranky")
val passOpt = Option("1234")

// Criando uma função
def autentica(user: String, pass: String): Option[String] = 
	if (user == "jcranky" && pass == "1234") Some("token")
	else None

// Declarando uma variável
val tokenOpt = for {
	user <- userOpt
	pass <- passOpt
	token <- autentica(user, pass)
} yield token
