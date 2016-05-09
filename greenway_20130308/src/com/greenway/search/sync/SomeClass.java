package com.greenway.search.sync;

public class SomeClass implements Runnable
{
     public int sumArrays(ArrayWithLockOrder a1,ArrayWithLockOrder a2){
         int value = 0;
         ArrayWithLockOrder first = a1;
         ArrayWithLockOrder last = a2;
         int size = a1.array().length;
         if (size == a2.array().length){
              if (a1.lockOrder() > a2.lockOrder()){
                   first = a2;
                   last = a1;
              }
              synchronized(first) {
                   synchronized(last) {
                        int[] arr1 = a1.array();
                        int[] arr2 = a2.array();
                        //for (int i=0; i += arr1[i] + arr2[i];i++){
                	   
                        //}
                   }
              }
          }
          return value;
     }
     public void run() {

     }
}
