package br.unb.cic.mh.expressoes.expressoesListas;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.Valor;

public class ExpressaoAdd extends ExpressaoBinaria {


	public ExpressaoAdd(Expressao s1, Expressao s2) {
		super(s1, s2);
	}

	@Override
	public Valor avaliar() {
		Lista<Valor> ListaInicial = (Lista<Valor>) sub1.avaliar();
		ListaInicial.inserirLista((Valor) sub2);
		return ListaInicial;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public Tipo tipo() {
		if(sub1.tipo().equals(Tipo.LISTA)){
			return Tipo.LISTA;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.LISTA);
	}

}
