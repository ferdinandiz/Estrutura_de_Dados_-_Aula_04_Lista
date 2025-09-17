package com.aula.classe;

import com.aula.iClasse.Lista;
import com.aula.nodes.No;

import java.util.NoSuchElementException;

public class ListaEncadeadaSimples<T> implements Lista<T> {
    private No<T> inicio;
    private No<T> fim;
    private Integer tamanho;

    public ListaEncadeadaSimples() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void inserirInicio(T item) {
        No<T> novo = new No<>(item);
        novo.setProx(inicio);
        inicio = novo;
        if (fim == null) {
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public void inserirFim(T item) {
        No<T> novo = new No<>(item);
        if(vazia()) {
            inicio = fim = novo;
        } else{
            fim.setProx(novo);
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public void inserirPosicao(Integer indice, T item) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Indice inválido: "+indice+"!!");
        }
        if( indice == 0) {
            inserirInicio(item);
            return;
        }
        if(indice == tamanho-1){
            inserirFim(item);
            return;
        }
        No<T> anterior = noPosicao(indice);
        No<T> novo = new No<>(item);
        novo.setProx(anterior.getProx());
        anterior.setProx(novo);
        tamanho++;

    }

    @Override
    public T removerFim() {
        if(vazia()) throw new NoSuchElementException("Erro: Lista Vazia!");
        if(tamanho == 1){
            return removerInicio();
        }
        No<T> penultimo = noPosicao(tamanho-2);
        T valor = fim.getDado();
        penultimo.setProx(null);
        fim = penultimo;
        tamanho--;
        return valor;
    }

    @Override
    public T removerInicio() {
        if(vazia()) throw new NoSuchElementException("Erro: Lista Vazia!");
        T valor = inicio.getDado();
        inicio = inicio.getProx();
        if(inicio == null) fim = null;
        tamanho--;
        return valor;
    }

    @Override
    public T removerPosicao(Integer indice) {
        if(vazia()) throw new NoSuchElementException("Erro: Lista Vazia!");
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Erro: Índice "+indice+" inválido!");
        if(indice == 0) removerInicio();
        if(indice == tamanho-1) removerFim();

        No<T> anterior = noPosicao(indice-1);
        No<T> aEliminar = anterior.getProx();
        anterior.setProx(aEliminar.getProx());
        tamanho--;
        return aEliminar.getDado();
    }

    @Override
    public T get(Integer indice) {
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Erro: Índice "+indice+" inválido!");
        return noPosicao(indice).getDado();
    }

    @Override
    public T primeiro() {
        if(vazia()) throw new NoSuchElementException("Erro: Lista Vazia!");
        return inicio.getDado();
    }

    @Override
    public T ultimo() {
        if(vazia()) throw new NoSuchElementException("Erro: Lista Vazia!");
        return fim.getDado();
    }

    @Override
    public Boolean vazia() {
        return tamanho==0;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }

    public void printLista(){
        if(vazia()){
            System.out.println("** LISTA VAZIA **");
            return;
        }
        No<T> atual = inicio;
        StringBuilder contrutorString = new StringBuilder();
        while (atual != null){
            contrutorString.append(atual.getDado());
            if(atual.getProx() != null){
                contrutorString.append(" -> ");
            }
            atual = atual.getProx();
        }
        System.out.println(contrutorString);
    }

    private No<T> noPosicao(Integer indice){
        No<T> atual = inicio;
        for (int i=0; i<indice;i++){
            atual = atual.getProx();
        }
        return atual;
    }



}
