package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws  IOException{
        //try with resources block
        try(FileWriter locFile = new FileWriter("locations.txt");
        //we can add another fileWriter in here
            FileWriter directions = new FileWriter("directions.txt")
        ){
            for (Location location : locations.values()){
                locFile.write(location.getLocationId() + ". " + location.getDescription() + ".\n");
                for (String direction : location.getExits().keySet()){
                    directions.write(location.getLocationId() + ". " + direction + ", " + location.getExits().get(direction) + " \n");
                }
            }
        }



        //Try and catch block
      /*  FileWriter locfile = null;
        try {
            locfile = new FileWriter("locations.txt");
            for (Location location : locations.values()) {
                locfile.write(location.getLocationId() + ". " + location.getDescription() + ".\n");
            }
            locfile.close();
        }finally {
            System.out.println("in Finally block");
        }*/
    }

    static {

        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: "+ loc + ": "+description);
               Map<String, Integer> tempExit = new HashMap<>();
               locations.put(loc, new Location(loc, description, tempExit));

                }


        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }

        /*Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "you are sitting in front of a computer",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "you are standing at the end of the plot near the tank",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "you are at the top of the hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "you are inside the house of the cows",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "you are in a valley down hill near a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "you are in the forest",tempExit));*/
    }
    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
//        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
