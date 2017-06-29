package br.unb.cic.mh;

import org.junit.Test;

import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoMultiplicacao;
import br.unb.cic.mh.valores.ValorInteiro;

import org.junit.Assert;;

public class TesteExpressaoMultiplicacao {
	
	@Test
	public void testMultiplicacaoSimples(){
		ValorInteiro v4 = new ValorInteiro(4);
		ValorInteiro v2 = new ValorInteiro(2);
		
		ValorInteiro v8 = (ValorInteiro) new ExpressaoMultiplicacao(v4, v2).avaliar();
		
		Assert.assertEquals(new Integer(8), v8.getValor());
	}
	
	@Test
	public void testMultiplicacaoComposta(){
		ValorInteiro v4 = new ValorInteiro(4);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		
		ValorInteiro v8 = (ValorInteiro) new ExpressaoMultiplicacao(v4, v2).avaliar();
		ValorInteiro v24 = (ValorInteiro) new ExpressaoMultiplicacao(v8, v3).avaliar();
		
		Assert.assertEquals(new Integer(24), v24.getValor());
	}

}
