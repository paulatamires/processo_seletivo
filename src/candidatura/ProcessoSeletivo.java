package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatosSelecionados = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};		
		for(String candidato: candidatosSelecionados) {
			entrandoEmContato(candidato);
		}
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o canditado.");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o canditado com contra proposta.");
        }else{
            System.out.println("Aguardando o resultado dos demais canditados.");
        }
    }

    static void selecaoCandidatos(){

        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Salário do candidato: " + candidato + " R$: " + salarioPretendido + ".");
            if (salarioBase >= salarioPretendido){
                System.out.println("Candidato: " + candidato + " = foi selecionado.");
                candidatosSelecionados++;
            }else{
                System.out.println("Canditado: "+ candidato + " solicitou R$ " + salarioPretendido);
            }
            candidatoAtual++;
        }        
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados() {
		String [] candidatosSelecionados = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};		
		System.out.println("Imprimindo com a ordem de seleção pelo índice");
		for(int x=0; x<candidatosSelecionados.length; x++) {
			System.out.println((x+1)+ "° Candidato é " + candidatosSelecionados [x] );
		}
    }    
	
	static void entrandoEmContato(String candidato) {
		
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");		
	}
    
    static boolean atender() {
		return new Random().nextInt(3)==1;	
	}    
}
