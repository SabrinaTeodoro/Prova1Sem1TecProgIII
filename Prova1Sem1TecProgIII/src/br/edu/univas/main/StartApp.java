package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Aluno;
import vo.Mestrado;
import vo.PosGraduacao;

public class StartApp {
	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList();
		Scanner in = new Scanner(System.in);
		
		int op;
		do {
			op = menu(in);
			switch(op) {
				case 1:{
					cadastroAluno(in, alunos);
					break;
				}
				case 2:{
					listarAlunosPos(in, alunos);
					break;
				}
				case 3:{
					listarAlunosMes(in, alunos);
					break;
				}
			}
		}while(op != 9);
		System.out.println("Até mais!");
		in.close();
	}
	
	public static int menu(Scanner in) {
		
		System.out.println("----MENU----\n"
				+ "[1] Cadastrar aluno\n"
				+ "[2] Listar alunos pós-graduação\n"
				+ "[3] Lista alunos Mestrado\n"
				+ "[9] Sair");
		int op = in.nextInt();
		in.nextLine();
		
		return op;
	}
	public static void cadastroAluno(Scanner in, ArrayList<Aluno> alunos) {
		boolean key = true;
		System.out.println("---CADASTRO---");
		System.out.println("Nome:");
		String nome = in.nextLine();
		System.out.println("CPF:");
		int cpf = in.nextInt();
		in.nextLine();
		System.out.println("Email:");
		String email = in.nextLine();
		//
		for(int i = 0;  i < alunos.size(); i++ ) {
			if(alunos.get(i).getCpf() == cpf) {
				System.out.println("Aluno existente. Não foi possível cadastrá-lo no sistema.");
				key = false;
				break;
			}
		}
		if(key) {
			int op = 0;
			
			do{
				System.out.println("[1] Pós-graduação\n"
						+ "[2] Mestrado");
				op = in.nextInt();
				in.nextLine();
			}while(op > 2 || op < 1);
			Aluno a = null;
			if(op == 1) {
				a = new PosGraduacao(nome, cpf, email);
				System.out.println("criado pos");
				
			}else {
				a = new Mestrado(nome, cpf, email);
				System.out.println("criado mes");
				
			}
			alunos.add(a);
		}
	}
	public static void listarAlunosPos(Scanner in, ArrayList<Aluno> alunos) {
		System.out.println("Listando alunos pos-graduacao");
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getClass().getTypeName().contains("PosGraduacao")){
				System.out.println(alunos.get(i).getNome());
			}
			
		}
		System.out.println("----------------------");
	}
	public static void listarAlunosMes(Scanner in, ArrayList<Aluno> alunos) {
		System.out.println("Listando alunos mestrado");
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getClass().getTypeName().contains("Mestrado")){
				System.out.println(alunos.get(i).getNome());
			}
		}
		System.out.println("----------------------");
	}
}
