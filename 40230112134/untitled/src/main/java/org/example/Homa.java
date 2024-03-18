package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Homa {
    public static void main(String[] Amir)
    {
        System.out.println("first enter your information");
        String[] Information = userFullInformation();
        MainPage(Information);
    }
    static void  MainPage(String[] Information)
    {
        System.out.println("Choose your path");
        System.out.println("1.Encoded your information");
        System.out.println("2.Decoded your information");
        System.out.println("3.Exit");
        Scanner SC = new Scanner(System.in);
        int way = SC.nextInt();
        boolean flag = false;
        while (flag == false)
        {
            switch (way)
            {
                case 1:
                    informationEncoder(Information);
                    break;
                case 2:
                    informationDecoder(Information);
                    break;
                case 3:
                    System.out.println("Bye");
                    flag = true;
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }
        }
        System.out.println(Arrays.toString(Information));
    }
    static void informationEncoder(String[] information)
    {
        String NI = Arrays.toString(information.clone());
        System.out.println(NI);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your shift :");
        int shift = scanner.nextInt();
        char[] NI1 = NI.toCharArray();
        for (int i = 0; i < NI1.length ; i++)
        {
            NI1[i] = (char) (NI1[i] + shift);
        }
        String NI2 = new String(NI1);
        String[] newinformation = NI2.split(",");
        System.out.println(Arrays.toString(newinformation));
        MainPage(newinformation);
//        return newinformation;
    }
    static void informationDecoder(String[] information)
    {
        String NI = Arrays.toString(information.clone());
        System.out.println(NI);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your shift :");
        int shift = scanner.nextInt();
        char[] NI1 = NI.toCharArray();
        for (int i = 0; i < NI1.length ; i++)
        {
            NI1[i] = (char) (NI1[i] - shift);
        }
        String NI2 = new String(NI1);
        String[] newinformation = NI2.split(",");
        System.out.println(Arrays.toString(newinformation));
        MainPage(newinformation);
//        return newinformation;
    }
    static String[] userFullInformation()
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
        System.out.print("enter your interests : ");
        String[] Interest = getInterests();
        String[] UFI = new String[2+Interest.length];
        UFI[0] = "Hello! My name is " + FullName + ". My ID is " + ID + ". Here are some of my interests:";
        for (int i = 1; i < Interest.length+1; i++)
        {
            UFI[i] = i + ". " + Interest[(i-1)];
        }
        UFI[UFI.length-1] = "You can reach me via my phone number " +  PhoneNumber + ".";
        return UFI;
    }
    static String[] getInterests()
    {
        Scanner input = new Scanner(System.in);
        String[] List = new String[10];
        int i = 0;
        boolean flag = false;
        while (flag == false)
        {
            List[i] = input.nextLine();
            System.out.println("if you done enter (0)");
            if (Objects.equals(List[i], "0"))
            {
                flag = true;
                break;
            }
            i++;
        }
        String[] L = new String[i];
        for (int j = 0; j<i ; j++)
        {
            L[j]=List[j];
        }
        return L;
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
        return new String(N1);
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
        return new String(Full);
    }
}