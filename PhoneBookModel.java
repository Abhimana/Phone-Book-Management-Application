package com.uttara.PhoneBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookModel {
	public List<ContactBean> listContacts(String phBook) {
		List<ContactBean> contacts = new ArrayList<ContactBean>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(Constants.PATH + phBook));
			String line;
			while ((line = br.readLine()) != null) {
				String[] sa = line.split(":");
				ContactBean bean = new ContactBean(sa[0], sa[1]);
				contacts.add(bean);
			}

			return contacts;
		} catch (IOException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public String addContact(ContactBean cb, String phBook) {
	//	System.out.println("added Contact " + cb + " phB " + phBook);

		String line = cb.getName() + ":" + cb.getPhoneNum();
		System.out.println("");
		System.out.println("Contact Name : "+cb.getName());
		//+ " & Phone Number : +91-" + cb.getPhoneNum()+" is added Succesfully to Phone Book "+phBook);
		System.out.println("Phone Number : +91-"+cb.getPhoneNum());
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(Constants.PATH + phBook, true));
			bw.write(line);
			bw.newLine();
			return Constants.SUCCESS;
		} catch (IOException e) {
			e.printStackTrace();
			return "Bad thing happened! " + e.getMessage();

		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public String updateContact(String phBook, String newContact, String replacedName) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			List<String> l = new ArrayList<String>();
			br = new BufferedReader(new FileReader(Constants.PATH + phBook));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(replacedName)) {
					String[] s = line.split(":");
					l.add(line.replace(s[0], newContact));
				} else {
					l.add(line);
				}
			}
			bw = new BufferedWriter(new FileWriter(Constants.PATH + phBook, false));
			for (String s : l) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
			System.out.println("Contact Updated successfully");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null && bw != null)
				try {
					br.close();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			else {
				System.out.println("No such contact found to update");
			}
		}
		return newContact;
	}

	public void removeContacts(String phBook, String contact) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String temp = "";

		List<String> l = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(Constants.PATH + phBook));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(contact)) {
					temp = line.replaceAll(line, "");

				} else {
					l.add(line);
				}
			}
			bw = new BufferedWriter(new FileWriter(Constants.PATH + phBook, false));
			for (String s : l) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
			System.out.println("Contact removed successfully");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null && bw != null)
				try {
					br.close();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public boolean searchContact(String phBook, String name) {
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(Constants.PATH + phBook));
			while ((line = br.readLine()) != null) {
				if (line.contains(name)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	public boolean searchPhoneBook(String name) {
		PhoneBookModel model = new PhoneBookModel();
		if (model.listPhoneBook().contains(name)) {
			return true;
		} else
			return false;
	}

	public boolean loadPhoneBook(String name, String phBook) {
		BufferedReader br = null;
		String line;
		File f = new File(name, phBook);
		try {
			br = new BufferedReader(new FileReader(Constants.PATH + phBook));
			while ((line = br.readLine()) != null) {
				if (line.contains(name)) {
					File[] file = f.listFiles();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (br != null)
				try {
					br.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	public List<String> listPhoneBook() {
		String str = Constants.PATH;

		File f = new File(str);
		File[] fa = f.listFiles();
		List<String> list = new ArrayList<String>();
		for (File s : fa) {
			list.add(s.getName());
		}
		return list;

	}

}