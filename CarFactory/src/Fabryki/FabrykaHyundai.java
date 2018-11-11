package Fabryki;
import java.awt.*;
import Samochody.*;

public class FabrykaHyundai extends FabrykaSamochodow<Hyundai> {

    public FabrykaHyundai(Parking<Hyundai> parking) {
        super(parking);
    }

    @Override
    public Hyundai UtworzSamochod() {
        return new Hyundai(2018, typyNadwozi[(int)(Math.random()*3)], new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
    }
}


