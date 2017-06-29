package br.unb.cic.mh.expressoes.expressoesListas;
import br.unb.cic.mh.Visitor.Visitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoBinaria;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.Valor;
import br.unb.cic.mh.valores.ValorConcreto;
import br.unb.cic.mh.valores.ValorInteiro;

 /**
  * 
  * @author Pedro Yan
  * 
  * Expressão que dropa os N primeiros elementos de uma lista
  *
  */
public class ExpressaoDrop extends ExpressaoBinaria{
	
	public ExpressaoDrop(Expressao s1, Expressao n) {
		super(s1, n);
	}

	@Override
	public Valor avaliar() {
		Lista<Valor> ListaInicial = (Lista<Valor>) sub1.avaliar();
		Lista<Valor> ListaFinal;
		ValorInteiro n = (ValorInteiro)sub2;
		if(n.getValor() < ListaInicial.lenght()){
			ListaFinal = (Lista<Valor>) ListaInicial.busca(n.getValor());
			ListaFinal.setPrevious(null);
		}else{
			ListaInicial.setNext(null);
			ListaInicial.setPrevious(null);
			ListaInicial.setConteudo(null);
			ListaFinal = ListaInicial;
		}
		
		return ListaFinal;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public Tipo tipo() {
		if(sub1.tipo().equals(Tipo.LISTA) && sub2.tipo().equals(Tipo.INTEIRO)){
			return Tipo.LISTA;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.LISTA);
	}

}
