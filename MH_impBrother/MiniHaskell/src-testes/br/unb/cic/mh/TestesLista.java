package br.unb.cic.mh;

import org.junit.*;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSoma;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoAdd;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoBusca;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoDrop;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoDropIndice;
import br.unb.cic.mh.expressoes.expressoesListas.ExpressaoTamanho;
import br.unb.cic.mh.valores.*;

public class TestesLista {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeExpressaoInsere (){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(5));
		
		Assert.assertEquals(1, lista.lenght());
		Assert.assertEquals(new Integer(5), lista.busca(0).getConteudo().getValor());
		
		ExpressaoAdd expressao = new ExpressaoAdd(lista,new ValorInteiro(9));
		lista = (Lista<ValorInteiro>)expressao.avaliar();
		
		Assert.assertEquals(2, lista.lenght());
		Assert.assertEquals(new Integer(9), lista.busca(1).getConteudo().getValor());
		Assert.assertEquals(new Integer(5), lista.busca(0).getConteudo().getValor());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testaExpressaoDrop(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(7));
		lista.inserirLista(new ValorInteiro(4)); // como a expressão add já foi testada, irei usar o insereLista 
		lista.inserirLista(new ValorInteiro(9)); // que deixa o código mais limpo e faz a mesma coisa
		lista.inserirLista(new ValorInteiro(11));
		
		ExpressaoDrop drop = new ExpressaoDrop(lista, new ValorInteiro(2));
		Lista<ValorInteiro> listaDropada = (Lista<ValorInteiro>) drop.avaliar();
		
		Assert.assertEquals(2, listaDropada.lenght());
		Assert.assertEquals(new Integer(9), listaDropada.busca(0).getConteudo().getValor());
		Assert.assertEquals(new Integer(11), listaDropada.busca(1).getConteudo().getValor());
		
		listaDropada.inserirLista(new ValorInteiro(12));
		Lista<ValorInteiro> listaDropada2 = (Lista<ValorInteiro>) new ExpressaoDrop(listaDropada,
				new ValorInteiro(2)).avaliar();
		
		Assert.assertEquals(1, listaDropada2.lenght());
		Assert.assertEquals(new Integer(12), listaDropada2.busca(0).getConteudo().getValor());
		
		listaDropada2 = (Lista<ValorInteiro>) new ExpressaoDrop(listaDropada2,
				new ValorInteiro(1)).avaliar();
		Assert.assertEquals(null, listaDropada2.busca(0).getConteudo());
	}
	
	@Test
	public void testBusca(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.inserirLista(new ValorInteiro(2));
		lista.inserirLista(new ValorInteiro(3));
		
		Assert.assertEquals(new ValorInteiro(1), lista.busca(0).getConteudo());
		Assert.assertEquals(new ValorInteiro(2), lista.busca(1).getConteudo());
		Assert.assertEquals(new ValorInteiro(3), lista.busca(2).getConteudo());
		
	}
	
	@Test
	public void testRemoveNoFinal(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.inserirLista(new ValorInteiro(2));
		lista.inserirLista(new ValorInteiro(3));
		Assert.assertEquals(3, lista.lenght());
		
		lista.removeIndice(2);
		
		Assert.assertEquals(2, lista.lenght());
		Assert.assertEquals(new ValorInteiro(2), lista.busca(1).getConteudo());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveNoMeio(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		
		ExpressaoAdd expressao = new ExpressaoAdd(lista,new ValorInteiro(2));
		lista = (Lista<ValorInteiro>)expressao.avaliar();
		
		expressao = new ExpressaoAdd(lista,new ValorInteiro(3));
		lista = (Lista<ValorInteiro>)expressao.avaliar();
		
		Assert.assertEquals(3, lista.lenght());
		
		lista.removeIndice(1);
		
		Assert.assertEquals(2, lista.lenght());
		Assert.assertEquals(new ValorInteiro(3), lista.busca(1).getConteudo());
	}
	
	@Test
	public void testRemoveNoTopo(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.inserirLista(new ValorInteiro(2));
		lista.inserirLista(new ValorInteiro(3));
		Assert.assertEquals(3, lista.lenght());
		
		lista.removeIndice(0);
		
		Assert.assertEquals(2, lista.lenght());
		Assert.assertEquals(new Integer(2), lista.busca(0).getConteudo().getValor());
		Assert.assertEquals(new Integer(3), lista.busca(1).getConteudo().getValor());
	}
	
	@Test
	public void testRemoveUnico(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.removeIndice(0);
		
		Assert.assertEquals(0, lista.lenght());
		Assert.assertEquals(null, lista.busca(0).getConteudo());
	}
	
	@Test
	public void testExpressaoTamanho(){
		Lista<ValorBooleano> lista = new Lista<ValorBooleano>(new ValorBooleano(true));
		
		lista.inserirLista(new ValorBooleano(false));
		lista.inserirLista(new ValorBooleano(true));
		
		Expressao exp = new ExpressaoTamanho(lista);
		ValorInteiro result = (ValorInteiro) exp.avaliar();
		
		Assert.assertEquals(new Integer(3), result.getValor());
		
		Expressao exp2 = new ExpressaoSoma(exp ,new ValorInteiro(2));
		result = (ValorInteiro) exp2.avaliar();
		
		Assert.assertEquals(new Integer(5), result.getValor());
	}
	
	@Test
	public void testExpressaoBusca (){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.inserirLista(new ValorInteiro(2));
		lista.inserirLista(new ValorInteiro(3));
		
		Expressao exp = new ExpressaoBusca(lista, new ValorInteiro(1));
		ValorInteiro expR = (ValorInteiro) exp.avaliar();
		Assert.assertEquals(new Integer(2), expR.getValor());
		
		exp = new ExpressaoBusca(lista, new ValorInteiro(0));
		expR = (ValorInteiro) exp.avaliar();
		Assert.assertEquals(new Integer(1), expR.getValor());
		
		exp = new ExpressaoBusca(lista, new ValorInteiro(2));
		expR = (ValorInteiro) exp.avaliar();
		Assert.assertEquals(new Integer(3), expR.getValor());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testExpressaoDropByIndice(){
		Lista<ValorInteiro> lista = new Lista<ValorInteiro>(new ValorInteiro(1));
		lista.inserirLista(new ValorInteiro(2));
		lista.inserirLista(new ValorInteiro(3));
		
		ExpressaoDropIndice drop = new ExpressaoDropIndice(lista, new ValorInteiro(1));
		lista = (Lista<ValorInteiro>) drop.avaliar();
		
		Assert.assertEquals(2, lista.lenght());
		Assert.assertEquals(new Integer(1), ((ValorInteiro)lista.busca(0).getConteudo().avaliar()).getValor());
		Assert.assertEquals(new Integer(3), ((ValorInteiro)lista.busca(1).getConteudo().avaliar()).getValor());
		
		drop = new ExpressaoDropIndice(lista, new ValorInteiro(0));
		lista = (Lista<ValorInteiro>) drop.avaliar();
		
		Assert.assertEquals(1, lista.lenght());
		Assert.assertEquals(new Integer(3), ((ValorInteiro)lista.busca(0).getConteudo().avaliar()).getValor());
	}
}
