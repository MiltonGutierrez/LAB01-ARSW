/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

import javax.print.attribute.SupportedValuesAttribute;

/**
 *
 * @author hcadavid
 */
public class Main {
    
    public static void main(String a[]){
        long startTime = System.currentTimeMillis();
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        List<Integer> blackListOcurrences=hblv.checkHost("202.24.34.55", 50);
        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);
        long endTime = System.currentTimeMillis();
        System.out.println("El tiempo total de ejecucion es: " + (endTime - startTime ) + " milisegundos.");
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        System.out.println("Memoria total: " + totalMemory);
        System.out.println("Memoria libre: " + freeMemory);
        System.out.println("Memoria máxima: " + maxMemory);
    }
    
}
