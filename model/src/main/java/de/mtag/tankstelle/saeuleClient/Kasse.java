package de.mtag.tankstelle.saeuleClient;

import java.util.UUID;

public class Kasse {
    public TankVorgang neuerVorgang(Ventil ventil) {
        return new TankVorgang(UUID.randomUUID());
    }


    public void auftankenAbgeschlossen(TankVorgang tankvorgang) {

    }


}
