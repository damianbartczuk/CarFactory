package Fabryki;
import java.awt.*;
import Samochody.*;

public class FabrykaVolvo extends FabrykaSamochodow<Volvo>{


    public FabrykaVolvo(Parking<Volvo> parking) {
        super(parking);
    }

    @Override
    public Volvo UtworzSamochod() {
        return new Volvo(2018, typyNadwozi[(int)(Math.random()*3)], new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
    }
}