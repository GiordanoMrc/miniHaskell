package br.unb.cic.mh;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.cic.mh.expressoes.*;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSoma;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteExpressaoLet {

	@Test
	public void testeExpressaoLetSimples() {
		// let x = 5 in x + x
		ExpressaoLet let1 = new ExpressaoLet("x", new ValorInteiro(5),new ExpressaoSoma(new ExpressaoRefId("x"), new ExpressaoRefId("x")));

		assertEquals(new ValorInteiro(10), let1.avaliar());
	}

	@Test
	public void testeExpressaoLetAninhada() {
		//let x = 5 in x + y
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(5), 
				soma(ref("x"), ref("y")));  
	
		//let y = 10 in let x = 5 in x + y
		ExpressaoLet letExterno = new ExpressaoLet("y", vi(10), letInterno);
		
		
		assertEquals(vi(15), letExterno.avaliar());
	}
	
	@Test 
	public void testeExpressaoLetAninhada2(){
		
		ExpressaoLet letInterno = new ExpressaoLet("x", vi(5), 
				soma(ref("x"), ref("x")));  
	
		//let x = 10 in let x = 5 in x + x
		ExpressaoLet letExterno = new ExpressaoLet("x", vi(10), letInterno);
		
		//Como ja foi avaliado o let de dentro com x=5, a expressão retornada é um ValorInteiro
		//que não possui nenhum x que possa ser re-avaliado.
		assertEquals(vi(10), letExterno.avaliar());
	}
	
	
	public ExpressaoSoma soma(Expressao exp1, Expressao exp2) {
		return new ExpressaoSoma(exp1, exp2);
	}
	
	public ValorInteiro vi(Integer v) {
		return new ValorInteiro(v);
	}
	
	public ExpressaoRefId ref(String id) {
		return new ExpressaoRefId(id);
	}

}
