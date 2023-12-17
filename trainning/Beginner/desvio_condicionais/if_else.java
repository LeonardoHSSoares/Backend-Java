package trainning.Beginner.desvio_condicionais;

public class if_else {

    public static void main(String[] args){

        String nome = args[0];

        if (nome.equalsIgnoreCase("dev")) {
            System.out.print("\nExecutando em modo Desenvolvedor\n");
        }else if(nome.equalsIgnoreCase("user")){
            System.out.print("\nExecutando modo Usuario\n");
        }else {

            System.out.print("\nBem Vindo "+nome+"\n");
        }
    }
}



