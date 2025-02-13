import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
//        analisarCandidato(1900.00);
//        analisarCandidato(2200.00);
//        analisarCandidato(2000.00);
//        selecaoCandidatos();
//        imprimirSelecionados();

        String [] candidatos= {"Bianca", "Cleiton", "Berta", "Rose", "Clevis"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }


    static void entrandoEmContato( String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else System.out.println("⭐ Contato realizado com sucesso ⭐");

        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("🎉 Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "ª tentativa.\n");
        else
            System.out.println("\n🚩 Não conseguimos contato com " + candidato + ", numero máximo de tentativas: " + tentativasRealizadas + ".\n");
    }

    //Método para simular que alguem atendeu o telefone
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos= {"Bianca", "Cleiton", "Berta", "Rose", "Clevis"};
        //imprimindo selecionados
        for(String candidato : candidatos){
            System.out.println("O candidato selecionado foi: " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos= {"Bianca", "Cleiton", "Berta", "Rose", "Clevis", "Ramos", "Maria", "Carlos", "Zezinho", "Janaina", "Ana"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

//    static void analisarCandidato(double salarioPretendido){
//        double salarioBase = 2000.00;
//        if (salarioBase > salarioPretendido){
//            System.out.println("LIGAR PARA CANDIDATO, O SALARIO PRETENDIDO FOI DE: R$ " + salarioPretendido);
//        } else if(salarioBase == salarioPretendido){
//            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA, O SALARIO PRETENDIDO FOI DE: R$ " + salarioPretendido);
//        } else
//            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS, O SALARIO PRETENDIDO FOI DE: R$ " + salarioPretendido);
//    }
}


