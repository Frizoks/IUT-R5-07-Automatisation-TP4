package TP4;

import java.util.Scanner;
import java.util.Stack;

public class Calculette {

	// Pile pour stocker les nombres
	private Stack<Double> pile;

	// Constructeur
	public Calculette() {
		pile = new Stack<>();
	}

	// Méthode pour ajouter un nombre dans la pile
	public void empiler(double nombre) {
		pile.push(nombre);
	}

	// Addition
	public void addition() {
		if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes pour effectuer l'addition");
		double b = pile.pop();
		double a = pile.pop();
		pile.push(a + b);
	}

	// Soustraction
	public void soustraction() {
		if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes pour effectuer la soustraction");
		double b = pile.pop();
		double a = pile.pop();
		pile.push(a - b);
	}

	// Multiplication
	public void multiplication() {
		if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes pour effectuer la multiplication");
		double b = pile.pop();
		double a = pile.pop();
		pile.push(a * b);
	}

	// Division
	public void division() {
		if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes pour effectuer la division");
		double b = pile.pop();
		if (b == 0) throw new ArithmeticException("Division par zéro");
		double a = pile.pop();
		pile.push(a / b);
	}

	// Obtenir le résultat (valeur finale dans la pile)
	public double getResultat() {
		if (pile.size() != 1) throw new IllegalStateException("La pile n'a pas une seule valeur, calcul incomplet");
		return pile.peek();
	}

	// Méthode pour calculer une expression en notation polonaise inverse
	public double calculerRPN(String expression) {
		String[] tokens = expression.split(" ");
		for (String token : tokens) {
			switch (token) {
				case "+":
					addition();
					break;
				case "-":
					soustraction();
					break;
				case "*":
					multiplication();
					break;
				case "/":
					division();
					break;
				default:
					try {
						empiler(Double.parseDouble(token));
					} catch (NumberFormatException e) {
						throw new IllegalArgumentException("Expression non valide : " + token);
					}
					break;
			}
		}
		return getResultat();
	}

	// Méthode main pour exécuter depuis la console
	public static void main(String[] args) {
		Calculette calculette = new Calculette();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Entrez une expression en notation polonaise inverse (NPI) :");
		String expression = scanner.nextLine();

		try {
			double resultat = calculette.calculerRPN(expression);
			System.out.println("Résultat : " + resultat);
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}

		scanner.close();
	}
}
