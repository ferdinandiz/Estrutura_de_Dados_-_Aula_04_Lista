package com.aula;

import com.aula.classe.ListaEncadeadaSimples;

public class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples<String> lista = new ListaEncadeadaSimples<>();
        lista.inserirInicio("D");
        lista.inserirInicio("B");
        lista.inserirInicio("A");
        lista.inserirFim("E");
        lista.inserirPosicao(1,"C");
        lista.printLista();
        System.out.println();
        lista.removerFim();
        lista.removerPosicao(2);
        lista.removerInicio();
        lista.printLista();

        System.out.println(lista.get(2));
    }
}