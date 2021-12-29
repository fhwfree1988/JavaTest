package ir.Me.session_1.e03;

import java.io.Console;

public class StringBuilderTest2 {
    //https://www.geeksforgeeks.org/c-sharp-string-vs-stringbuilder/
    public static void concat1(String s1)
    {

        // taking a string which
        // is to be Concatenate
        String st = "forGeeks";

        // using String.Concat method
        // you can also replace it with
        // s1 = s1 + "forgeeks";
        s1 = String.Concat(s1, st);
    }

    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2)
    {

        // using Append method
        // of StringBuilder class
        s2.Append("forGeeks");
    }

    // Main Method
    public static void Main(String[] args)
    {

        String s1 = "Geeks";
        concat1(s1); // s1 is not changed
        Console.WriteLine("Using String Class: " + s1);

        StringBuilder s2 = new StringBuilder("Geeks");
        concat2(s2); // s2 is changed
        Console.WriteLine("Using StringBuilder Class: " + s2);
    }
}

