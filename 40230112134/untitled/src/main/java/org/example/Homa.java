package org.example;

import java.util.Scanner;

public class Homa {
    public static void main(String[] Amir)
    {
        Scanner name = new Scanner(System.in);
        System.out.println("enter your firstname : ");
        String first = name.nextLine();
        System.out.println("enter your lastname : ");
        String last = name.nextLine();
        String fullname = fullName(first,last);


    }

    static String fullName(String firstname,String lastname)
    {
        char[] F = firstname.toCharArray();
        char[] L = lastname.toCharArray();
        if (F[0]>96 && F[0]<123)
        {
            F[0] = (char) (F[0]-32);
        }
        if (L[0]>96 && L[0]<123)
        {
            L[0] = (char) (L[0]-32);
        }
        for (int i = 1; i < firstname.length(); i++)
        {
            if (F[i]>96 && F[i]<123)
            {
            }
            else
            {
                F[i] = (char) (F[i]+32);
            }
        }
        for (int i = 1; i < lastname.length(); i++)
        {
            if (L[i]>96 && L[i]<123)
            {
            }
            else
            {
                L[i] = (char) (L[i]+32);
            }
        }
        char[] Full = new char[(firstname.length() + lastname.length() + 1)];
        for (int i = 0; i < firstname.length(); i++)
        {
            Full[i]=F[i];
        }
        Full[firstname.length()]=' ';
        int j=0;
        for (int i = firstname.length()+1 ; i < firstname.length() + lastname.length() + 1 ; i++)
        {
            Full[i]=L[j];
            j++;
        }
        String FULLNAME = new String(Full);
        return FULLNAME;
    }
}