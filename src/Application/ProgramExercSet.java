package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Entities.LogEntry;

public class ProgramExercSet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("===========SET- PROBLEMA A SER SOLUCIONADO===============================");
		System.out.println();
		
		System.out.println("Um site de internet registra um log de acessos dos usuários. Um");
		System.out.println("registro de log consiste no nome de usuário (apenas uma palavra) e o");
		System.out.println("instante em que o usuário acessou o site no padrão ISO 8601,");
		System.out.println("separados por espaço, conforme exemplo. Fazer um programa que leia");
		System.out.println("o log de acessos a partir de um arquivo, e daí informe quantos usuários");
		System.out.println("distintos acessaram o site.");
		System.out.println("LINHA ARQUIVO EXEMPLO: amanda 2018-08-26T20:45:08Z");
		System.out.println();
		
		System.out.println("Colocar no diretório o arquivo a ser tratado: ");
		System.out.print("Entre com caminho do arquivo: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>();
			
			String line = br.readLine();
			while (line != null) {
			
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment));
				
				line = br.readLine();
			}	
			System.out.println("Total users: " + set.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		
		System.out.println();
		System.out.println("===========SET- PROBLEMA PROPOSTO COMO EXERCICIO===============================");
		System.out.println();
		
		System.out.println("Em um portal de cursos online, cada usuário possui um código único, representado por");
		System.out.println("um número inteiro. Cada instrutor do portal pode ter vários cursos, sendo que um mesmo");
		System.out.println("aluno pode se matricular em quantos cursos quiser. Assim, o número total de alunos de um"); 
		System.out.println("instrutor não é simplesmente a soma dos alunos de todos os cursos que ele possui, pois"); 
		System.out.println("pode haver alunos repetidos em mais de um curso.");
		System.out.println("O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.");
		System.out.println("Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a");
		System.out.println("quantidade total e alunos dele.");
		System.out.println();
		
		Integer totAluno;
		int i;
		int codigo; 
		
		System.out.print("Entre com o número de alunos do curso A: ");
		totAluno = sc.nextInt();
		
		Set<Integer> setAluno = new HashSet<>();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o código do " + i + "º aluno do curso A: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.print("Entre com o número de alunos do curso B: ");
		totAluno = sc.nextInt();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o código do " + i + "º aluno do curso B: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.print("Entre com o número de alunos do curso C: ");
		totAluno = sc.nextInt();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o código do " + i + "º aluno do curso C: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.println("Total users: " + setAluno.size());
		
		sc.close();
	}

}
