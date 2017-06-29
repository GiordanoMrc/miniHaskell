package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoDivisao;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteExpressaoDivisao {
	
	@Test
	public void testDivisaoSimples(){
		ValorInteiro v4 = new ValorInteiro(4);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v3 = new ValorInteiro(3);
		
		ValorInteiro result = (ValorInteiro)new ExpressaoDivisao(v4, v2).avaliar();
		ValorInteiro result2 = (ValorInteiro)new ExpressaoDivisao(v5, v3).avaliar();
		
		Assert.assertEquals(new Integer(2),result.getValor()); //ordem correta
		Assert.assertEquals(new Integer(1),result2.getValor());
	}
	
	@Test
	public void testDivisaoComposta(){
		ValorInteiro v8 = new ValorInteiro(8);
		ValorInteiro v2 = new ValorInteiro(2);
		
		ValorInteiro result = (ValorInteiro)new ExpressaoDivisao(v8, v2).avaliar();
		ValorInteiro result2 = (ValorInteiro)new ExpressaoDivisao(result, v2).avaliar();
		
		Assert.assertEquals(new Integer(2),result2.getValor());
		
	}
}
