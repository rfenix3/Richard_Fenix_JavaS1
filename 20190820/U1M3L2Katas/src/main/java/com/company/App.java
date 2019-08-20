package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> mapObj) {

        Set<String> keys = mapObj.keySet();
        for (String key : keys) {
            System.out.println("key = " + key);
        }

        /*
        We can also use lambda to do this...
        mapObj.forEach((k, v) ->
                System.out.println("key = " + k));
        */
    }

    public void printValues(Map<String, String> mapObj) {
        Collection<String> i = mapObj.values();
        System.out.println("value = " + i);
    }

    public void printKeysAndValues(Map<String, String> mapObj) {
        for (Map.Entry<String, String> entry : mapObj.entrySet())
        {
            String k = entry.getKey();
            String v = entry.getValue();
            System.out.println(k + ": " + v);
        }
    }

    public Map<String, Integer> mapFun(HashMap<String, Integer> mapObj){
        mapObj.put("Toyota Camry", 2012);
        mapObj.put("Chevy Camaro", 1969);
        mapObj.put("Hyundai Genesis ", 2015);
        mapObj.put("Jeep Wrangler", 2003);
        mapObj.put("Honda Civic", 2018);
        //mapObj.put("Toyota Supra", 1995);
        mapObj.put("Pontiac GTO", 1964);
        mapObj.put("Ford Explorer", 2012);
        mapObj.put("Smart Fortwo", 2013);

        mapObj.remove("Jeep Wrangler");
        return mapObj;
    }


    public Map<String, List<Car>> listCars(ArrayList<Car> cars){
        List<Car> toyotaList =  new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        for (Car carObj: cars) {
            switch (carObj.getMake()) {
                case "Toyota":
                    toyotaList.add(carObj);
                    break;
                case "Ford":
                    fordList.add(carObj);
                    break;
                case "Honda":
                    hondaList.add(carObj);
                    break;
                default:
                    continue;
            }
        }

        Map<String, List<Car>> carList =  new HashMap<String, List<Car>>();
        carList.put("Toyota", toyotaList);
        carList.put("Honda", hondaList);
        carList.put("Ford", fordList);

        return carList;

    };



}
