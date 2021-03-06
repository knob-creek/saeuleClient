package de.mtag.tankstelle.saeuleClient;

import org.springframework.stereotype.Component;

enum Zustand {
    BEREIT,
    TANKEND,
    GESPERRT
}
@Component
public class Ventil {

    Säule säule;
    Zustand zustand;

    public Säule getSäule() {
        return säule;
    }

    public void setSäule(Säule säule) {
        this.säule = säule;
    }

    public Zustand getZustand() {
        return zustand;
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
