package br.unb.cic.mh.valores;

import br.unb.cic.mh.Visitor.Visitor;

public class Lista<T extends Valor> implements Valor{
	
	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	protected T conteudo;
	protected Lista<T> previous;
	protected Lista<T> next;
	
	public Lista(T valor) {	
		this.conteudo = valor;
		this.setPrevious(null);
		this.setNext(null);
	}
	
	public void inserirLista(T valor){
		if(this.conteudo != null){
			Lista<T> novo = new Lista<T>(valor);
			Lista<T> aux = this;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			novo.setPrevious(aux);
			novo.setNext(null);
			aux.setNext(novo);
		}else{
			this.conteudo = valor;
		}
	}
	
	private void remove(){
		if(this.getPrevious() == null && this.getNext() == null){ // caso seja o unico elemento
			this.conteudo = null;
		}else if(this.getPrevious() == null){ // caso seja o topo da lista 
			this.conteudo = this.getNext().getConteudo();
			if(this.getNext().getNext() != null){
				this.getNext().getNext().setPrevious(this);
			}
			this.setNext(this.getNext().getNext());
		}else if(this.getNext() == null){ // caso seja o final da lista
			this.getPrevious().setNext(null);
			this.setPrevious(null);
		}else{ // caso esteja no meio
			this.getPrevious().setNext(this.getNext());
			this.getNext().setPrevious(this.getPrevious());
		}
	}
	
	public void removeIndice (int indice){
		Lista<T> aux = busca(indice);
		aux.remove();
	}
	
	public int lenght(){
		int i = 0;
		if(this.conteudo != null){
			i=1;
		}
		Lista <T> aux = this;
		while(aux.getNext()!=null){
			aux = aux.getNext();
			i++;
		}
		return i;
	}
	public Lista<T> busca(int indice){
		int i = 0;
		Lista<T> aux = this;
		while(i < indice){
			aux = aux.getNext();
			if(aux == null){
				throw new RuntimeException("Indice " + indice + " está fora dos limites da lista");
			}
			i++;
		}
		return aux;
	}
	
	public Lista<T> getPrevious() {
		return previous;
	}
	public void setPrevious(Lista<T> previous) {
		this.previous = previous;
	}
	public Lista<T> getNext() {
		return next;
	}
	public void setNext(Lista<T> next) {
		this.next = next;
	}
	@Override
	public Tipo tipo() {
		return Tipo.LISTA;
	}
	@Override
	public boolean checarTipo() {
		return true;
	}
	@Override
	public Valor avaliar() {
		return this;
	}
	
	public T getConteudo() {
		return conteudo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void aceitar(Visitor v) {
		v.visitar((Lista<Valor>)this);	
	}
}
