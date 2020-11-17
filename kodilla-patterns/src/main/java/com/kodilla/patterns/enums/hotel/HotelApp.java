package com.kodilla.patterns.enums.hotel;

import com.kodilla.patterns.enums.hotel.PriceList;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class HotelApp {

    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("   - low season: " + Season.LOW.getSingleRoomPrice());
        System.out.println("   - high season: " + Season.HIGH.getSingleRoomPrice());
        System.out.println("   - holiday season: " + Season.HOLIDAY.getSingleRoomPrice());
        System.out.println("2. Double Bed rooms");
        System.out.println("   - low season: " + Season.LOW.getDoubleRoomPrice());
        System.out.println("   - high season: " + Season.HIGH.getDoubleRoomPrice());
        System.out.println("   - holiday season: " + Season.HOLIDAY.getDoubleRoomPrice());

        Season season = Season.HOLIDAY;

        System.out.println(season);
    }
}