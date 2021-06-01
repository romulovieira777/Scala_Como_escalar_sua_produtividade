// 1 Introdução a Scala

// Percorrer uma lista de arquivos e apagar todos os que tiverem determinadas extensões

import java.io._

val arquivos = new File(".").listFiles
val extensoesImgs = List(".jpg", ".jpeg", ".gif", ".png")

def ehImagem(nomeArq: String) = extensoesImgs.exists(nomeArq.endsW
ith(_))
arquivos.filter(arq => ehImagem(arq.getName)).foreach(_.delete)


scala> 1 + 2
res0: Int = 3


scala> val texto = "Numero: " + res0
texto: String = Numero: 3


scala -classpath joda-time-2.3.jar:joda-convert-1.6.jar


scala> import org.joda.time._
import org.joda.time._

scala> val hoje = new LocalDate()
hoje: org.joda.time.LocalDate = 2014-07-18


scala> var soma = 1 + 2
soma: Int = 3


scala> var soma: Int = 1 + 2
soma: Int = 3


