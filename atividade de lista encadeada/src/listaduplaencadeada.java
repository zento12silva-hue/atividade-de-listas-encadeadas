class No {
    int valor;
    No anterior;
    No proximo;

    No(int valor) {
        this.valor = valor;
    }
}

class ListaDupla {
    private No inicio;
    private No fim;
    private int tamanho;

    public void inserirNoInicio(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos <= 0) {
            inserirNoInicio(valor);
        } else if (pos >= tamanho) {
            inserirNoFinal(valor);
        } else {
            No novo = new No(valor);
            No atual = inicio;
            for (int i = 0; i < pos; i++) {
                atual = atual.proximo;
            }
            novo.anterior = atual.anterior;
            novo.proximo = atual;
            atual.anterior.proximo = novo;
            atual.anterior = novo;
            tamanho++;
        }
    }

    public void removerNoInicio() {
        if (inicio == null) return;
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
        tamanho--;
    }

    public void removerNoFinal() {
        if (fim == null) return;
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
        tamanho--;
    }

    public void removerNaPosicao(int pos) {
        if (pos < 0 || pos >= tamanho) return;
        if (pos == 0) {
            removerNoInicio();
        } else if (pos == tamanho - 1) {
            removerNoFinal();
        } else {
            No atual = inicio;
            for (int i = 0; i < pos; i++) {
                atual = atual.proximo;
            }
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            tamanho--;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class main {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        lista.inserirNoInicio(10);
        lista.inserirNoFinal(20);
        lista.inserirNoFinal(30);
        lista.inserirNaPosicao(1, 15);

        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());

        lista.removerNoInicio();
        lista.exibir();

        lista.removerNoFinal();
        lista.exibir();

        lista.removerNaPosicao(1);
        lista.exibir();

        System.out.println("Tamanho final: " + lista.tamanho());
    }
}
