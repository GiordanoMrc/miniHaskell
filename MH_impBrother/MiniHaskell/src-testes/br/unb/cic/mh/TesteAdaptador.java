package br.unb.cic.mh;



import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.Visitor.Adaptador;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoLet;
import br.unb.cic.mh.expressoes.ExpressaoRefId;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSoma;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoAdd;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoBusca;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoAnd;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMaiorIgual;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.ValorBooleano;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteAdaptador {//falta realizar os testes das outras funcoes,para confirmar 100% que ela esta rodando

	
	@Test
	public void testAdaptadorSoma() {
		ValorInteiro v = new ValorInteiro(1);
		Expressao s1 = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao s2 = new ExpressaoSoma(s1, v);
		
		Adaptador a = new Adaptador();
		
		v.aceitar(a);
		Assert.assertEquals(1, a.getTotal());
		
		a.reset();
		
		s1.aceitar(a);
		Assert.assertEquals(3, a.getTotal());
		
		a.reset();
		
		s2.aceitar(a);
		Assert.assertEquals(5, a.getTotal());
	}
	@Test
	public void testaAdaptadorAnd(){
		ValorBooleano vt = new ValorBooleano(true);
		ValorBooleano vf = new ValorBooleano(false);
		
		ExpressaoAnd and1 = new ExpressaoAnd(vt, vf);
		ExpressaoAnd and2 = new ExpressaoAnd(vt, and1);
		
		Adaptador a = new Adaptador();
		
		vt.aceitar(a);
		Assert.assertEquals(1, a.getTotal());
		
		a.reset();
		
		and1.aceitar(a);
		Assert.assertEquals(3, a.getTotal());
		
		a.reset();
		
		and2.aceitar(a);
		Assert.assertEquals(5, a.getTotal());
	}
	@Test
	public void testAdaptadorMaiorIgual(){
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		
		ExpressaoMaiorIgual result = new ExpressaoMaiorIgual(v1, v2);
		
		Adaptador a = new Adaptador();
		
		v2.aceitar(a);
		Assert.assertEquals(1, a.getTotal());
		
		a.reset();
		
		result.aceitar(a);
		Assert.assertEquals(3, a.getTotal());
		
		
	}
	@Test
	public void testeAdaptorLet() {
		// let x = 5 in x + x
		ExpressaoLet let1 = new ExpressaoLet("x", new ValorInteiro(5),
				new ExpressaoSoma(new ExpressaoRefId("x"), new ExpressaoRefId("x")));
		Adaptador a = new Adaptador();

		let1.aceitar(a);
		Assert.assertEquals(5, a.getTotal());
	}
	
	@Test
	public void testeAdptadorLista(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(3));
		Adaptador a = new Adaptador();
		ExpressaoBusca busca = new ExpressaoBusca(
				new ExpressaoAdd(lista, new ValorInteiro(2)),
				new ExpressaoSoma(new ValorInteiro(0), new ValorInteiro(1)));
		busca.aceitar(a);
		Assert.assertEquals(7, a.getTotal());
	}
	
	
}
