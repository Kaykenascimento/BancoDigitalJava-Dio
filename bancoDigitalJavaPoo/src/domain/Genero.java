package domain;

public class Genero {

    public static final char MASCULINO = 'M';

    public static final char FEMININO = 'F';

    private Character genero;

    public static String getNomeGenero(char genero) {
        return switch (genero) {
            case MASCULINO -> "Masculino";
            case FEMININO -> "Feminino";
            default -> "Não Cadastrado";
        };
    }

    public Genero() {}

    public Genero(char genero) {
        this.genero = genero;
    }

    public static Genero modificarStringToGenero(String genero) {
        return switch (genero) {
            case "Masculino" -> new Genero(MASCULINO);
            case "Feminino" -> new Genero(FEMININO);
            default -> new Genero();
        };
    }

    public boolean generoMasculino(Character genero) {
        return genero != null && genero == MASCULINO;
    }

    public boolean generoFeminino(Character genero) {
        return  genero != null && genero == FEMININO;
    }

    public boolean isEmpty() {
        return this.genero == null;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
