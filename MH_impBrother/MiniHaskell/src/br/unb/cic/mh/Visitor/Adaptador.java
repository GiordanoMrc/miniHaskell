package br.unb.cic.mh.Visitor;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoAplicacao;
import br.unb.cic.mh.expressoes.ExpressaoIfThenElse;
import br.unb.cic.mh.expressoes.ExpressaoLet;
import br.unb.cic.mh.expressoes.ExpressaoRefId;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoDivisao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoMultiplicacao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSoma;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSubtracao;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoAdd;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoBusca;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoDrop;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoDropIndice;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoTamanho;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoAnd;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoDiferenca;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMaior;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMaiorIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMenor;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMenorIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoNot;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoOr;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorBooleano;
import br.unb.cic.mh.valores.ValorInteiro;

public class Adaptador implements Visitor {
	private int contador = 0;
	
	public void reset() {
		contador = 0;
	}
	public int getTotal() {
		return contador;
	}
	

	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		contador =contador+1;
		exp.getCondicao().aceitar(this);
		exp.getClausulaThen().aceitar(this);
		exp.getClausulaElse().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		contador =contador+1;
		exp.getExp().aceitar(this);
		exp.getCorpo().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		contador =contador+1;
		exp.getSub1().aceitar(this);
		exp.getSub2().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoRefId exp) {
		contador =contador+1;
	}

	@Override
	public void visitar(ExpressaoAplicacao exp) {
		contador =contador+1;
		for (Expressao a : exp.getParametros()) {
			a.aceitar(this);
		}
	}

	@Override
	public void visitar(ValorInteiro exp) {
		contador =contador+1;
	}

	@Override
	public void visitar(ValorBooleano exp) {
		contador =contador+1;
	}

	@Override
	public void visitar(ExpressaoAnd expressaoAnd) {
		contador =contador+1;
		expressaoAnd.getSub1().aceitar(this);
		expressaoAnd.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoDiferenca expressaoDiferenca) {
		contador =contador+1;
		expressaoDiferenca.getSub1().aceitar(this);
		expressaoDiferenca.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoDivisao expressaoDivisao) {
		contador =contador+1;
		expressaoDivisao.getSub1().aceitar(this);
		expressaoDivisao.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoIgual expressaoIgual) {
		contador =contador+1;
		expressaoIgual.getSub1().aceitar(this);
		expressaoIgual.getSub2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoMaior expressaoMaior) {
		contador =contador+1;
		expressaoMaior.getSub1().aceitar(this);
		expressaoMaior.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMaiorIgual expressaoMaiorIgual) {
		contador =contador+1;
		expressaoMaiorIgual.getSub1().aceitar(this);
		expressaoMaiorIgual.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMenorIgual expressaoMenorIgual) {
		contador =contador+1;
		expressaoMenorIgual.getSub1().aceitar(this);
		expressaoMenorIgual.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoMenor expressaoMenor) {
		contador =contador+1;
		expressaoMenor.getSub1().aceitar(this);
		expressaoMenor.getSub2().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoMultiplicacao expressaoMultiplicacao) {
		contador =contador+1;
		expressaoMultiplicacao.getSub1().aceitar(this);
		expressaoMultiplicacao.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoNot expressaoNot) {
		contador =contador+1;
		expressaoNot.getSub1().aceitar(this);
		
		
	}

	@Override
	public void visitar(ExpressaoOr expressaoOr) {
		contador =contador+1;
		expressaoOr.getSub1().aceitar(this);
		expressaoOr.getSub2().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoSubtracao expressaoSubtracao) {
		contador =contador+1;
		expressaoSubtracao.getSub1().aceitar(this);
		expressaoSubtracao.getSub2().aceitar(this);
		
	}


	@Override
	public void visitar(ExpressaoDrop expressaoDrop) {
		contador =contador+1;
		expressaoDrop.getSub1().aceitar(this);
		expressaoDrop.getSub2().aceitar(this);
		
	}


	@Override
	public void visitar(Lista<Valor> lista) {
		contador =contador+1;
	}
	
	@Override
	public void visitar(ExpressaoAdd expressaoAdd) {
		contador =contador+1;
		expressaoAdd.getSub1().aceitar(this);
		expressaoAdd.getSub2().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoTamanho expressaoTamanho) {
		contador =contador+1;
		expressaoTamanho.getSub1().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoBusca expressaoBusca) {
		contador =contador+1;
		expressaoBusca.getSub1().aceitar(this);
		expressaoBusca.getSub2().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoDropIndice expressaoDropIndice) {
		contador = contador + 1;
		expressaoDropIndice.getSub1().aceitar(this);
		expressaoDropIndice.getSub2().aceitar(this);
	}
}
