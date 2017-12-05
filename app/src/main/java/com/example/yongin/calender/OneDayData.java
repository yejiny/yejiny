package com.example.yongin.calender;

import java.util.Calendar;

import com.example.yongin.calender.WeatherInfo.Weather;

public class OneDayData {
    
    Calendar cal;
    Weather weather;
    private CharSequence msg = "";

    public OneDayData() {
        this.cal = Calendar.getInstance();
        this.weather = Weather.SUNSHINE;
    }

    public void setDay(int year, int month, int day) {
        cal = Calendar.getInstance();
        cal.set(year, month, day);
    }

    public void setDay(Calendar cal) {
        this.cal = (Calendar) cal.clone();
    }

    public Calendar getDay() {
        return cal;
    }

    public int get(int field) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return cal.get(field);
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public CharSequence getMessage() {
        return msg;
    }

    public void setMessage(CharSequence msg) {
        this.msg = msg;
    }
}
