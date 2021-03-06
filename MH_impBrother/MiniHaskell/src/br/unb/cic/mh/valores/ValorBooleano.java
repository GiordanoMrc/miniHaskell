package br.unb.cic.mh.valores;

import br.unb.cic.mh.Visitor.Visitor;

public class ValorBooleano extends ValorConcreto<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.BOOLEANO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}

	
}
