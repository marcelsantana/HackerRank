package com.java.ponteiros;
import java.util.Scanner;

public class Ponteiro {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//New trata de reservar mem�ria o suficiente para o objeto e criar automaticamente uma refer�ncia a ele. 
		Object A = new Object(); 
		A = 1;

		//Aqui o B aponta para o endere�o de mem�ria de A
		Object B = A;
		System.out.printf("The B value is: "+B);	

		A = 2;
		B = A;
		System.out.println("\nNew B value is: "+B);

	}
}
