
class No {
    int valor;
    No proximo;

    No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaSimples {
    private No head;
    private int tamanho;

    public ListaSimples() {
        head = null;
        tamanho = 0;
    }

    public void inserirNoInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = head;
        head = novo;
        tamanho++;
    }

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (head == null) {
            head = novo;
        } else {
            No p = head;
            while (p.proximo != null) p = p.proximo;
            p.proximo = novo;
        }
        tamanho++;
    }

    public void inserirNaPosicao(int pos, int valor) {
        if (pos <= 0) {
            inserirNoInicio(valor);
            return;
        }
        if (pos >= tamanho) {
            inserirNoFinal(valor);
            return;
        }
        No novo = new No(valor);
        No p = head;
        for (int i = 0; i < pos - 1; i++) p = p.proximo;
        novo.proximo = p.proximo;
        p.proximo = novo;
        tamanho++;
    }

    public int removerNoInicio() {
        if (head == null) throw new IllegalStateException("Lista vazia");
        int val = head.valor;
        head = head.proximo;
        tamanho--;
        return val;
    }

    public int removerNoFinal() {
        if (head == null) throw new IllegalStateException("Lista vazia");
        if (head.proximo == null) {
            int val = head.valor;
            head = null;
            tamanho--;
            return val;
        }
        No p = head;
        while (p.proximo.proximo != null) p = p.proximo;
        int val = p.proximo.valor;
        p.proximo = null;
        tamanho--;
        return val;
    }

    public int removerNaPosicao(int pos) {
        if (head == null) throw new IllegalStateException("Lista vazia");
        if (pos < 0 || pos >= tamanho) throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        if (pos == 0) return removerNoInicio();
        No p = head;
        for (int i = 0; i < pos - 1; i++) p = p.proximo;
        int val = p.proximo.valor;
        p.proximo = p.proximo.proximo;
        tamanho--;
        return val;
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No p = head;
        while (p != null) {
            sb.append(p.valor);
            if (p.proximo != null) sb.append(" -> ");
            p = p.proximo;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();

        
        lista.inserirNoInicio(10);         
        lista.inserirNoFinal(30);          
        lista.inserirNaPosicao(1, 20);     
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        
        lista.inserirNoInicio(5);          
        lista.inserirNoFinal(40);          
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        
        lista.inserirNaPosicao(10, 50);    
        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println();

        
        System.out.println("Removido do início: " + lista.removerNoInicio());
        lista.exibir();

        System.out.println("Removido do final: " + lista.removerNoFinal());
        lista.exibir();

        System.out.println("Removido da posição 1: " + lista.removerNaPosicao(1));
        lista.exibir();

        System.out.println("Tamanho final: " + lista.tamanho());
    }
}
