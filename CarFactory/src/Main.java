import java.io.FileWriter;
import java.io.IOException;
import Samochody.*;
import Fabryki.*;

public class Main {
    public static void main(String[] args) {
Parking<Volvo> pVolvo = new Parking<>();
Parking<Skoda> pSkoda = new Parking<>();
Parking<Hyundai> pHyundai = new Parking<>();



FabrykaSamochodow<Volvo> fVolvo = new FabrykaVolvo(pVolvo);
FabrykaSamochodow<Skoda> fSkoda = new FabrykaSkoda(pSkoda);
FabrykaSamochodow<Hyundai> fHyiundai = new FabrykaHyundai(pHyundai);


Truck truck = new Truck(pVolvo, pSkoda, pHyundai);

Thread watekVolvo = fVolvo.uruchomFabryke();
Thread watekSkoda = fSkoda.uruchomFabryke();
Thread watekHyundai = fHyiundai.uruchomFabryke();

Thread watekTruck = truck.uruchomWatek(100);

        try {
            watekVolvo.join();
            watekHyundai.join();
            watekSkoda.join();
            watekTruck.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        FileWriter fw = null;
        try {
            fw = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Zapis do pliku, rozmiar pCelny: " + truck.pCelny.size());
        for (int i = 0; i <truck.pCelny.size() ; i++) {
            try {
                fw.write(truck.pCelny.get(i).id + " " + truck.pCelny.get(i).getClass().getName() + " " + "odstawiony\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
