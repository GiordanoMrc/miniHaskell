package br.unb.cic.mhs

abstract class ValorConcreto[T](val valor : T) extends Valor {
  override def avaliar() : Valor = this
}

class ValorInteiro(valor: Int) extends ValorConcreto[Int](valor)

class ValorBooleano(valor : Boolean) extends ValorConcreto[Boolean](valor)