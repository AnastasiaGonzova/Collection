import classes.MyLinkedList;
import classes.Point;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        long StartTime, EndTime;
        System.out.println("Let's test MyLinkedList");

        System.out.println("CREATING");

        StartTime = System.nanoTime();
        MyLinkedList<Point> myPoints = new MyLinkedList<>();
        EndTime = System.nanoTime();

        System.out.printf("{Creating: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        LinkedList<Point> myLinkPoints = new LinkedList<>();
        EndTime = System.nanoTime();

        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        StartTime = System.nanoTime();
        myPoints.Add(new Point());
        EndTime = System.nanoTime();
        System.out.printf("{Adding to the end: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.add(new Point());
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        //myPoints.Add(new Point(), 2);// {to test the method isPositionIndex()}
        Point p1 = new Point(2, 3);
        myPoints.Add(p1);
        myLinkPoints.add(p1);
        myPoints.Add(new Point(16, 5));
        myLinkPoints.add(new Point(16, 5));
        Point p2 = p1;
        myPoints.Add(p2, 0);
        myLinkPoints.add(p2);

        StartTime = System.nanoTime();
        myPoints.Add(new Point(), 2);
        EndTime = System.nanoTime();
        System.out.printf("{Adding to the middle: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.add(2, new Point());
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        myPoints.Add(new Point(5, 3), 4);
        myLinkPoints.add(4, new Point(5, 3));
        myPoints.Add(new Point(34, 12), 0);
        myLinkPoints.add(new Point(34, 12));

        int size;
        StartTime = System.nanoTime();
        size = myPoints.Size();
        EndTime = System.nanoTime();

        System.out.printf("{Size: MyLinkedList - " + (EndTime - StartTime));
        StartTime = System.nanoTime();
        size = myLinkPoints.size();
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        System.out.println("Start collection: " + myPoints);
        System.out.println("Size =  " + myPoints.Size());
        System.out.println();

        System.out.println("DELETING");

        StartTime = System.nanoTime();
        myPoints.Clear();
        EndTime = System.nanoTime();
        System.out.printf("{Clear: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.clear();
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        System.out.println("New collection 1: " + myPoints);
        System.out.println("Size =  " + myPoints.Size());
        System.out.println();

        System.out.println("NEW CREATING");
        myPoints.Add(new Point());
        myPoints.Add(new Point(8, 9));
        myPoints.Add(new Point(6, 12), 0);
        myPoints.Add(new Point(25, 5), 2);
        myPoints.Add(new Point(1, 1));
        myLinkPoints.add(new Point());
        myLinkPoints.add(new Point(8, 9));
        myLinkPoints.add(new Point(6, 12));
        myLinkPoints.add(2, new Point(25, 5));
        myLinkPoints.add(new Point(1, 1));
        System.out.println("New collection 2: " + myPoints);
        System.out.println("Size =  " + myPoints.Size());
        System.out.println();

        System.out.println("GETTING SOME INFORMATION");

        Point pInd;
        StartTime = System.nanoTime();
        pInd = myPoints.Get(3);
        EndTime = System.nanoTime();
        System.out.println("3th element = " + pInd + " (index of first element = 0)");
        System.out.printf("{Getting element: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        pInd = myLinkPoints.get(3);
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        int ind;
        StartTime = System.nanoTime();
        ind =  myPoints.IndexOf(new Point());
        EndTime = System.nanoTime();
        System.out.println("Index of (0, 0) = " + ind);
        System.out.printf("{Getting index: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        ind = myLinkPoints.indexOf(new Point());
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();
        System.out.println();

        System.out.println("CHANGING ELEMENTS");

        StartTime = System.nanoTime();
        myPoints.Remove(1);
        EndTime = System.nanoTime();
        System.out.printf("{Remove: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.remove(1);
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        StartTime = System.nanoTime();
        myPoints.Set(new Point(90, 100), 3);
        EndTime = System.nanoTime();
        System.out.printf("{Set: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.set(3, new Point(90, 100));
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        System.out.println("New collection 3: " + myPoints);
        System.out.println();

        System.out.println("FINAL");
        System.out.printf("Final collection: ");
        for(Point p : myPoints)
            System.out.printf(p + ", ");
        System.out.println();
        System.out.println("Size =  " + myPoints.Size());
        System.out.println();

        System.out.println("CREATING AN ARRAY");
        Point[] pArray = new Point[myPoints.Size()];
        Point[] pLinkArray = new Point[myLinkPoints.size()];

        StartTime = System.nanoTime();
        myPoints.toArray(pArray);
        EndTime = System.nanoTime();
        System.out.printf("{toArray: MyLinkedList - " + (EndTime - StartTime));

        StartTime = System.nanoTime();
        myLinkPoints.toArray(pLinkArray);
        EndTime = System.nanoTime();
        System.out.printf(", LinkedList - " + (EndTime - StartTime) + "}");
        System.out.println();

        System.out.printf("Points' array 1 (with size = collection's size): ");
        for(int i = 0; i < pArray.length; i++)
            System.out.printf(pArray[i] + " ");
        System.out.println();
        Point[] pArray2 = new Point[myPoints.Size() + 2];
        myPoints.toArray(pArray2);
        System.out.printf("Points' array 2 (with size > collection's size): ");
        for(int i = 0; i < pArray2.length; i++)
            System.out.printf(pArray2[i] + " ");
        System.out.println();
        Point[] pArray3 = new Point[myPoints.Size() - 2];
        pArray3 = myPoints.toArray(pArray3);
        System.out.printf("Points' array 3 (with size < collection's size): ");
        for(int i = 0; i < pArray3.length; i++)
            System.out.printf(pArray3[i] + " ");
        System.out.println();
    }
}
