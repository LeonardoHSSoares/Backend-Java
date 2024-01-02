package praticandoClasses;

public class procedural {

    static Integer qntidadeImpar;
    static Integer i;

    public static void main(String[] args) {

        for (i = 0; i < 50; i++) {

            if (i % 3 == 0) {
                if (3 / i == 0) {
                    qntidadeImpar += i;
                }
            }
        }

        System.out.println(String.format("A quantidade de impares entre 0 e 50 é : %s", qntidadeImpar));
    }
}
