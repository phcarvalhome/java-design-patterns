package com.phcarvalhome.pattern.businessdelegation;

import com.phcarvalhome.pattern.businessdelegation.client.BusinessDelegationClient;

public class BusinessDelegationTest {

    public static void main(String[] args) {
        convertBRLAmountToUSD();
        convertBRLAmountToEUR();
    }

    private static void convertBRLAmountToUSD() {
        System.out.println(">>> TEST BEGINNING >>> convertBRLAmountToUSD");

        BusinessDelegationClient businessDelegationClient = new BusinessDelegationClient();
        double initialAmount = 10;
        double finalAmount = businessDelegationClient.convertToUSD(initialAmount);

        System.out.println("--- Initial amount: " + initialAmount);
        System.out.println("--- Final amount: " + finalAmount);
        System.out.println(">>> TEST END >>> convertBRLAmountToUSD");
    }

    private static void convertBRLAmountToEUR() {
        System.out.println(">>> TEST BEGINNING >>> convertBRLAmountToEUR");

        BusinessDelegationClient businessDelegationClient = new BusinessDelegationClient();
        double initialAmount = 10;
        double finalAmount = businessDelegationClient.convertToEUR(initialAmount);

        System.out.println("--- Initial amount: " + initialAmount);
        System.out.println("--- Final amount: " + finalAmount);
        System.out.println(">>> TEST END >>> convertBRLAmountToEUR");
    }
}