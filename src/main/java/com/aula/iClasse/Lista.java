package com.aula.iClasse;

public interface Lista<T> {
    void inserirInicio(T item);
    void inserirFim(T item);
    void inserirPosicao(Integer indice, T item);

    T removerFim();
    T removerInicio();
    T removerPosicao(Integer indice);

    T get(Integer indice);
    T primeiro();
    T ultimo();

    Boolean vazia();
    Integer tamanho();
}
