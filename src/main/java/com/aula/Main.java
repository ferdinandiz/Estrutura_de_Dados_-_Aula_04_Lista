package com.aula;

import com.aula.classe.ListaCircular;
import com.aula.classe.ListaDuplamenteEncadeada;
import com.aula.classe.ListaEncadeadaSimples;

public class Main {
    public static void main(String[] args) {

//////// Execução Lista Encadeada

//        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<>();
//        lista.inserirInicio("D");
//        lista.inserirInicio("B");
//        lista.inserirInicio("A");
//        lista.inserirFim("E");
//        lista.inserirPosicao(1,"C");
//        lista.printLista();
//        System.out.println();
//        lista.removerFim();
//        lista.removerPosicao(2);
//        lista.removerInicio();
//        lista.printLista();
//
//        System.out.println(lista.get(2));

//////// Execução Lista Circular

//        ListaCircular<String> listaCircular = new ListaCircular<>();
//        listaCircular.inserirInicio("B");
//        listaCircular.inserirInicio("A");
//        listaCircular.inserirFim("D");
//
//        listaCircular.inserirPosicao(1,"C");
//        listaCircular.printLista();
//        listaCircular.removerPosicao(1);
//        listaCircular.removerFim();
//        listaCircular.removerInicio();
//        listaCircular.printLista();

//////// Execução Lista Duplamente Encadeada
        ListaDuplamenteEncadeada<String> lde = new ListaDuplamenteEncadeada<>();
        lde.inserirInicio("A");
        lde.inserirFim("C");
        lde.inserirFim("D");
        lde.printListaDupla();
        lde.inserirPosicao(1,"B");
        lde.printListaDupla();
        lde.removerInicio();
        lde.removerFim();
        lde.printListaDupla();
        lde.inserirInicio("S");
        lde.inserirFim("8");
        lde.printListaDupla();
        lde.removerPosicao(2);
        lde.printListaDupla();
        System.out.println("Valor da 2 posição: "+lde.get(1));

    }
}