package org.example;

import java.util.Scanner;

public class Homa {
    public static void main(String[] Amir)
    {
        Scanner name = new Scanner(System.in);
        System.out.print("enter your firstname : ");
        String first = name.nextLine();
        System.out.print("enter your lastname : ");
        String last = name.nextLine();
        String FullName = fullName(first,last);
        System.out.print("enter your phone number : ");
        String phone = name.nextLine();
        String PhoneNumber = phoneNumber(phone);
        System.out.print("enter your userid : ");
        String user = name.nextLine();
        String ID = UserId(user);


    }
    static String UserId (String id)
    {
        Scanner Test = new Scanner(System.in);
        boolean flag = true;
        while (flag == true)
        {
            if (id.length()>4 && id.length() < 13)
            {
                flag = false;
            }
            else
            {
                System.out.print("Wrong entry.Try again : ");
                id = Test.nextLine();
            }
        }
        return  id;
    }
    static String phoneNumber(String number)
    {
        Scanner Test = new Scanner(System.in);
        String temp = "";
        char[] N = new char[10];
        for (int i = 0; i < number.length(); i++)
        {
            N[i] = number.charAt(i);
        }
        boolean flag = true;
        while (flag == true)
        {
            if ((N[0] == '9' && ((number.length() == 10)||(temp.length() == 10))))
            {
                flag = false;
            }
            else
            {
                System.out.print("Wrong entry.Try again : ");
                temp = Test.nextLine();
                for (int i = 0; i < temp.length(); i++)
                {
                    N[i] = temp.charAt(i);
                }
            }
        }
        char[] N1 = new char[11];
        N1[0] = '0';
        for (int i = 0,j=1; i < 10; i++,j++)
        {
            N1[j]=N[i];
        }
        String PN = new String(N1);
        return  PN;
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