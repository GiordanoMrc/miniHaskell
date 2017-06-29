package br.unb.cic.mh.valores;

import br.unb.cic.mh.Visitor.Visitor;

public class ValorInteiro extends ValorConcreto<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
		
	}

//	public boolean equals(Object outro) {
//		if(outro instanceof ValorInteiro) {
//			ValorInteiro inteiro = (ValorInteiro)outro;
//			return inteiro.valor.equals(valor);
//		}
//		return false;
//	}
	
}
