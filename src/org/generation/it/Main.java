package org.generation.it;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int DISTRIBUTORE =2;
		String[] codice = new String[DISTRIBUTORE];
		float[] prezzo = new float[DISTRIBUTORE];
		int[] quantità = new int[DISTRIBUTORE];

		int i, j =0, imputGest; 
		float soldi, resto, indiceProdotto = 0, quantitàProdotto = 0; 
		boolean trovato;
		String daCercare, risposta, codiceInserito, rispostaGest; 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("BENVENUTO, selezionare prodotto ");
		
		do {
			System.out.print("Digitare il codice gestore: "); // eliminare
			codiceInserito = sc.nextLine();
			if (codiceInserito.equals("15237")) {
				System.out.println("Benvenuto gestore");
			} else {
				System.out.println("Codice errato passerai al lato utente");
				break;
			}
		System.out.println("Cosa vuoi fare oggi? ");
		
		int[] numeroMenu = {1, 2, 3, 4, 5, 6, 7};
		String[] nomiMenu = {"modificaSlot", "incasso", "restoMax", "resetSlot", "qtaVenduta", "disabilita", "reset"};
		
		for (j = 0; j < numeroMenu.length; j++)
			System.out.println("" + numeroMenu[j] + " " + nomiMenu[j]);

		do {
		System.out.println("selezionare il numero del menu: ");
		imputGest=sc.nextInt();
		sc.nextLine();
		
		
			
		
		if (imputGest ==1) {
		for (i = 0; i < codice.length; i++) {
			System.out.print("Inserisci il codice da dare al prodotto nella posizione " + i + " : " );
			codice[i] = sc.nextLine();

			System.out.print("Inserisci il prezzo di " + codice[i] + ": ");
			prezzo[i] = sc.nextFloat();

			System.out.print("Inserisci la quantità di " + codice[i] + ": ");
			quantità[i] = sc.nextInt();
			sc.nextLine();
			quantitàProdotto = quantità[i];
		}
		}
		System.out.println("Vuoi tornare al menu?");
		rispostaGest=sc.next();
		} while (rispostaGest.equalsIgnoreCase("si"));
		
		} while (!codiceInserito.equals("15237"));
		do {

			
			daCercare = sc.nextLine();
			trovato = false;
			for (i = 0; i < codice.length; i++) {
				if (codice[i].equalsIgnoreCase(daCercare)) {
					trovato = true;
					System.out.println("Prezzo: " + prezzo[i]);
					indiceProdotto = prezzo[i];

				}
			}
			do {

				System.out.println("Inserire i soldi: ");
				soldi = sc.nextFloat();
				sc.nextLine();
				System.out.println("il denaro inserito è " + soldi);

				if (soldi == indiceProdotto) {
					System.out.println("Esce il prodotto");
					quantitàProdotto--;
				} else if (soldi > indiceProdotto) {
					System.out.println("Esce il prodotto con il resto");
					resto = soldi - indiceProdotto;
					quantitàProdotto--;
					System.out.println("Il resto è " + resto);
				} else if (soldi < indiceProdotto)
					System.out.println("I soldi non sono sufficienti, il prezzo è " + indiceProdotto);

				System.out.println("La quantità di prodotto rimasta è " + quantitàProdotto);

			} while (soldi < indiceProdotto);

			if (!trovato) // trovato==false
				System.out.println("codice non trovato!");
			System.out.println("Vuoi cercare un altro codice (s/n)?: ");
			risposta = sc.nextLine();

		} while (risposta.equalsIgnoreCase("s"));

	}

}
