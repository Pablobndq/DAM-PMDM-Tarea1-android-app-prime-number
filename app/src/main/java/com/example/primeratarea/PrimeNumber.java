package com.example.primeratarea;

import java.util.HashMap;

public class PrimeNumber {

    private static HashMap<Integer, Integer> calculatedNumbers =  new HashMap<>();

    //Calc position prime number function
    public int calc(int number){

        if(calculatedNumbers.containsKey(number)){
            return calculatedNumbers.get(number);
        }

        int primeCount = 1;
        int verifyNumber = 1;

        while (primeCount < number){

            verifyNumber++;

            if (isPrime(verifyNumber)){
                primeCount++;
            }
        }

        calculatedNumbers.put(number, verifyNumber);

        return verifyNumber;
    }

    //Verify if is a prime number function
    private static boolean isPrime(int n){

        if(n <= 1){
            return false;
        }

        for (int i = 2; i < n; i++){

            if (n % i == 0){
                return false;
            }
        }

        return true;
    }
}
