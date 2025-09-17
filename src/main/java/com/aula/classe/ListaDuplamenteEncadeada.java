package com.aula.classe;

import com.aula.iClasse.Lista;
import com.aula.nodes.NoDuplo;

public class ListaDuplamenteEncadeada<T> implements Lista<T> {
    private NoDuplo<T> inicio; //cabeça (head)
    private NoDuplo<T> fim; //cauda (tail)
    private Integer tamanho;

    public ListaDuplamenteEncadeada(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void inserirInicio(T item) {
        NoDuplo<T> novo = new NoDuplo<>(item);
        novo.setProx(inicio);
        if(inicio!=null) inicio.setAnt(novo);
        inicio = novo;
        if(fim == null) fim = novo;
        tamanho++;
    }

    @Override
    public void inserirFim(T item) {
        NoDuplo<T> novo = new NoDuplo<>(item);
        if(vazia()){
            inicio = fim = novo;
        } else {
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public void inserirPosicao(Integer indice, T item) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Indice inválido: "+indice+"!!");
        }
        if(indice == 0){
            inserirInicio(item);
        }
        if(indice == tamanho-1){
            inserirFim(item);
        }
        NoDuplo<T> atual = noDuploPosicao(indice);
        NoDuplo<T> anterior = atual.getAnt();
        NoDuplo<T> novo = new NoDuplo<>(item);
        novo.setProx(atual);
        novo.setAnt(anterior);
        anterior.setProx(novo);
        atual.setAnt(novo);
        tamanho++;

    }

    @Override
    public T removerFim() {
        return null;
    }

    @Override
    public T removerInicio() {
        return null;
    }

    @Override
    public T removerPosicao(Integer indice) {
        return null;
    }

    @Override
    public T get(Integer indice) {
        return null;
    }

    @Override
    public T primeiro() {
        return inicio.getDado();
    }

    @Override
    public T ultimo() {
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

    private NoDuplo<T> noDuploPosicao(Integer indice){
        if(indice < (tamanho /2)){
            NoDuplo<T> atual = inicio;
            for (int i=0;i<indice;i++)
                atual = atual.getProx();
            return atual;
        }else{
            NoDuplo<T> atual = fim;
            for(int i = tamanho -1;i>indice;i--)
                atual = atual.getAnt();
            return atual;
        }
    }
}
