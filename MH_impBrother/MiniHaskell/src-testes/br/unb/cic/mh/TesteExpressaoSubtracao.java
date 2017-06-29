package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSubtracao;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteExpressaoSubtracao {
	
	@Test
	public void testSubtracaoSimples(){
		ValorInteiro v1 = new ValorInteiro(7);
		ValorInteiro v2 = new ValorInteiro(5);
		
		ValorInteiro result1 = (ValorInteiro) new ExpressaoSubtracao(v1, v2).avaliar();
		ValorInteiro result2 = (ValorInteiro) new ExpressaoSubtracao(v2, v1).avaliar();
		
		Assert.assertEquals(new Integer(2),result1.getValor());
		Assert.assertEquals(new Integer(-2),result2.getValor());
	}
	
	@Test
	public void testSubtracaoComplexa() {
		ValorInteiro v9  = new ValorInteiro(9);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v20 = new ValorInteiro(20);
		
		ExpressaoSubtracao result1 = new ExpressaoSubtracao(v10,v9); //1
		ExpressaoSubtracao result2 = new ExpressaoSubtracao(v20,result1);//19
		
		ExpressaoSubtracao result3 = new ExpressaoSubtracao(v9,v10); //-1
		ExpressaoSubtracao result4 = new ExpressaoSubtracao(v20,result3);//21
		
		ValorInteiro res = (ValorInteiro)result2.avaliar();
		ValorInteiro res2 = (ValorInteiro)result4.avaliar();
		
		Assert.assertEquals(new ValorInteiro(19), res);
		Assert.assertEquals(new ValorInteiro(21), res2);
	}

}
