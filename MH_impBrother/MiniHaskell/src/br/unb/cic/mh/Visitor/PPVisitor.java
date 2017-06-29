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

public class PPVisitor implements Visitor {
	
	String pp = "";
	
	public String getPP() {
		return pp;
	}
	public void reset() {
		pp = "";
	}
	

	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		 {
				pp =pp+ "if(";
				exp.getCondicao().aceitar(this);
				pp =pp+ ")";
				pp =pp+ " then {";
				exp. getClausulaThen().aceitar(this);
				pp =pp+ " } else {";
				exp. getClausulaElse().aceitar(this);
				pp =pp+ "}";
			}

		
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		pp =pp+ "Let (" + exp.getId();
		pp =pp+ " = ";
		exp.getExp().aceitar(this);
		pp =pp+ ") in ";
		exp.getCorpo().aceitar(this);
		
	}

	@Override
	public void visitar(ExpressaoSoma exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" + ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
	}

	@Override
	public void visitar(ExpressaoRefId exp) {
		pp=pp+exp.getId();
		
	}

	@Override
	public void visitar(ExpressaoAplicacao exp) {
		pp=pp+exp.getNome();
		pp=pp+"(";
		for (Expressao e : exp.getParametros()) {
			e.aceitar(this);
			pp=pp+" ";
		}
		pp=pp+")";
		
	}

	@Override
	public void visitar(ValorInteiro exp) {
		pp=pp+exp.getValor();
	}

	@Override
	public void visitar(ValorBooleano exp) {
		pp=pp+exp.getValor();
	}

	@Override
	public void visitar(ExpressaoAnd exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" && ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
	}

	@Override
	public void visitar(ExpressaoDiferenca exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" != ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoDivisao exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+"/";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoIgual exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" == ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
	}

	@Override
	public void visitar(ExpressaoMaior exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" > ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
	}

	@Override
	public void visitar(ExpressaoMaiorIgual exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" >= ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoMenorIgual exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" <= ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoMenor exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" < ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoMultiplicacao exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" * ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		pp=pp+"!(";
		exp.getSub1().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoOr exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" || ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(ExpressaoSubtracao exp) {
		pp=pp+"(";
		exp.getSub1().aceitar(this);
		pp=pp+" - ";
		exp.getSub2().aceitar(this);
		pp=pp+")";
		
		
	}

	@Override
	public void visitar(Lista<Valor> lista) {
		pp = pp + "[";
		Lista<Valor> aux = lista;
		if (aux != null && aux.getConteudo() != null){
			aux.getConteudo().aceitar(this);
			aux = aux.getNext();
			while(aux != null){
				pp = pp + ",";
				aux.getConteudo().aceitar(this);
				aux = aux.getNext();
			}
		}
		pp = pp + "]";
	}

	@Override
	public void visitar(ExpressaoDrop expressaoDrop) {
		pp = pp + "drop ";
		expressaoDrop.getSub2().aceitar(this);
		pp = pp + " ";
		expressaoDrop.getSub1().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoAdd expressaoAdd) {
		expressaoAdd.getSub1().aceitar(this);
		pp = pp + " ++ ";
		expressaoAdd.getSub2().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoTamanho expressaoTamanho) {
		pp = pp + "length ";
		expressaoTamanho.getSub1().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoBusca expressaoBusca) {
		expressaoBusca.getSub1().aceitar(this);
		pp = pp + " !! ";
		expressaoBusca.getSub2().aceitar(this);
		
	}
	@Override
	public void visitar(ExpressaoDropIndice expressaoDropIndice) {
		pp = pp + "drop at ";
		expressaoDropIndice.getSub2().aceitar(this);
		pp = pp + " ";
		expressaoDropIndice.getSub1().aceitar(this);
		
	}

}
