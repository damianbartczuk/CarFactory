package Fabryki;

import Samochody.Samochod;

import java.util.ArrayList;
import java.util.Arrays;

public class Parking<Samochod>{
    private Object f;
    int iloscMiejsc;

    ArrayList<Samochod> ar;


    public Parking() {
        this.iloscMiejsc = 2;
        this.ar = new ArrayList<Samochod>();
        this.f = new Object();
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public boolean zaparkuj(Samochod s){
        synchronized (f) {
            if (ar.size() < 2) {
                ar.add(s);
                return true;
            }
            return false;
        }
    }


    public ArrayList<Samochod> zabierzSamochody(){
        synchronized (f) {
            if (ar.size() == iloscMiejsc) {
                ArrayList<Samochod> skopiowana = new ArrayList<>(ar);
                ar.clear();
                return skopiowana;
            }
            else
                return null;
        }
    }


}

