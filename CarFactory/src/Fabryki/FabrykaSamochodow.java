package Fabryki;

import Samochody.Hyundai;
import Samochody.Samochod;
import Samochody.Truck;

import java.awt.*;

public abstract class FabrykaSamochodow<T extends Samochod> {
    private Parking<T> parking;
    public int nadajId;
    String typyNadwozi[] = {"Kombi", "Sedan", "Hatchback"};

    public FabrykaSamochodow(Parking<T> parking) {
        this.parking = parking;
        this.nadajId = 0;
    }

    public void produkuj() {
        T h = UtworzSamochod();
        h.id = nadajId++;

        while (!parking.zaparkuj(h)) {
            MySleep.sleep();
        }

    }

    public Thread uruchomFabryke() {
        Thread tmp = new Thread(() -> {
            while (nadajId != 200) {
                this.produkuj();
                System.out.println("Aktualne id w fabryce " + getClass().getName() + ": " + nadajId);
            }
        });
        tmp.start();
        return tmp;
    }

    public abstract T UtworzSamochod();

}
