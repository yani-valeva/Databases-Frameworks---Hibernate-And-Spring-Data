package beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class

Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

       try {
           while (!input[0].equals("End")) {
               int boughtBeers = Integer.parseInt(input[0]);
               int drunkBeers = Integer.parseInt(input[1]);
               BeerCounter.beerInStock += boughtBeers;

               if (BeerCounter.beerInStock >= drunkBeers) {
                   BeerCounter.beersDrankCount += drunkBeers;
                   BeerCounter.beerInStock -= drunkBeers;
               }

               input = reader.readLine().split("\\s+");
           }

       } catch (Exception e) {
           System.out.printf("%d %d%n", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
       }
    }
}
