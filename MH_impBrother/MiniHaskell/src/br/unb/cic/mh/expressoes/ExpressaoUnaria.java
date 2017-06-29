package br.unb.cic.mh.expressoes;

public abstract class ExpressaoUnaria implements Expressao {
	protected Expressao sub1;

	public ExpressaoUnaria(Expressao s1) {
		this.sub1 = s1;
	}
	public Expressao getSub1() {
		return sub1;
	}
}
