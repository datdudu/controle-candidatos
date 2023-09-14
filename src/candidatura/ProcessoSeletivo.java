package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String[] candidatosSelecionados = selecaoDeCandidatos();
		
		imprimirSelecionados(candidatosSelecionados);
		
		for(String candidato : candidatosSelecionados) {
			entrandoEmContato(candidato);
		}
	}
	
	static void imprimirSelecionados(String[] candidatosSelecionados) {
		candidatosSelecionados = selecaoDeCandidatos();
		
		System.out.println("Imprimindo a lista de cadidatos: ");
		
		System.out.println("===============================================");
		
		for(String candidato : candidatosSelecionados) {
			if(candidato == null)
				break;
			System.out.println("Candidado " + candidato + " foi selecionado!");
			System.out.println("---------------------------------------------");
		}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			
			if(atendeu) {
				continuarTentando = !continuarTentando;
				System.out.println("Contato Realizado com " + candidato);
			}else {
				tentativasRealizadas++;
			}
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com " + candidato);
		} else {
			System.out.println("Náo conseguimos contato com " + candidato);
		}
		System.out.println("===============================================");
	}
	static boolean atender() {
		return ThreadLocalRandom.current().nextInt(3)==1;
	}
	
	static String[] selecaoDeCandidatos() {
		String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
		String[] candidatosEscolhidos = new String[5];
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		System.out.println("===============================================");
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioCandidato = valorPretendido();
			
			System.out.println("O candidatdo " + candidato + " solicitou " + salarioCandidato);
			if(salarioBase >= salarioCandidato) {
				System.out.println("O candidato " + candidato + " foi selecionado!");
				candidatosEscolhidos[candidatosSelecionados] = candidatos[candidatoAtual];
				candidatosSelecionados++;
			} else {
				System.out.println("O candidato " + candidato + " não foi selecionado!");
			}
			
			candidatoAtual++;
		}
		
		System.out.println("===============================================");
		
		if(candidatosSelecionados < 5)
		{
			System.out.println("Todos candidatos foram analisados");
		} else {
			System.out.println("Número máximo de 5 candidatos foi atingido");
		}
		
		System.out.println("===============================================");
		return candidatosEscolhidos;
	}
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		
		
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contra proposta");
		} else {
			System.out.println("Aguardando demais candidatos");
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
}
