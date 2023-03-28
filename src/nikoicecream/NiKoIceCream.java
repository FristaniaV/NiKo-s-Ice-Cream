package nikoicecream;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NiKoIceCream {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();

	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<String> flaList = new ArrayList<>();
	ArrayList<String> IDList = new ArrayList<>();
	ArrayList<Integer> qtyList = new ArrayList<>();
	ArrayList<Integer> totalList = new ArrayList<>();

	String name;
	String fla;
	String ID;
	Integer qty;
	Integer price;
	int subTotal;
	int totalPrice;
	int subTotall;

	public NiKoIceCream() {
		Menu();
	}

	public void Menu() {
		int choose = 0;

		do {
			System.out.println("Niko Ice Cream");
			System.out.println("============");
			System.out.println("1. Add new Ice Cream to Cart");
			System.out.println("2. Checkout Cart");
			System.out.println("3. View Cart");
			System.out.println("4. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scan.nextLine();
			if (choose == 1) {
				Add();
			} else if (choose == 2) {
				Checkout();
			} else if (choose == 3) {
				View();
			} else if (choose == 4) {
				System.exit(0);
			}
		} while (choose > 4 || choose < 1);
	}

	public void Add() {
		String ID = "";

		do {
			System.out.print("Enter the ice's cream name [ 4 - 25 alphabet ]: ");
			name = scan.nextLine();
		} while (name.length() < 4 || name.length() > 25);
		nameList.add(name);

		do {
			System.out.print("Enter the Flavour's name [ Chocolate | Vanilla | Strawberry ] (Case Sensitive): ");
			fla = scan.nextLine();
		} while (!(fla.equals("Chocolate")) && !(fla.equals("Vanilla")) && !(fla.equals("Strawberry")));
		flaList.add(fla);

		do {
			System.out.print("Enter the quantity [>0]: ");
			qty = scan.nextInt();
			scan.nextLine();
		} while (qty <= 0);
		qtyList.add(qty);

		String IdChar = name.substring(0, 2).toUpperCase();
		int randomNumber = rand.nextInt(10);
		int randomNumber2 = rand.nextInt(10);
		ID += IdChar;
		ID += "-";
		ID += (randomNumber + "");
		ID += (randomNumber2 + "");

		System.out.println("Ice Cream ID: " + ID);
		IDList.add(ID);
		System.out.println("Ice Cream Added!");
		System.out.println();
		Menu();
	}

	public void View() {
		for (int i = 0; i < nameList.size() - 1; i++) {
			for (int j = 0; j < nameList.size() - i - 1; j++) {
				if (qtyList.get(j) < qtyList.get(j + 1)) {
					int tempQty = qtyList.get(j);
					qtyList.set(j, qtyList.get(j + 1));
					qtyList.set(j + 1, tempQty);
					String tempName = nameList.get(j);
					nameList.set(j, nameList.get(j + 1));
					nameList.set(j + 1, tempName);
					String tempFla = flaList.get(j);
					flaList.set(j, flaList.get(j + 1));
					flaList.set(j + 1, tempFla);
					String tempID = IDList.get(j);
					IDList.set(j, IDList.get(j + 1));
					IDList.set(j + 1, tempID);
				}
			}
		}
		if (nameList.isEmpty()) {
			System.out.println("No Ice cream added yet...");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			Menu();
		} else {
			System.out.println("====================================================================");
			System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", "ID", "Name", "Flavour", "Quantity");
			System.out.println("====================================================================");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.printf("| %-10s | %-20s | %-10s | %-10d |\n", IDList.get(i), nameList.get(i), flaList.get(i),
						qtyList.get(i));
			}
			System.out.println("====================================================================");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			Menu();
		}
	}

	public void Checkout() {
		if (nameList.isEmpty()) {
			System.out.println("No Ice cream added yet...");
			System.out.println("Press Enter to continue...");
			scan.nextLine();
			Menu();
		} else {

			System.out.println("Invoice");
			System.out.println("===========");
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println("ID: " + IDList.get(i));
				System.out.println("Name: " + nameList.get(i));
				System.out.println("Flavour: " + flaList.get(i));
				System.out.println("Quantity: " + qtyList.get(i));
				if (flaList.get(i).equals("Chocolate")) {
					price = 5;
				} else if (flaList.get(i).equals("Strawberry")) {
					price = 7;
				} else if (flaList.get(i).equals("Vanilla")) {
					price = 10;
				}
				subTotal = qtyList.get(i) * price;
				subTotall += subTotal;
				totalPrice =+ subTotall;
				System.out.println("Subtotal: $" + (subTotal));
				System.out.println("======================================");
			}
			
			System.out.println("Total Price: $" + totalPrice);

		}
	}

	public static void main(String[] args) {
		new NiKoIceCream();

	}

}
