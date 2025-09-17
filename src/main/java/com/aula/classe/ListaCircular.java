package com.aula.classe;

import com.aula.iClasse.Lista;
import com.aula.nodes.No;

import java.util.NoSuchElementException;

public class ListaCircular<T> implements Lista<T> {
    private No<T> inicio;
    private No<T> fim;
    private Integer tamanho;

    public ListaCircular(){
        this.inicio = null;
        this.fim = null;
        tamanho = 0;
    }

    @Override
    public void inserirInicio(T item) {
        No<T> novo = new No<>(item);
        if(vazia()){
            inicio = fim = novo;
            fim.setProx(inicio);
        } else {
            novo.setProx(inicio);
            inicio = novo;
            fim.setProx(inicio);
        }
        tamanho++;
    }

    @Override
    public void inserirFim(T item) {
        No<T> novo = new No<>(item);
        if(vazia()){
            inicio = fim = novo;
            fim.setProx(inicio);
        }
        else {
            novo.setProx(inicio);
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
        if(indice == 0) {
            inserirInicio(item);
        }
        if(indice==tamanho-1) {
            inserirFim(item);
        }
        No<T> anterior = noPosicao(indice);
        No<T> novo =  new No<>(item);
        novo.setProx(anterior.getProx());
        anterior.setProx(novo);
        tamanho++;
    }

    @Override
    public T removerFim() {
        if(vazia()) throw new NoSuchElementException("ERRO: Lista Vazia!");
        T valor = fim.getDado();
        if(tamanho == 1){
            return removerInicio();
        }
        No<T> penultimo = noPosicao(tamanho-2);
        penultimo.setProx(inicio);
        fim = penultimo;
        tamanho--;
        return valor;
    }

    @Override
    public T removerInicio() {
        if(vazia()) throw new NoSuchElementException("ERRO: Lista Vazia!");
        T valor = inicio.getDado();
        if(tamanho == 1){
            inicio = fim = null;
        }
        else{
            inicio = inicio.getProx();
            fim.setProx(inicio);
        }
        tamanho--;
        return valor;
    }

    @Override
    public T removerPosicao(Integer indice) {
        if(vazia()) throw new NoSuchElementException("ERRO: Lista Vazia!");
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Indice inválido: "+indice+"!!");
        }
        if(indice == 0) removerInicio();
        if(indice == tamanho-1) removerFim();
        No<T> anterior = noPosicao(indice-1);
        No<T> alvo = anterior.getProx();
        anterior.setProx(alvo.getProx());
        T valor = alvo.getDado();
        tamanho--;
        return valor;
    }

    @Override
    public T get(Integer indice) {
        if(indice < 0 || indice >= tamanho){
            throw new IndexOutOfBoundsException("Indice inválido: "+indice+"!!");
        }
        return noPosicao(indice).getDado();
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

    private No<T> noPosicao(Integer indice){
        No<T> atual = inicio;
        for(int i =0 ;i<indice;i++){
            atual = atual.getProx();
        }
        return atual;
    }


    public void printLista(){
        if(vazia()){
            System.out.println("** LISTA VAZIA **");
            return;
        }
        No<T> atual = inicio;
        StringBuilder contrutorString = new StringBuilder();
        for (int i = 0; i < tamanho(); i++){
            contrutorString.append(atual.getDado());
            if(atual != fim){
                contrutorString.append(" -> ");
            }
            atual = atual.getProx();
        }
        System.out.println(contrutorString);
    }

}
