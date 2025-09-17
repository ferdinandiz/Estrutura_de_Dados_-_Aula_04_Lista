package com.aula.nodes;

public class NoDuplo<T> {
    private T dado;
    private NoDuplo<T> ant, prox;

    public NoDuplo(T dado) {
        this.dado = dado;
        prox = null;
        ant = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoDuplo<T> getAnt() {
        return ant;
    }

    public void setAnt(NoDuplo<T> ant) {
        this.ant = ant;
    }

    public NoDuplo<T> getProx() {
        return prox;
    }

    public void setProx(NoDuplo<T> prox) {
        this.prox = prox;
    }
}
