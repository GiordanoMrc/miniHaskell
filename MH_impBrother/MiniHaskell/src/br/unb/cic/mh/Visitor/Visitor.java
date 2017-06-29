package br.unb.cic.mh.Visitor;


import br.unb.cic.mh.expressoes.*;
import br.unb.cic.mh.expressoes.expressoesLogicas.*;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.*;
import br.unb.cic.mh.expressoes.expressoesListas.*;
import br.unb.cic.mh.valores.*;

public interface Visitor {
	public void visitar(ExpressaoAnd expressaoAnd);
	public void visitar(ExpressaoLet exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(ExpressaoRefId exp);
	public void visitar(ExpressaoAplicacao exp);
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoDiferenca expressaoDiferenca);
	public void visitar(ExpressaoDivisao expressaoDivisao);
	public void visitar(ExpressaoIfThenElse expressaoIfThenElse);
	public void visitar(ExpressaoIgual expressaoIgual);
	public void visitar(ExpressaoMaior expressaoMaior);
	public void visitar(ExpressaoMaiorIgual expressaoMaiorIgual);
	public void visitar(ExpressaoMenorIgual expressaoMenorIgual);
	public void visitar(ExpressaoMenor expressaoMenor);
	public void visitar(ExpressaoMultiplicacao expressaoMultiplicacao);
	public void visitar(ExpressaoNot expressaoNot);
	public void visitar(ExpressaoOr expressaoOr);
	public void visitar(ExpressaoSubtracao expressaoSubtracao);
	public void visitar(Lista<Valor> lista);
	public void visitar(ExpressaoDrop expressaoDrop);
	public void visitar(ExpressaoAdd expressaoAdd);
	public void visitar(ExpressaoTamanho expressaoTamanho);
	public void visitar(ExpressaoBusca expressaoBusca);
	public void visitar(ExpressaoDropIndice expressaoDropIndice);
}
