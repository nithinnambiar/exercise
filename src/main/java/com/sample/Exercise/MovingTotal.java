package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovingTotal {

  /**
   * Adds/appends list of integers at the end of internal list.
   */

  private List<Integer> elements = new ArrayList<>();
  private Set<Integer> movingTotal = new HashSet<>();

  public void append(int[] list) {

    if (list == null || list.length == 0) {
      return;
    }

    for (int i : list) {
      elements.add(i);
    }
    calculateMovingTotal();


  }

  private void calculateMovingTotal() {
    int sum = 0;
    int index = 0;

    while (index + 3 <= elements.size() + 1) {

      sum = elements.get(index) + elements.get(index + 1) + elements.get(index + 2);
      movingTotal.add(sum);
      index++;


    }
  }

  /**
   * Returns boolean representing if any three consecutive integers in the internal list have given
   * total.
   */
  public boolean contains(int total) {
    return movingTotal.contains(total);
  }

  public static void main(String[] args) {
    MovingTotal movingTotal = new MovingTotal();

    movingTotal.append(new int[]{1, 2, 3, 4});

    System.out.println(movingTotal.contains(6));
    System.out.println(movingTotal.contains(9));
    System.out.println(movingTotal.contains(12));
    System.out.println(movingTotal.contains(7));

    movingTotal.append(new int[]{5});

    System.out.println(movingTotal.contains(6));
    System.out.println(movingTotal.contains(9));
    System.out.println(movingTotal.contains(12));
    System.out.println(movingTotal.contains(7));
  }

}
