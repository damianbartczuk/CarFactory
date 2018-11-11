package Samochody;

import java.awt.*;


public abstract class Samochod implements Comparable{
    @Override
    public int compareTo(Object o) {
        if(this.id == ((Samochod)o).id)
            return 0;
        else if(this.id > ((Samochod)o).id)
            return 1;
        else
            return -1;
    }

    protected int rokWyprodukowania;
    protected String typNadwozia;
    protected Color color;
    public int id;

    public Samochod(int rokWyprodukowania, String typNadwozia, Color color) {
        this.rokWyprodukowania = rokWyprodukowania;
        this.typNadwozia = typNadwozia;
        this.color = color;
    }

    public Samochod(int rokWyprodukowania, String typNadwozia, Color color, int id) {
        this.rokWyprodukowania = rokWyprodukowania;
        this.typNadwozia = typNadwozia;
        this.color = color;
        this.id = id;
    }

    public int getRokWyprodukowania() {
        return rokWyprodukowania;
    }

    public String getTypNadwozia() {
        return typNadwozia;
    }

    public Color getColor() {
        return color;
    }

    public void setRokWyprodukowania(int rokWyprodukowania) {
        this.rokWyprodukowania = rokWyprodukowania;
    }

    public void setTypNadwozia(String marka) {
        this.typNadwozia = typNadwozia;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "rokWyprodukowania=" + rokWyprodukowania +
                ", typNadwozia='" + typNadwozia + '\'' +
                ", color=" + color +
                ", id=" + id +
                '}';
    }
}