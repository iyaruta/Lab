package ua.kpi.pti.task2;

public class Symbol {

    private char c;

    public Symbol(char c) {
        this.c = c;
    }

    public char toChar() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (c != symbol.c) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) c;
    }
}
