package Samochody;

import java.io.*;

import Fabryki.MySleep;
import Fabryki.Parking;
import Fabryki.ParkingException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Truck {

    public int iloscPodstepnychMiejsc;
    public ArrayList<Samochod> ar;
    private Parking<Volvo> pVolvo;
    private Parking<Skoda> pSkoda;
    private Parking<Hyundai> pHyundai;
    public ArrayList<Samochod> pCelny = new ArrayList<>();


    public Truck(Parking<Volvo> pVolvo, Parking<Skoda> pSkoda, Parking<Hyundai> pHyundai) {
        this.iloscPodstepnychMiejsc = 6;
        this.ar = new ArrayList<Samochod>(); // tutaj sa samochody na ciezarowece
        this.pHyundai = pHyundai;
        this.pSkoda = pSkoda;
        this.pVolvo = pVolvo;
    }

    public boolean isFull() {
        return ar.size() == iloscPodstepnychMiejsc;
    }

    public void przejazd() {

        //miejsce na samochody na ciezarówce 2 z każdego rodzaju
        ArrayList<Volvo> volvo;
        ArrayList<Skoda> skoda;
        ArrayList<Hyundai> hyundai;


        do {
            volvo = pVolvo.zabierzSamochody();
            if(volvo == null) {
                MySleep.sleep();
            }
        } while (volvo == null);

        ar.addAll(volvo);

        System.out.println("Zabrano samochod z fVolvo");


        do {
            skoda = pSkoda.zabierzSamochody();
            if(skoda == null) {
                MySleep.sleep();
            }
        } while (skoda == null);
        ar.addAll(skoda);
        System.out.println("Zabrano samochody z fSkoda");

        do {
            hyundai = pHyundai.zabierzSamochody();
            if(hyundai == null) {
                MySleep.sleep();
            }
        } while (hyundai == null);

        ar.addAll(hyundai);
        System.out.println("Zabrano samochody z fHyundai");

        if (this.isFull()) {
            boolean isUnique = true;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < pCelny.size(); j++) {
                    if (ar.get(i).compareTo(pCelny.get(j)) == 0) {
                        isUnique = false;
                    } else {
                        try {
                            throw new ParkingException();
                        } catch (ParkingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (isUnique)
                    pCelny.add(ar.get(i));
            }
            System.out.println("Teraz parking celny ma rozmiar: " + pCelny.size());
            System.out.println("=========== id na ciezarowce========");
            for (Samochod i : ar) {
                System.out.println(i);
            }

            System.out.println("==================id na parkingu celnym====================");
            for (Samochod i : pCelny) {
                System.out.println(i);
            }
            System.out.println("==========koniec id na parkingu celnym=========");
            System.out.println("Ciezarowka jest pusta a samochody odstawione na parking celny");
            ar.clear();
        }


    }

    public Thread uruchomWatek(int ile) {
        Thread truckThread = new Thread(() -> {
            for (int i = 0; i < ile; i++) {
                przejazd();
            }
        });
        truckThread.start();
        return truckThread;
    }
}
