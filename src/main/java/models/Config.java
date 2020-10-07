package models;

import javax.json.JsonObject;

/*
 * Author: Jannik Hausin
 */

public class Config {
    private String name;
    private int totalLots;
    private int womenLots;
    private int disabledLots;
    private int localLots;
    private int bikeLots;
    private double price;

    /*
     * Default Configuration
     */
    public Config() {
        this.name = "Car Park";
        this.totalLots = 40;
        this.womenLots = 6;
        this.disabledLots = 3;
        this.localLots = 12;
        this.bikeLots = 4;
        this.price = 1.5;
    }

    public Config(JsonObject config) throws IllegalArgumentException {
        if (validateConfig(config)) {
            this.name = config.getString("name");
            this.totalLots = config.getInt("lots");
            this.womenLots = config.getInt("women");
            this.disabledLots = config.getInt("disabled");
            this.localLots = config.getInt("local");
            this.bikeLots = config.getInt("bike");
            this.price = config.getJsonNumber("price").doubleValue();
        } else {
            throw new IllegalArgumentException("Configuration invalid, please provide a valid configuration.");
        }
    }

    public boolean validateConfig(JsonObject config) {
        return config.getInt("lots")
                > (config.getInt("women")
                + config.getInt("disabled")
                + config.getInt("local"));
    }

    public int getValue(String type) throws IllegalArgumentException {
        return switch (type) {
            case "total" -> this.totalLots;
            case "women" -> this.womenLots;
            case "disabled" -> this.disabledLots;
            case "local" -> this.localLots;
            case "bike" -> this.bikeLots;
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        };
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String toString() {
        return "Name: " + this.name + "\n"
                + "Anzahl Parkplätze gesamt: " + this.totalLots + "\n"
                + "Frauenparkplätze: " + this.womenLots + "\n"
                + "Behindertenparkplätze: " + this.disabledLots + "\n"
                + "Anwohnerparkplätze: " + this.localLots + "\n"
                + "Parkplätze für Motorräder: " + this.bikeLots + "\n"
                + "Preis pro Stunde: " + this.price + "€";
    }
}
