package br.unb.cic.mh.Visitor;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoIfThenElse;
import br.unb.cic.mh.valores.ValorBooleano;

public class Refactoring extends  Adaptador {

	public Expressao res; 
	
	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		res = exp;
		if(exp.getClausulaThen() instanceof ValorBooleano && 
				exp.getClausulaElse() instanceof ValorBooleano) {
			
			boolean ct = ((ValorBooleano)exp.getClausulaThen()).getValor();
			boolean ce = ((ValorBooleano)exp.getClausulaElse()).getValor();
			
			if(ct && !ce) {
				res = exp.getCondicao();
			}
		}
	}
	
	public Expressao getRes() {
		return res;
	}
}
