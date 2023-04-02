package com.dehghan.arrays;

public class Array {
  private int [] items;
  private  int count;

   public Array(int length){
       items = new int[length];
   }

   public void insert(int item){
       //If the array if full, resize it
       if(items.length == count) {
           int[] newItem = new int[count * 2];
           for (int i = 0; i < count; i++)
               newItem[i] = items[i];
           items = newItem;

           //add the item the last
           items[count++] = item;
       }
   }

   public  void removeAt(int index){
       //Validate index
       if(index < 0 && index>= count)
       throw  new ArrayIndexOutOfBoundsException();
       //Remove
       for(int i = index; i< count ; i++)
           items[i] = items[i+1];

       count--;

   }
   public int indexOf( int item){
       for (int i =0; i< count; i++)
         if(items[i]== item)
             return i;
       return   -1;
   }
   public  void print(){
       for (int i= 0; i< count ; i++){
           System.out.println(items[i]);
       }
   }
}
