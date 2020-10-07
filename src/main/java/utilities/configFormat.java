package utilities;

import models.Config;

import javax.json.Json;
import javax.json.JsonObject;

/*
 * Author: Jannik Hausin
 */
public class configFormat {
    public static JsonObject formatConfig(Config cfg) {
        return Json.createObjectBuilder()
                .add("Parkhausname", cfg.getName())
                .add("Parkplätze gesamt", cfg.getValue("total"))
                .add("Behindertenparkplätze", cfg.getValue("disabled"))
                .add("Frauenparkplätze", cfg.getValue("women"))
                .add("Anwohnerparkplätze", cfg.getValue("local"))
                .add("Motorradparkplätze", cfg.getValue("bike"))
                .add("Preis", cfg.getPrice())
                .build();
    }
}
