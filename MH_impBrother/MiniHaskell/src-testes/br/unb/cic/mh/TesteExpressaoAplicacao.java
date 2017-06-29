package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressoes.Expressao;
import br.unb.cic.mh.expressoes.ExpressaoAplicacao;
import br.unb.cic.mh.expressoes.ExpressaoIfThenElse;
import br.unb.cic.mh.expressoes.ExpressaoRefId;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoMultiplicacao;
import br.unb.cic.mh.expressoes.expressoesAritmeticas.ExpressaoSubtracao;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoIgual;
import br.unb.cic.mh.expressoes.expressoesLogicas.ExpressaoMenorIgual;
import br.unb.cic.mh.valores.Tipo;
import br.unb.cic.mh.valores.ValorInteiro;

public class TesteExpressaoAplicacao {

	@Test
	public void testFuncaoAplicacaoBasica (){
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		ArgumentoFormal arg1 = new ArgumentoFormal("X", Tipo.INTEIRO);
		argumentos.add(arg1);
		
		DeclFuncao funcao = new DeclFuncao("dobra", argumentos, new ExpressaoMultiplicacao(new ExpressaoRefId("X"), new ValorInteiro(2)));
		AmbienteExecucao.instance().declararFuncao(funcao);
		
		List<Expressao> valoresArgumentos = new ArrayList<Expressao>();
		valoresArgumentos.add(new ValorInteiro(4));
		
		ExpressaoAplicacao expressao = new ExpressaoAplicacao("dobra", valoresArgumentos);
		
		ValorInteiro resultado = (ValorInteiro) expressao.avaliar();
		
		Assert.assertEquals(new Integer(8), resultado.getValor());
	}
	
	public void testAplicacaoComplexa(){
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		ArgumentoFormal arg1 = new ArgumentoFormal("X", Tipo.INTEIRO);
		argumentos.add(arg1);
		
		Expressao condicao = new ExpressaoMenorIgual(new ExpressaoRefId("X"), new ValorInteiro(2));
		Expressao then = new ExpressaoRefId("X");
		Expressao clausulaElse = new ExpressaoMultiplicacao(new ExpressaoRefId("X"), new ValorInteiro(2));
		
		DeclFuncao funcao = new DeclFuncao("MultiplicaAcimaDeDois", argumentos,
				new ExpressaoIfThenElse(condicao, then, clausulaElse));
		AmbienteExecucao.instance().declararFuncao(funcao);
		
		List<Expressao> valoresArgumentos = new ArrayList<Expressao>();
		valoresArgumentos.add(new ValorInteiro(3));
		
		ExpressaoAplicacao expressao = new ExpressaoAplicacao("MultiplicaAcimaDeDois", valoresArgumentos);
		
		ValorInteiro resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(6), resultado.getValor());
		
		valoresArgumentos.remove(0);
		valoresArgumentos.add(new ValorInteiro(2));
		
		expressao = new ExpressaoAplicacao("MultiplicaAcimaDeDois", valoresArgumentos);
		resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(2), resultado.getValor());
		
		valoresArgumentos.remove(0);
		valoresArgumentos.add(new ValorInteiro(1));
		
		expressao = new ExpressaoAplicacao("MultiplicaAcimaDeDois", valoresArgumentos);
		resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(1), resultado.getValor());
		
	}
	
	public void testFatorial (){
		List<ArgumentoFormal> argumentos = new ArrayList<ArgumentoFormal>();
		ArgumentoFormal arg1 = new ArgumentoFormal("X", Tipo.INTEIRO);
		argumentos.add(arg1);
		
		Expressao condicao = new ExpressaoIgual(new ExpressaoRefId("X"), new ValorInteiro(0));
		Expressao then = new ValorInteiro(1);
		
		List<Expressao> expressoes = new ArrayList<Expressao>();
		expressoes.add(new ExpressaoSubtracao(new ExpressaoRefId("X"), new ValorInteiro(1)));
		
		Expressao clausulaElse = new ExpressaoAplicacao("MultiplicaAcimaDeDois", expressoes);
		
		DeclFuncao funcao = new DeclFuncao("Fat", argumentos,
				new ExpressaoIfThenElse(condicao, then, clausulaElse));
		AmbienteExecucao.instance().declararFuncao(funcao);
		
		List<Expressao> valoresArgumentos = new ArrayList<Expressao>();
		valoresArgumentos.add(new ValorInteiro(5));
		
		ExpressaoAplicacao expressao = new ExpressaoAplicacao("Fat", valoresArgumentos);
		
		ValorInteiro resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(120), resultado.getValor());
		
		valoresArgumentos.remove(0);
		valoresArgumentos.add(new ValorInteiro(4));
		
		expressao = new ExpressaoAplicacao("Fat", valoresArgumentos);
		resultado = (ValorInteiro) expressao.avaliar();
		Assert.assertEquals(new Integer(24), resultado.getValor());
		
	}

}
