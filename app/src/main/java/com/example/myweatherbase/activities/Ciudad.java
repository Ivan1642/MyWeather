package com.example.myweatherbase.activities;

import java.io.Serializable;

public enum Ciudad implements Listable, Serializable {
    VALENCIA("https://static.euronews.com/articles/stories/08/17/14/54/1200x675_cmsv2_6482dec4-473f-5a57-8f85-461f91a11272-8171454.jpg"),
    BARCELONA("https://offloadmedia.feverup.com/barcelonasecreta.com/wp-content/uploads/2015/07/13082735/barcelona_skyline_wallpaper-e1626099901955.jpg"),
    MADRID("https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/01/24/istock-1297090032.jpeg"),
    BILBAO("https://media.traveler.es/photos/64f59cd0756c466be81874ab/master/pass/david-vives--AQJPGnTVLE-unsplash.jpg"),
    SEVILLA("https://www.civitatis.com/f/espana/sevilla/paseo-calesa-sevilla-589x392.jpg");

    private String url;

    Ciudad(String url) {
        this.url = url;
    }

    @Override
    public String getDescription(){
        return this.name();
    }
    @Override
    public String getUrl(){
        return url;
    }
}
