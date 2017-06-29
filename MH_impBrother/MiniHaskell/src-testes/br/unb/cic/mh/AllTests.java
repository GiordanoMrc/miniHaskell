package br.unb.cic.mh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteExpressaoLet.class, TesteExpressaoSoma.class,
	TesteExpressaoSubtracao.class, TesteExpressaoDivisao.class, TesteExpressaoMultiplicacao.class,
	TesteExpressaoBooleana.class,TesteExpressaoRelacional.class, TestesLista.class,
	TesteExpressaoAplicacao.class,TesteAdaptador.class,TestePPVisitor.class})
public class AllTests {

}

