
public class Perguntas {
	String tituloPergunta;	
	String opcao1;
	String opcao2;
	String opcao3;
	String opcao4;
	int indiceOpcaoCerta;
		
	public Perguntas() {

	}
	
	public Perguntas(String tituloPergunta, int indiceOpcaoCerta, String opcao1, String opcao2, String opcao3, String opcao4) {
		this.tituloPergunta = tituloPergunta;
		this.indiceOpcaoCerta = indiceOpcaoCerta;
		this.opcao1 = opcao1;
		this.opcao2 = opcao2;
		this.opcao3 = opcao3;
		this.opcao4 = opcao4;
	}
	
	public void setPergunta(String tituloPergunta, int indiceOpcaoCerta, String opcao1, String opcao2, String opcao3, String opcao4) {
		this.tituloPergunta = tituloPergunta;
		this.indiceOpcaoCerta = indiceOpcaoCerta;
		this.opcao1 = opcao1;
		this.opcao2 = opcao2;
		this.opcao3 = opcao3;
		this.opcao4 = opcao4;
	}
	
	public String toString(){

        return "Pergunta: "+ this.tituloPergunta + " Resposta Certa: " + this.indiceOpcaoCerta;

	}    
	
	public boolean checarOpcaoCorreta(int indiceOpcaoCerta) {		
		if (indiceOpcaoCerta == this.indiceOpcaoCerta) {
			return true;
		}else { 
			return false;
		}
	}
}
