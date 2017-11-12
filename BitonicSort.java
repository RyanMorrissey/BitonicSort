// Author: Ryan Morrissey
// CLass: CSCI 251
// Bitonic Sort

import java.util.*;

public class BitonicSort
{

  void sort(float list[], int low, int count, boolean ascending)
  {
    if(count > 1)
    {
      int k = count / 2;
      sort(list, low, k, true); // Sort in ascending order
      sort(list, low + k, k, false); // Sort in descending order
      merge(list, low, count, ascending);
    }
  }

  void merge(float list[], int low, int count, boolean ascending)
  {
    if(count > 1)
    {
      int k = count / 2;
      for(int i = low; i < low + k; i++)
      {
        swap(list, i, i+k, ascending);
      }
      merge(list, low, k, ascending);
      merge(list, low + k, k, ascending);
    }
  }

  // Will swap the values of two indexes if conditions allow
  public void swap(float list[], int i, int j, boolean ascending)
  {
    if((list[i] > list[j] && ascending == true) ||
    (list[i] < list[j] && ascending == false))
    {
      float temp = list[i];
      list[i] = list[j];
      list[j] = temp;
    }
  }


  public static void main(String[] args)
  {
    Scanner read = new Scanner(System.in);
    System.out.print("Enter the size of the dataset (1 for 1k, 4 for 4k, 8 for 8k, and 16 for 16k):  ");
    int size = Integer.parseInt(read.next());
    // Change the size of something of a power of 2
    if(size == 1)
      size = 1024;
    else if(size == 2)
      size = 2048;
    else if(size == 4)
      size = 4096;
    else if(size == 16)
      size = 16384;
    else
    {
      System.out.println("Incorrect size of dataset");
      System.exit(1);
    }
    float[] list = new float[size];
    Random rand = new Random();
    long startTime = System.currentTimeMillis();
    rand.setSeed(startTime);
    // Now to create a list of random floats
    for(int i = 0; i < list.length; i++)
    {
      list[i] = (float)rand.nextInt(1000 - 1 + 1) + 1;
    }
    BitonicSort p2 = new BitonicSort();
    p2.sort(list, 0, list.length, true); // Start the sort Ascending = true
    System.out.println("\nArray Sorted");
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Runtime:  " + totalTime + " ms");

    // Test print
    /*for(int i = 0; i < list.length; i++)
    {
      System.out.println(list[i]);
    }*/
  }
}
