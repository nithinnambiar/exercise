package org.example;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.stream.Collectors;


public class UniqueProduct {

  public static String firstUniqueProduct(String[] products) {

    if (products == null) {
      return null;
    }
    if (products.length == 1) {
      return products[0];
    }
    LinkedHashMap<String, Integer> hashSet = new LinkedHashMap<>();

    for (String str : products) {
      int count = hashSet.getOrDefault(str,0);
        hashSet.put(str, ++count);

      }

     Optional<String> opt = hashSet.entrySet().stream().filter(entry -> entry.getValue().intValue() == 1).map(entry -> entry.getKey()).findFirst();
    if(opt.isPresent())
      return opt.get();
    else
      return null;

  }

  public static void main(String[] args) {
    System.out.println(firstUniqueProduct(new String[]{"Apple","computer", "table", "Apple", "computer"}));
  }

}
