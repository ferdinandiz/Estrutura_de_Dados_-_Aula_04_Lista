package com.aula;

import com.aula.classe.ListaCircular;
import com.aula.classe.ListaEncadeadaSimples;

public class Main {
    public static void main(String[] args) {
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
        ListaCircular<String> listaCircular = new ListaCircular<>();
        listaCircular.inserirInicio("B");
        listaCircular.inserirInicio("A");
        listaCircular.inserirFim("D");

        listaCircular.inserirPosicao(1,"C");
        listaCircular.printLista();
        listaCircular.removerPosicao(1);
        listaCircular.removerFim();
        listaCircular.removerInicio();
        listaCircular.printLista();
    }
}