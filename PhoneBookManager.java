package com.uttara.PhoneBook;

import java.util.Scanner;
import java.util.List;

public class PhoneBookManager {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int ch1 = 0;
		String phBook, name;
		String phone;
		PhoneBookModel model = new PhoneBookModel();
		while (ch1 != 5) {
			System.out.println("=== Main Menu ===");
			System.out.println("Press 1 to create Phone Book");
			System.out.println("Press 2 to load Phone Book");
			System.out.println("Press 3 to search Phone Books");
			System.out.println("Press 4 to list Phone Books");
			System.out.println("Press 5 to exit");
			System.out.println("");

			while (!sc1.hasNextInt()) {
				System.out.println("Enter only int inputs");
				sc1.next();
			}
			ch1 = sc1.nextInt();
			System.out.println("choice = " + ch1);

			switch (ch1) {
			case 1:
				System.out.println("creating phone book...");
				System.out.println("Enter name of phone book");
				phBook = sc2.next();
				while (!PhoneBookUtil.validName(phBook)) {
					System.out.println("Enter valid name (only alphabets)");
					phBook = sc2.next();
				}
				String result = PhoneBookUtil.validateName(phBook);

				while (!result.equals(Constants.SUCCESS)) {
					System.out.println("Enter the string as a name...");
					phBook = sc2.next();
					result = PhoneBookUtil.validateName(phBook);
				}
				int ch2 = 0;
				while (ch2 != 6) {
					System.out.println("");
					System.out.println("Press 1 to add contact");
					System.out.println("Press 2 to list contacts");
					System.out.println("Press 3 to edit contact");
					System.out.println("Press 4 to remove contact");
					System.out.println("Press 5 to search contact name");
					System.out.println("Press 6 to go back to main menu");
					System.out.println("");
					while (!sc1.hasNextInt()) {
						System.out.println("Enter only int inputs");
						sc1.next();
					}
					ch2 = sc1.nextInt();
					System.out.println("choice = " + ch2);

					switch (ch2) {
					case 1:
						System.out.println("");
						System.out.println("adding contact...");
						System.out.println("Enter name of the contact");
						name = sc1.next();
						while (!PhoneBookUtil.validName(name)) {
							System.out.println("Enter valid name (only alphabets)");
							name = sc1.next();
						}
						System.out.println("Enter phone num of contact " + name);
						phone = sc1.next();
						while (!PhoneBookUtil.validPhoneNumber(phone)) {
							System.out.println("Enter valid phone number (start with 6789 and only 10 numbers)");
							phone = sc1.next();
						}

						ContactBean bean = new ContactBean(name, phone);
						result = model.addContact(bean, phBook);
						System.out.println("Result of addContact = " + result);

						if (result.equals(Constants.SUCCESS)) {
							System.out.println("Contact name: " + name + " & Phone Number: +91-" + phone
									+ " added successfully to the phone book: " + phBook);
						} else {
							System.out.println("oops some problem in adding..." + result);
						}

						break;

					case 2:
						System.out.println("");
						List<ContactBean> contacts = model.listContacts(phBook);
						if (contacts == null) {
							System.out.println("no listing");
						} else {
							for (ContactBean cb : contacts) {
								System.out.println("Name : " + cb.getName() + " Phone : " + cb.getPhoneNum());
							}
						}
						break;

					case 3:
						System.out.println("Enter the name of the contact that you want to replace");
						String replacedName = sc2.next();
						System.out.println("Enter the updated name");
						String newContact = sc2.next();
						model.updateContact(phBook, newContact, replacedName);

						break;
					case 4:
						System.out.println("Which contact do you wish to remove?");
						String removedContact = sc2.next();
						model.removeContacts(phBook, removedContact);
						break;
					case 5:
						System.out.println("Enter name to search");
						name = sc2.next();

						if (model.searchContact(phBook, name)) {
							System.out.println(name + " present in " + phBook);
						} else {
							System.out.println(name + " not present in " + phBook);
						}
						break;

					case 6:
						System.out.println("Back to Main Menu...");
						System.out.println("");
						break;

					default:
						System.out.println("Press 1-6 numbers");
						break;
					}
				}
				break;

			case 2:
				System.out.println("Enter Name to load the Phone Book ");
				phBook = sc2.next();

				if (model.listPhoneBook().contains(phBook)) {
					int ch3 = 0;
					while (ch3 != 6) {
						System.out.println("");
						System.out.println("Press 1 to add contact");
						System.out.println("Press 2 to list contacts");
						System.out.println("Press 3 to edit contact");
						System.out.println("Press 4 to remove contact");
						System.out.println("Press 5 to search contact name");
						System.out.println("Press 6 to go back to main menu");
						System.out.println("");
						while (!sc1.hasNextInt()) {
							System.out.println("Enter only int inputs");
							sc1.next();
						}
						ch3 = sc1.nextInt();
						System.out.println("choice = " + ch3);

						switch (ch3) {
						case 1:
							System.out.println("");
							System.out.println("adding contact...");
							System.out.println("Enter name of contact");
							name = sc2.next();
							while (!PhoneBookUtil.validName(name)) {
								System.out.println("Enter valid name (only alphabets)");
								name = sc1.next();
							}

							System.out.println("Enter phone num of contact " + name);
							phone = sc2.next();
							while (!PhoneBookUtil.validPhoneNumber(phone)) {
								System.out.println("Enter valid phone number (start with 6789 and only 10 numbers)");
								phone = sc1.next();
							}
							ContactBean bean = new ContactBean(name, phone);
							result = model.addContact(bean, phBook);
							System.out.println("Result of addContact = " + result);
							if (result.equals(Constants.SUCCESS)) {
								System.out.println("Contact name = " + name + " & Ph Number = +91-" + phone
										+ " has been added successfully to phone book: " + phBook);
							} else {
								System.out.println("oops some problem in adding..." + result);
							}
							break;
						case 2:
							System.out.println("");
							List<ContactBean> contacts = model.listContacts(phBook);

							if (contacts == null) {
								System.out.println("problem occuring during listing");
							} else {
								for (ContactBean cb : contacts) {
									System.out.println("Name : " + cb.getName() + " Phone : " + cb.getPhoneNum());
								}
							}
							break;
						case 3:
							System.out.println("Enter the name of the contact that you want to replace");
							String replacedName = sc2.next();
							System.out.println("Enter the updated name");
							String newContact = sc2.next();
							model.updateContact(phBook, newContact, replacedName);

							break;
						case 4:
							System.out.println("Which contact do you wish to remove?");
							String removedContact = sc2.next();
							model.removeContacts(phBook, removedContact);
							break;

						case 5:
							System.out.println("Enter name to search");
							name = sc2.next();
							if (model.searchContact(phBook, name)) {
								System.out.println(name + " present in " + phBook);
							} else {
								System.out.println(name + " not present in " + phBook);
							}
							break;

						case 6:
							System.out.println("Back to Main Menu...");
							System.out.println("");
							break;
						default:
							System.out.println("invalid number");
							break;
						}
					}
				}
				break;

			case 3:
				System.out.println("searching phone book...");
				System.out.println("Enter name to search");
				name = sc2.next();
				if (model.searchPhoneBook(name)) {
					System.out.println("Phone Book: " + name + " Exists");
				} else {
					System.out.println(name + " does not Exists");
				}
				System.out.println("");
				break;
			case 4:
				System.out.println("listing phone books...");
				System.out.println("");
				List<String> list = model.listPhoneBook();
				for (String s : list) {
					System.out.println(s + ".txt");
				}
				System.out.println("");
				break;
			case 5:
				System.out.println("Exited");
				break;
			default:
				System.out.println("give only 1-5 inputs");
				break;

			}

		}

	}

}
