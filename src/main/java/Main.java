/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();

      Scanner scanner = new Scanner(System.in);
      boolean choice = true;
      while (choice) {
        System.out.println("Menu:");
        System.out.println("1. Dodaj nowego studenta");
        System.out.println("2. Wypisz wszystkich studentów");
        System.out.println("3. Wyszukaj studenta");
        System.out.println("4. Wyjście");
        System.out.print("Wybierz opcję: ");

        int choice2 = scanner.nextInt();
        scanner.nextLine();
        switch (choice2) {
          case 1:
            System.out.println("Dodaj nowego studenta:");
            System.out.print("Imię: ");
            String name = scanner.next();
            System.out.print("Nazwisko: ");
            String surname = scanner.next();
            System.out.print("Wiek: ");
            int age = scanner.nextInt();
            System.out.print("Data urodzenia: ");
            String dateofbirth = scanner.next();
            
            scanner.nextLine();
            s.addStudent(new Student(name, surname, age, dateofbirth));
            break;
          case 2:
            System.out.println("Lista studentów:");
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;
          case 3:
            System.out.println("Podaj dane studenta do wyszukania:");
            String searchSurname = scanner.nextLine();
            Student foundStudent = s.findStudentByName(searchSurname);
            if(foundStudent != null){
              System.out.println(foundStudent.ToString()); }
        else { System.out.println("Student o tym nazwisku nie znaleziony"); 
}
            break;
            case 4:
            choice = false;
            break;
          default:
            System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            break;
        }
      }
    } catch (IOException e) {

    }
  }
}