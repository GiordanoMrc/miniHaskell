package br.unb.cic.mhs.visitors

import br.unb.cic.mhs.ast.ValorBooleano
import br.unb.cic.mhs.ast.ValorInteiro
import br.unb.cic.mhs.ast.ExpressaoSoma
import br.unb.cic.mhs.ast.ExpressaoITE
import br.unb.cic.mhs.ast.Aplicacao
import br.unb.cic.mhs.ast.ExpressaoLet
import br.unb.cic.mhs.ast.Referencia
import br.unb.cic.mhs.ast.Expressao
import br.unb.cic.mhs.ast.ExpressaoSoma

/**
 * Classe abstrata com a implementacao de um MHSVisitor 
 * para transformacoes que preservam a AST. Classes concretas 
 * desta classe abstrata prcisam redefinir apenas os metodos 
 * de interesse. 
 */
trait TransformacaoG extends MHSVisitor[Expressao] {
  override def visitar(vb : ValorBooleano) : Expressao =  vb
  override def visitar(vi : ValorInteiro)  : Expressao =  vi
  override def visitar(e : ExpressaoSoma)  : Expressao = new ExpressaoSoma(e.lhs.aceitar(this),e.rhs.aceitar(this))
  override def visitar(e : ExpressaoITE)   : Expressao = new ExpressaoITE(e.condicao.aceitar(this), e.clausulaThen.aceitar(this), e.clausulaElse.aceitar(this))
  override def visitar(e : Aplicacao)      : Expressao = new Aplicacao(e.nome, e.args.map(exp => exp.aceitar(this)) : _*)
  override def visitar(e : ExpressaoLet)   : Expressao = new ExpressaoLet(e.id, e.expNomeada.aceitar(this), e.corpo.aceitar(this))
  override def visitar(e : Referencia)     : Expressao = e
}