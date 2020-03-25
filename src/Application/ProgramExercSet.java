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
		
		System.out.println("Um site de internet registra um log de acessos dos usu�rios. Um");
		System.out.println("registro de log consiste no nome de usu�rio (apenas uma palavra) e o");
		System.out.println("instante em que o usu�rio acessou o site no padr�o ISO 8601,");
		System.out.println("separados por espa�o, conforme exemplo. Fazer um programa que leia");
		System.out.println("o log de acessos a partir de um arquivo, e da� informe quantos usu�rios");
		System.out.println("distintos acessaram o site.");
		System.out.println("LINHA ARQUIVO EXEMPLO: amanda 2018-08-26T20:45:08Z");
		System.out.println();
		
		System.out.println("Colocar no diret�rio o arquivo a ser tratado: ");
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
		
		System.out.println("Em um portal de cursos online, cada usu�rio possui um c�digo �nico, representado por");
		System.out.println("um n�mero inteiro. Cada instrutor do portal pode ter v�rios cursos, sendo que um mesmo");
		System.out.println("aluno pode se matricular em quantos cursos quiser. Assim, o n�mero total de alunos de um"); 
		System.out.println("instrutor n�o � simplesmente a soma dos alunos de todos os cursos que ele possui, pois"); 
		System.out.println("pode haver alunos repetidos em mais de um curso.");
		System.out.println("O instrutor Alex possui tr�s cursos A, B e C, e deseja saber seu n�mero total de alunos.");
		System.out.println("Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a");
		System.out.println("quantidade total e alunos dele.");
		System.out.println();
		
		Integer totAluno;
		int i;
		int codigo; 
		
		System.out.print("Entre com o n�mero de alunos do curso A: ");
		totAluno = sc.nextInt();
		
		Set<Integer> setAluno = new HashSet<>();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o c�digo do " + i + "� aluno do curso A: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.print("Entre com o n�mero de alunos do curso B: ");
		totAluno = sc.nextInt();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o c�digo do " + i + "� aluno do curso B: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.print("Entre com o n�mero de alunos do curso C: ");
		totAluno = sc.nextInt();
		
		for(i=1; i <= totAluno; i++) { 
			System.out.print("Entre com o c�digo do " + i + "� aluno do curso C: ");
			codigo = sc.nextInt();
			setAluno.add(codigo);
		}
		
		System.out.println("Total users: " + setAluno.size());
		
		sc.close();
	}

}
