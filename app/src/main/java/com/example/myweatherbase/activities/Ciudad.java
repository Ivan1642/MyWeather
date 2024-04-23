package com.example.myweatherbase.activities;

public enum Ciudad implements Listable{
    VALENCIA,
    BARCELONA,
    MADRID,
    BILBAO,
    SEVILLA;

    @Override
    public String getDescription(){
        return this.name();
    }
}
