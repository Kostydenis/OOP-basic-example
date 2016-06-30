package lab2.stuff;

import java.util.Scanner;
import lab2.Cat;
import lab2.Lion;
import lab2.Tiger;
import lab2.Zoo;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import lab2.Animal;
import lab2.Zebra;


/**
 * Необходим рефакторинг кода: для каждого действия - отдельная процедура(с
 * параметрами).
 *
 * @author Костылев Денис АСУб-12-1
 */
public class Console {

    public static void start(Zoo zoo) {

        String com = ""; //инициализация переменной
        System.out.print("Welcome to the zoo");

        do {
            System.out.println();
            System.out.println("What do you want to do? (type \"help\", if you dont know what to do)");
            com = new Scanner(System.in).nextLine();
            switch (com) {
                default: {
                    System.out.println("Incorrect input. Type \"help\" for more information");
                    break;
                }
                case "exit": {
                    System.exit(0);
                    break;
                }
                case "help": {
                    System.out.println("You can add animals by command add\"animal\":");
                    System.out.println("add<name> - add animal");
                    System.out.println("feed/feedall - feed animal(s)");
                    System.out.println("heal/healall - heal animal(s)");
                    System.out.println("kill/killall - kill animal(s)");

                    System.out.println("More information in help file. Open file? (y/n)");
                    if ("y".equals(new Scanner(System.in).nextLine())) {
                        Desktop desktop = null;
                        if (Desktop.isDesktopSupported()) {
                            desktop = Desktop.getDesktop();
                        }
                        try {
                            desktop.open(new File("help.txt"));
                        } catch (IOException e) {
                            System.out.println("File error");
                        }
                    }
                    break;
                }
                case "add": {
                    System.out.println("You can add following animals:");
                    System.out.println("addcat - Cat");
                    System.out.println("addlion - Tiger");
                    System.out.println("addtiger - Lion");
                    System.out.println("addzebra - Zebra");
                    System.out.println("");
                    System.out.println("For more information type \"help\"");
                    break;
                }
                case "showall": {
                    if (zoo.size() != 0) {
                        for (int i = 0; i < zoo.size(); i++) {
                            if (zoo.getAnimal(i).isAlive()) {
                                System.out.println((i + 1) + ": " + zoo.getAnimal(i).getName() + ". HP: "
                                        + zoo.getAnimal(i).getHp() + ". Satiety: " + zoo.getAnimal(i).getSatiety());
                            } else {
                                System.out.println((i + 1) + ": " + zoo.getAnimal(i).getName() + ". HP: "
                                        + zoo.getAnimal(i).getHp() + ". Satiety: " + zoo.getAnimal(i).getSatiety() + " x_x");
                            }
                        }
                    } else {
                        System.out.println("There is no animals in the zoo.");
                    }
                    break;
                }
                case "show": {
                    int an = (new Scanner(System.in).nextInt() - 1);
                    System.out.println((an + 1) + ": " + zoo.getAnimal(an).getName() + ". HP: "
                            + zoo.getAnimal(an).getHp() + ". Satiety: " + zoo.getAnimal(an).getSatiety());
                    break;
                }
                case "addcat": {
                    Cat tmp_cat;
                    System.out.print("Enter name of new cat: ");
                    String inputName = new Scanner(System.in).nextLine();
                    tmp_cat = new Cat(inputName);
                    zoo.addAnimal(tmp_cat);
                    break;
                }
                case "addlion": {
                    Lion tmp_lion;
                    System.out.print("Enter name of new lion: ");
                    String inputName = new Scanner(System.in).nextLine();
                    tmp_lion = new Lion(inputName);
                    zoo.addAnimal(tmp_lion);
                    break;
                }
                case "addtiger": {
                    Tiger tmp_tiger;
                    System.out.print("Enter name of new tiger: ");
                    String inputName = new Scanner(System.in).nextLine();
                    tmp_tiger = new Tiger(inputName);
                    zoo.addAnimal(tmp_tiger);
                    break;
                }
                case "addzebra": {
                    Zebra tmp_zebra;
                    System.out.print("Enter name of new zebra: ");
                    String inputName = new Scanner(System.in).nextLine();
                    tmp_zebra = new Zebra(inputName);
                    zoo.addAnimal(tmp_zebra);
                    break;
                }
                case "makenoise": {
                    for (int i = 0; i < zoo.size(); i++) {
                        System.out.println(zoo.getAnimal(i).getName() + ": " + zoo.getAnimal(i).uniqueSound());
                    }
                    break;
                }
                case "introduce": {
                    for (int i = 0; i < zoo.size(); i++) {
                        System.out.println(zoo.getAnimal(i).getName() + ": " + zoo.getAnimal(i).introduce());
                    }
                    break;
                }
                case "feed": {
                    System.out.println("Choose animal to feed");
                    System.out.println("(you can look for there number by command \"showlist\")");
                    int an = (new Scanner(System.in).nextInt() - 1);

                    zoo.getAnimal(an).feed();

                }
                case "feedall": {
                    for (int i = 0; i < zoo.size(); i++) {
                        zoo.getAnimal(i).feed();
                    }
                    break;
                }
                case "kill": {
                    System.out.println("Choose the animal to kill: ");
                    System.out.println("(you can look for there number by command \"showlist\")");
                    int an = (new Scanner(System.in).nextInt() - 1);

                    zoo.getAnimal(an).die();

                    break;
                }
                case "killall": {
                    for (int i = 0; i < zoo.size(); i++) {
                        if (zoo.getAnimal(i).isAlive()) {
                            zoo.getAnimal(i).die();
                        }
                    }
                    break;
                }
                case "heal": {
                    System.out.println("Choose animal to heal: ");
                    int an = (new Scanner(System.in).nextInt() - 1);
                    zoo.getAnimal(an).heal();
                    System.out.println(zoo.getAnimal(an) + " successfully healed");
                    break;
                }
                case "healall": {
                    for (int i = 0; i < zoo.size(); i++) {
                        if (zoo.getAnimal(i).isAlive()) {
                            zoo.getAnimal(i).heal();
                        }
                    }
                    System.out.println("All animals successfully healed");
                    break;
                }
                case "clean": {
                    int an = (new Scanner(System.in).nextInt() - 1);
                    zoo.removeAnimal(an);
                    break;
                }
                case "cleanall": {
//                    while (zoo.size() != 0) {                        
//                        zoo.removeAnimal(0);
//                    }
                    ArrayList<Animal> mertvlist = new ArrayList<>();
                    for (Iterator it = zoo.getList().iterator(); it.hasNext();) {
                        Animal animal = (Animal) it.next();
                        if (animal.getHp() == 0) {
                            //zoo.removeAnimal(animal);
                            mertvlist.add(animal);
                        }
                    }
                    zoo.getList().removeAll(mertvlist);
                    System.out.println("Cleaned successfully");
//                    System.out.println("All corpse are removed");
                    break;
                }
            }

        } while (true);
    }
}
