package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int NOF_NUMBERS = 1000;
        final int ELEMS_TEST = 100_000;
        final int CENTRAL_INDEX = 500;

        int swapVar;

        final ArrayList<Integer> numbers = new ArrayList<Integer>();

         for (int i = 0; i < NOF_NUMBERS; i++) {
            numbers.add(i + NOF_NUMBERS);
         }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> numbers2 = new LinkedList<Integer>(numbers);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        swapVar = numbers.get(numbers.size() - 1);
        numbers.set(numbers.size() - 1 , swapVar);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int integer : numbers) {
            System.out.println("Value of element : " + integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
       
        long time = System.nanoTime();
        
        for (int i = 0; i <= ELEMS_TEST; i++) {
            numbers.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting  "
                + numbers.size()
                + " ints in an ArrayList took: "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        
        for (int i = 0; i <= ELEMS_TEST; i++) {
            numbers2.add(i);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting   "
                + numbers2.size()
                + " ints in a LinkedList took: "
                + time
                + " ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        
        for (int i = 0; i <= NOF_NUMBERS; i++) {
            numbers.get(CENTRAL_INDEX);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + NOF_NUMBERS
                + " ints in an ArrayList took "
                + time
                + " ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        
        for (int i = 0; i <= NOF_NUMBERS; i++) {
            numbers2.get(CENTRAL_INDEX);
        }
        /*
         * Compute the time and print result
         */
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + NOF_NUMBERS
                + " ints in an LinkedList took "
                + time
                + " ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        Map<String,Long> continent = new HashMap<String,Long>();

        continent.put("Africa", 1_110_635_000L);
        continent.put("Americas", 972_005_000L);
        continent.put("Antarctica", 0L);
        continent.put("Asia",4_298_723_000L);
        continent.put("Europe",742_452_000L);
        continent.put("Oceania",38_304_000L);
        
        /*
         * 8) Compute the population of the world
         */

        Long popolazione = 0L;

        for(Long i : continent.values()){
            popolazione = popolazione + i;
        }

        System.out.print("la Popolazione mondiale è: " + popolazione);
    }
}
