package Fabryki;

import Samochody.Skoda;
import Samochody.Truck;

import java.awt.*;

public class FabrykaSkoda extends FabrykaSamochodow<Skoda>{

    public FabrykaSkoda(Parking<Skoda> parking) {
        super(parking);
    }

    @Override
    public Skoda UtworzSamochod() {
        return new Skoda(2018, typyNadwozi[(int)(Math.random()*3)], new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
    }
}
