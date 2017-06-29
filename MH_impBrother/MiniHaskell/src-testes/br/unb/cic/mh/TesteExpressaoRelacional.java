package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoDiferenca;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMaior;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMaiorIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMenor;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMenorIgual;
import br.unb.cic.mh.valores.ValorBooleano;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteExpressaoRelacional {
	
	@Test
	public void testIgualdade(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
		
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoIgual(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoIgual(v1, v2).avaliar();
		
		
		Assert.assertEquals(true,result.getValor()); 
		Assert.assertEquals(false,result2.getValor()); 
		
		
	
	}
	@Test
	public void testDiferenca(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoDiferenca(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoDiferenca(v1, v2).avaliar();
		
		
		Assert.assertEquals(false,result.getValor()); 
		Assert.assertEquals(true,result2.getValor()); 

	
	}
	@Test
	public void testMaior(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
		ValorInteiro v4 = new ValorInteiro(3);
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoMaior(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoMaior(v1, v2).avaliar();
		ValorBooleano result3 = (ValorBooleano)new ExpressaoMaior(v4, v2).avaliar();
		
		
		Assert.assertEquals(false,result.getValor()); 
		Assert.assertEquals(false,result2.getValor()); 
		Assert.assertEquals(true,result3.getValor()); 

	
	}
	@Test
	public void testMaiorIgual(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
		ValorInteiro v4 = new ValorInteiro(3);
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoMaiorIgual(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoMaiorIgual(v1, v2).avaliar();
		ValorBooleano result3 = (ValorBooleano)new ExpressaoMaiorIgual(v4, v2).avaliar();
		
		
		Assert.assertEquals(true,result.getValor()); 
		Assert.assertEquals(false,result2.getValor()); 
		Assert.assertEquals(true,result3.getValor()); 

	}
	@Test
	public void testMenor(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
		ValorInteiro v4 = new ValorInteiro(3);
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoMenor(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoMenor(v1, v2).avaliar();
		ValorBooleano result3 = (ValorBooleano)new ExpressaoMenor(v4, v2).avaliar();
		
		
		Assert.assertEquals(false,result.getValor()); 
		Assert.assertEquals(true,result2.getValor()); 
		Assert.assertEquals(false,result3.getValor()); 

	
	}
	@Test
	public void testMenorIgual(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(1);
		ValorInteiro v4 = new ValorInteiro(3);
	
		
		ValorBooleano result = (ValorBooleano)new ExpressaoMenorIgual(v1, v3).avaliar();
		ValorBooleano result2 = (ValorBooleano)new ExpressaoMenorIgual(v1, v2).avaliar();
		ValorBooleano result3 = (ValorBooleano)new ExpressaoMenorIgual(v4, v2).avaliar();
		
		
		Assert.assertEquals(true,result.getValor()); 
		Assert.assertEquals(true,result2.getValor()); 
		Assert.assertEquals(false,result3.getValor()); 

	}
}