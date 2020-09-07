package models;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Author: Jannik Hausin
 */

public class Config {
    private String name;
    private int totalLots;
    private int womenLots;
    private int disabledLots;
    private int aboLots;
    private double price;

    /**
     * Default Configuration
     */
    public Config(){
        this.name = "Car Park";
        this.totalLots = 40;
        this.womenLots = 5;
        this.disabledLots = 2;
        this.aboLots = 8;
        this.price = 1.5;
    }
    public Config(JsonObject config){
        if(validateConfig(config)) {
            this.name = config.getString("name");
            this.totalLots = config.getInt("lots");
            this.womenLots = config.getInt("women");
            this.disabledLots = config.getInt("disabled");
            this.aboLots = config.getInt("abo");
            this.price = Double.parseDouble(config.getString("price"));
        }
        else{
            throw new IllegalArgumentException("Configuration invalid, please provide a valid configuration.");
        }
    }
    public boolean validateConfig(JsonObject config){
        return config.getInt("lots")
                > config.getInt("women")
                + config.getInt("disabled")
                + config.getInt("abo");
    }
}
