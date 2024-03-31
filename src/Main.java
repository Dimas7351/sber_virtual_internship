import models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/Задача ВС Java Сбер.csv");
        Scanner sc = new Scanner(file);
        List<City> city_arr = new ArrayList<City>();
        Map<String, Integer> regions_map = new HashMap<>();

        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(";");
            City new_city = new City(line[1],line[2],line[3],
                    Integer.parseInt(line[4]));
            if(line.length==6)
                new_city.setFoundation(line[5]);
            city_arr.add(new_city);
        }

//        City[] array_of_citiesList = city_arr.toArray(new City[0]);
//
//        int max_population = 0;
//        int index_max_population = 0;
//        for(int i = 0; i<array_of_citiesList.length; i++){
//            if (array_of_citiesList[i].getPopulation()>max_population) {
//                max_population = array_of_citiesList[i].getPopulation();
//                index_max_population = i;
//            }
//        }

        for(City city : city_arr){
            String region = city.getRegion();
            if(regions_map.containsKey(region)){
                regions_map.put(region,regions_map.get(region)+1);
            }
            else
                regions_map.put(region,1);
        }

        for (Map.Entry<String, Integer> entry : regions_map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static void sort_by_name(List<City> city_arr){
        city_arr.sort(new Comparator<>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    public static void sort_by_name_reversed(List<City> city_arr){
        city_arr.sort((o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
    }

    public static void sort_by_two_coloumns(List<City> city_arr){
        city_arr.sort((o1, o2) -> {
            int districtCompare = o1.getDistrict().compareTo(o2.getDistrict());
            if (districtCompare != 0)
                return districtCompare;
            else
                return o1.getName().compareTo(o2.getName());
        });
    }

    public static void sort_by_two_coloumns_reversed(List<City> city_arr){
        city_arr.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                int districtCompare = o1.getDistrict().compareTo(o2.getDistrict());
                if (districtCompare != 0)
                    return districtCompare;
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });
    }
}