import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class AppQuiz {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		ler.useDelimiter(System.getProperty("line.separator"));	
		
		int opcao = 0;
		do {
			System.out.println("<<< QUIZ >>>\n");
			System.out.println("1 - Cadastrar Perguntas;");
			System.out.println("2 - Jogar;");		
			System.out.println("3 - Sair;");
			System.out.println("");
			System.out.println("Digite a Opção:");
			opcao = ler.nextInt();
			
			switch (opcao) {
				case 1: {
					System.out.println("<<< Cadastrar Perguntas >>>\n");
		
					System.out.println("Informe o Título da Pergunta:");
					String tituloPergunta = ler.next();
					System.out.println("Informe a Opção 1 de Resposta:");
					String opcaoResposta1 = ler.next();
					System.out.println("Informe a Opção 2 de Resposta:");
					String opcaoResposta2 = ler.next();
					System.out.println("Informe a Opção 3 de Resposta:");
					String opcaoResposta3 = ler.next();
					System.out.println("Informe a Opção 4 de Resposta:");
					String opcaoResposta4 = ler.next();
					System.out.println("Ok, para finalizar, o número ao lado de qual opção corresponde a resposta correta?");
					System.out.println("");
					System.out.println(tituloPergunta);
					System.out.println("");
					System.out.println("1 - " + opcaoResposta1);
					System.out.println("2 - " + opcaoResposta2);
					System.out.println("3 - " + opcaoResposta3);
					System.out.println("4 - " + opcaoResposta4);					
					int indiceOpcaoCerta = ler.nextInt();
						
					try {
						ObjectContainer db = Db4o.openFile("D:/PROJETOS/quiz.yap");
						Perguntas pergunta = new Perguntas(tituloPergunta, indiceOpcaoCerta, opcaoResposta1, opcaoResposta2, opcaoResposta3, opcaoResposta4);			
						db.set(pergunta);						
						db.close();						
						System.out.println("");
						System.out.println("Pergunta cadastrada com Sucesso!!!\n");
					} catch (Exception e) {
						System.out.println("Não foi possível cadastrar essa pergunta, " + e.getMessage());		
					}
									
					
					break;
					}
			
				case 2: {
					
					try {	
					
					System.out.println("<<< QUIZ >>>\n");
					
					ObjectContainer db = Db4o.openFile("D:/PROJETOS/quiz.yap");
					
					ObjectSet<Perguntas> perguntasLista = db.get(Perguntas.class);
					int pontosAcumulados =0;
					int quantidadePerguntas =0;
					
					while (perguntasLista.hasNext()){
						
						Perguntas pergunta = perguntasLista.next();
						
						//System.out.println(perguntasLista.next());
											
						System.out.println(pergunta.tituloPergunta);
						
						System.out.println("1 - " + pergunta.opcao1);
						System.out.println("2 - " + pergunta.opcao2);
						System.out.println("3 - " + pergunta.opcao3);
						System.out.println("4 - " + pergunta.opcao4);	
						System.out.println("");						
						int indiceSelecionada = ler.nextInt();
						
						if (pergunta.checarOpcaoCorreta(indiceSelecionada)){
							System.out.println("Resposta Certa");
							pontosAcumulados++;
							
						}else {
							System.out.println("Resposta Errada, a opção certa correta seria a " + pergunta.indiceOpcaoCerta);
						}	
												
						quantidadePerguntas++;
						
					}
					
					System.out.println("Sua pontuação final foi " + pontosAcumulados + "/" + quantidadePerguntas);
					
					db.close();	
											
					} catch (Exception e) {
						System.out.println("Não foi possível exibir a proxíma Pergunta, " + e.getMessage());		
					}
									
					
					
					break;
				}
				
				default: {
					System.out.println("Opção inválida, escolha umas das Opções acima!!\n");
				}

			}
		
		} while (opcao != 3);

	}

}
