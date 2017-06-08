package br.unb.cic.mhs

class ExpressaoSoma(lhs : Expressao, rhs : Expressao) extends ExpressaoBinaria(lhs, rhs) {
  /* essa implementacao eh fragil, pois nao verifica os tipos */
  override def avaliar() : Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]
      
    return new ValorInteiro(v1.valor + v2.valor); 
  }
}