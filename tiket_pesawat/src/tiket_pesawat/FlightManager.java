package tiket_pesawat;

import java.util.HashMap;
import java.util.Map;

public class FlightManager {
    private static Map<String, Flight> flights = new HashMap<>();

    public static void initializeData() {
        flights.put("1", new Flight("Jakarta-Singapore", "AirAsia", "Economy", 1.750));
        flights.put("2", new Flight("Jakarta-Malaysia", "Garuda Indonesia", "Business", 2.500));
        flights.put("3", new Flight("Jakarta-Tokyo", "Japan Airlines", "First Class", 3.000));
        flights.put("4", new Flight("Jakarta-Mekkah", "Citilink", "First Class", 3.500));
        flights.put("5", new Flight("Jakarta-Turki", "Batik Air", "Business", 4.000));
    }

    public static Map<String, Flight> getFlights() {
        return flights;
    }

    public static Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }
}



