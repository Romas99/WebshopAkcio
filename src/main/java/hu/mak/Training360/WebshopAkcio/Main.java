package hu.mak.Training360.WebshopAkcio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Termek> bevlista = new ArrayList<>();
        Kosar kosar = new Kosar();

        bevlista.add(new Termek("téliszalámi",12000L,false));
        bevlista.add(new Termek("gumikacsa",3000L,false));
        bevlista.add(new Termek("uborka",2800L,true));
        bevlista.add(new Termek("gesztenye",1000L,true));
        bevlista.add(new Termek("uborka",2800L,true));

        for (Termek aktTermek : bevlista) {
            System.out.println(aktTermek.getNev() + " mennyisége: ");
            try {
                kosar.addItem(aktTermek, sc.nextInt());
                System.out.println(kosar.getItem(kosar.getLastTetelIndex()).toString());
            } catch (IllegalArgumentException ex) {
                System.out.println("Hiba: " + ex.getMessage());
            }
        }

        System.out.println("Max.akció: " + kosar.getKosarAkcio().getAkcioNev());
        System.out.println("Kedvezményes termékek eredeti ára: " + kosar.getKosarEredetiAr());
        System.out.println("Kedvezmény összesen: " + kosar.getKosarKedvezmeny());

        System.out.println("Teszt vége!");

    }
}
