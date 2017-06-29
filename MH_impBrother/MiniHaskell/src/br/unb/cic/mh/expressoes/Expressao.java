package br.unb.cic.mh.expressoes;

import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.Valor;

public interface Expressao {
	public Tipo tipo(); 
	public boolean checarTipo();
	public Valor avaliar();
	public void aceitar(Visitor v);
}
