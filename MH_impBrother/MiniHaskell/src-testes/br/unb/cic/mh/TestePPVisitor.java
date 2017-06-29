package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.Visitor.PPVisitor;
import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoDivisao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoMultiplicacao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSoma;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSubtracao;
import br.unb.cic.mh.expressoes.expressoesListas.*;
import br.unb.cic.mh.valores.Lista;
import br.unb.cic.mh.valores.ValorInteiro;

public class TestePPVisitor {
	@Test
	public void testPPAritimeticas() {
		Expressao v = new ValorInteiro(2);	
		Expressao s1 = new ExpressaoMultiplicacao(new ValorInteiro(4), new ValorInteiro(8));
		Expressao s2 = new ExpressaoSoma(s1, v);
		Expressao s3 = new ExpressaoSubtracao(s2, v);
		Expressao s4 = new ExpressaoDivisao(s3, v);
		
		Lista<ValorInteiro> Lista = new Lista<ValorInteiro>( new ValorInteiro(3));
		Lista.inserirLista(new ValorInteiro(4));
		
		PPVisitor pp = new PPVisitor();
		
		v.aceitar(pp);
		Assert.assertEquals("2", pp.getPP());
		
		pp.reset();
		
		s1.aceitar(pp);
		Assert.assertEquals("(4 * 8)", pp.getPP());
		
		pp.reset();
		
		s2.aceitar(pp);
		Assert.assertEquals("((4 * 8) + 2)", pp.getPP());
		
		pp.reset();
		
		s3.aceitar(pp);
		Assert.assertEquals("(((4 * 8) + 2) - 2)", pp.getPP());
		
		pp.reset();
		
		s4.aceitar(pp);
		Assert.assertEquals("((((4 * 8) + 2) - 2)/2)", pp.getPP());
		
	}
	@Test
	public void testPPcomListas (){
		
		Lista<ValorInteiro> Lista = new Lista<ValorInteiro>( new ValorInteiro(3));
		Lista.inserirLista(new ValorInteiro(4));
		
		PPVisitor pp = new PPVisitor();
		
		pp.reset();
		Lista.aceitar(pp);
		Assert.assertEquals("[3,4]", pp.getPP());
		
		pp.reset();
		Expressao expTamanho = new ExpressaoTamanho(Lista);
		expTamanho.aceitar(pp);
		Assert.assertEquals("length [3,4]", pp.getPP());
		
		pp.reset();
		Expressao expAdd = new ExpressaoAdd(Lista,new ValorInteiro(4));
		expAdd.aceitar(pp);
		Assert.assertEquals("[3,4] ++ 4", pp.getPP());
		
		pp.reset();
		Expressao expDrop = new ExpressaoDrop(Lista,new ValorInteiro(1));
		expDrop.aceitar(pp);
		Assert.assertEquals("drop 1 [3,4]", pp.getPP());
		
		pp.reset();
		Expressao expDropIndice = new ExpressaoDropIndice(Lista,new ValorInteiro(1));
		expDropIndice.aceitar(pp);
		Assert.assertEquals("drop at 1 [3,4]", pp.getPP());
		
		pp.reset();
		Expressao expBusca = new ExpressaoBusca(Lista,new ValorInteiro(1));
		expBusca.aceitar(pp);
		Assert.assertEquals("[3,4] !! 1", pp.getPP());
		
		Lista.removeIndice(0);
		Lista.removeIndice(0);
		
		pp.reset();
		Lista.aceitar(pp);
		Assert.assertEquals("[]",pp.getPP());
	}

}
