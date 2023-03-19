import java.util.Scanner; 
import java.util.ArrayList;

public class Capitulo{

    private Personagem perso;
    private int alterarEnergia1;
	private Personagem vilao;
	private int alterarEnergia2;
    private String texto;
    public ArrayList<Escolha> escolhas;
    private Scanner input;

    Capitulo(Personagem perso, 
             int alterarEnergia1, 
             Personagem vilao, 
             int alterarEnergia2, 
             String texto, 
             Scanner input){

        this.perso = perso;
        this.alterarEnergia1 = alterarEnergia1;
		this.vilao = vilao;
        this.alterarEnergia2 = alterarEnergia2;
        this.texto = texto;
        this.escolhas = new ArrayList<Escolha>();
        this.input = input;
    }

    public void mostrar(){
        perso.alterarEnergia(alterarEnergia1);
		vilao.alterarEnergia(alterarEnergia2);
        System.out.println(this.texto);
		
        if (this.escolhas.size() > 0) {
            for(Escolha escolha : escolhas){
                System.out.println(escolha.texto);
            }
			
			int idEscolha = escolher();
			this.escolhas.get(idEscolha).proximo.mostrar();
        }
    }

    private int escolher(){
        int idescolha = -1;
        String receba = input.nextLine();

        for (int i = 0; i < escolhas.size(); i++) {
            if(receba.equals(escolhas.get(i).texto)){
                idescolha = i;
            }
        }
        return idescolha;
    }
}