package com.aula.classe;

import com.aula.iClasse.Lista;
import com.aula.nodes.NoDuplo;

import java.util.NoSuchElementException;

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
        if(indice < 0 || indice > tamanho){
            throw new IndexOutOfBoundsException("## ERRO: Indice inválido: "+indice+"!!");
        }
        if(indice == 0){
            inserirInicio(item);
            return;
        }
        if(indice.equals(tamanho)){
            inserirFim(item);
            return;
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
        if(vazia()) throw new NoSuchElementException("## ERRO: Lista Vazia");
        T valor = fim.getDado();
        fim = fim.getAnt();
        if(fim != null){
            fim.setProx(null);
        } else {
            inicio = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public T removerInicio() {
        if(vazia()) throw new NoSuchElementException("## ERRO: Lista Vazia");
        T valor = inicio.getDado();
        inicio = inicio.getProx();
        if(inicio != null){
            inicio.setAnt(null);
        } else {
            fim = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public T removerPosicao(Integer indice) {
        if(vazia()) throw new NoSuchElementException("## ERRO: Lista Vazia");
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("## ERRO: Indice inválido: "+indice+"!!");
        }
        if(indice == 0) return removerInicio();
        if(indice == tamanho-1) return removerFim();
        NoDuplo<T> alvo = noDuploPosicao(indice);
        NoDuplo<T> anterior = alvo.getAnt();
        NoDuplo<T> proximo = alvo.getProx();
        anterior.setProx(proximo);
        proximo.setAnt(anterior);
        tamanho--;

        return alvo.getDado();
    }

    @Override
    public T get(Integer indice) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("## ERRO: Indice inválido: "+indice+"!!");
        }
        return noDuploPosicao(indice).getDado();
    }

    @Override
    public T primeiro() {
        if(vazia()) throw new NoSuchElementException("## ERRO: Lista Vazia");
        return inicio.getDado();
    }

    @Override
    public T ultimo() {
        if(vazia()) throw new NoSuchElementException("## ERRO: Lista Vazia");
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

    public void printListaDupla(){
        if(vazia()){
            System.out.println("** LISTA VAZIA **");
            return;
        }
        StringBuilder sb = new StringBuilder();
        NoDuplo<T> atual = inicio;
        while (atual != null){
            sb.append(atual.getDado());
            if(atual.getProx() != null) sb.append(" <-> ");
            atual = atual.getProx();
        }
        System.out.println(sb.toString());
    }
}
