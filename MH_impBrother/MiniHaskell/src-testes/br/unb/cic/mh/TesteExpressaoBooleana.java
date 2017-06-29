package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoAnd;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoNot;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoOr;
import br.unb.cic.mh.valores.ValorBooleano;;

public class TesteExpressaoBooleana {
	
	private ValorBooleano vt = new ValorBooleano(true);
	private ValorBooleano vf = new ValorBooleano(false);
	
	@Test
	public void testaAndSimples (){
		ValorBooleano test = (ValorBooleano) new ExpressaoAnd(vt, vf).avaliar();
		Assert.assertEquals(false, test.getValor());
		
		ValorBooleano test2 = (ValorBooleano) new ExpressaoAnd(vt, vt).avaliar();
		Assert.assertEquals(true, test2.getValor());
	}
	
	@Test
	public void testaAndComposto(){
		ExpressaoAnd and1 = new ExpressaoAnd(vt, vf);
		ExpressaoAnd and2 = new ExpressaoAnd(vt, and1);
		ValorBooleano result = (ValorBooleano) and2.avaliar();
		
		Assert.assertEquals(false, result.getValor());
		
		ExpressaoAnd and3 = new ExpressaoAnd(vt, vt);
		ExpressaoAnd and4 = new ExpressaoAnd(vt, and3);
		ValorBooleano result2 = (ValorBooleano) and4.avaliar();
		
		Assert.assertEquals(true, result2.getValor());
	}
	
	@Test
	public void testaOrSimples(){
		ValorBooleano test = (ValorBooleano) new ExpressaoOr(vt, vf).avaliar();
		Assert.assertEquals(true, test.getValor());
		
		ValorBooleano test2 = (ValorBooleano) new ExpressaoOr(vf, vf).avaliar();
		Assert.assertEquals(false, test2.getValor());
	}
	
	@Test
	public void testaOrComposto(){
		ExpressaoOr or = new ExpressaoOr(vt, vf);
		ExpressaoOr or2 = new ExpressaoOr(vf, or);
		
		Assert.assertEquals(true, ((ValorBooleano)or2.avaliar()).getValor());
		
		ExpressaoOr or3 = new ExpressaoOr(vf, vf);
		ExpressaoOr or4 = new ExpressaoOr(vf, or3);
		
		Assert.assertEquals(false, ((ValorBooleano)or4.avaliar()).getValor());
	}
	
	@Test
	public void testaNotSimples(){
		ValorBooleano falso = (ValorBooleano) new ExpressaoNot(vt).avaliar();
		ValorBooleano verdadeiro = (ValorBooleano) new ExpressaoNot(vf).avaliar();
		
		Assert.assertEquals(false, falso.getValor());
		Assert.assertEquals(true, verdadeiro.getValor());
	}
	
	@Test
	public void testaNotComposto(){
		ExpressaoNot not = new ExpressaoNot(vt);
		ValorBooleano result = (ValorBooleano) new ExpressaoNot(not).avaliar();
		
		Assert.assertEquals(true, result.getValor());
	}

}
