package br.unb.cic.mh;

import java.util.List;

import br.unb.cic.mh.expressoes.Expressao;

/**
 * Classe usada para representar declaracoes de 
 * funcoes. 
 * 
 * @author rbonifacio
 */
public class DeclFuncao {

	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	public DeclFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo; 
	}
	
	public String getNome() {
		return nome;
	}
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	public Expressao getCorpo() {
		return corpo;
	}
}