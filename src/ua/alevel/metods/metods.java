package ua.alevel.metods;

import com.sun.javafx.image.BytePixelSetter;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Student {
    String firstname, middlename, lastname, address, language;
    int year, month;

    Student(String firstname, String middlename, String lastname, String address, String language, int year, int month) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address = address;
        this.language = language;
        this.year = year;
        this.month = month;
    }
    Student(Student stu){
        this.firstname = stu.firstname;
        this.middlename = stu.middlename;
        this.lastname = stu.lastname;
        this.address = stu.address;
        this.language = stu.language;
        this.year = stu.year;
        this.month =stu.month;
    }

    public int compareTo(Student s2){
        int result = this.lastname.compareTo(s2.lastname);
        if (result!=0)
            return result;
        else {
            result = this.firstname.compareTo(s2.firstname);
            if (result!=0)
                return  result;
            else
                return this.middlename.compareTo((s2.middlename));
        }
    }

}

public class metods {
    public static void main(String[] args) {
        //в классе с main возможны только статические методы
        //myMetod("1", 2, 3, 4, 5, 6);
        //myMet2(new int[]{1, 2, 3, 4, 5, 6});
        //findMaxRepeat();

        //int recNum = 1324;
        //System.out.println("number " + recNum + " sum " + recursia(recNum));

        Student[] st = {
                new Student("n1", "s", "l", "a", "g1", 2, 3),
                new Student("dn", "123s", "wel", "g2", "23g", 22, 33),
                new Student("wen", "32s", "wel", "g1", "weg", 23, 33),
                new Student("n01", "12s", "rq", "g2", "weg", 52, 23),
                new Student("n21", "s1", "l1", "g3", "g1", 22, 13),
                new Student("n31", "s1", "l1", "g3", "g1", 22, 13),
                new Student("n41", "s1", "l1", "g3", "g1", 22, 13)
        };

        Student[] s1 = new Student[10];
        Student[] s2 = new Student[10];

        for (Student s : st) {
            int n1 = 0, n2 = 0, indexEmptyS1=0,indexEmptyS2=0;
            for (int i = 0; i < s1.length; i++) {
                Student current = s1[i];
                if (current == null) {
                    indexEmptyS1 = i;
                    break;
                }
                if (current.language.equals(s.language)) {
                    n1++;
                }
            }
            for (int i = 0; i < s2.length; i++) {
                Student current = s2[i];
                if (current == null) {
                    indexEmptyS2 = i;
                    break;
                }
                if (current.language.equals(s.language)) {
                    n2++;
                }
            }
            if(n1>n2)
                s2[indexEmptyS2]=new Student(s);
            else
                s1[indexEmptyS1]=new Student(s);
        }
        for (Student s: s1) {
            if (s == null)
                break;
            System.out.print(s.lastname+" "+s.language+"|");
        }
        System.out.println();
        for (Student s: s2) {
            if (s == null)
                break;
            System.out.print(s.lastname+" "+s.language+"|");
        }
        System.out.println();

        sort(s1);
        sort(s2);
    }
    public static void sort(Student[]s1){
        for (int j = 0; j <= s1.length - 2; j++) {
            for (int i = j; i <= s1.length - 2; i++) {
                Student student1 = s1[i], student2 = s1[i + 1];
                if (student2 == null)
                    break;
                if (student1.compareTo(student2) > 0) {
                    s1[i] = student2;
                    s1[i + 1] = student1;
                }
            }
        }

        for (Student s: s1) {
            if (s == null)
                break;
            System.out.print("lastname="+s.lastname+" firstname="+s.firstname+" middlename="+s.middlename+" |");
        }
        System.out.println();
    }

    /*public static int recursia(int rec) {
        if (rec < 10)
            return rec;
        //int num = rec % 10;
        //return recursia((rec - num) / 10) + num;
        return recursia(rec / 10) + rec % 10;
    }

    public static void myMetod(String d, int... params) {

    }

    public static void myMet2(int[] params) {
    }

    public static void findMaxRepeat() {
        Random rand = new Random();
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(2);
            //ThreadLocalRandom.current().nextInt(2);
            //SecureRandom sc = new SecureRandom();
            //sc.nextInt(2);
            System.out.print(mas[i]);
        }
        System.out.println();
        int maxRepeat = 0, currentRepeat = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 1)
                currentRepeat += 1;
            else {
                if (currentRepeat > maxRepeat)
                    maxRepeat = currentRepeat;
                currentRepeat = 0;
            }
        }
        if (currentRepeat > maxRepeat)
            maxRepeat = currentRepeat;
        System.out.println(maxRepeat);


        int[][] mas2 = new int[10][10];
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j < mas2[i].length; j++) {
                mas2[i][j] = rand.nextInt(2);
                System.out.print(mas2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=============================");
        int maxString = 0, StringOfMaxRepeat = 0;
        for (int i = 0; i < mas2.length; i++) {
            int maxRepeat2 = 0, currentRepeat2 = 0;
            for (int j = 0; j < mas2[i].length; j++) {
                if (mas2[i][j] == 1)
                    currentRepeat2 += 1;
                else {
                    if (currentRepeat2 > maxRepeat2)
                        maxRepeat2 = currentRepeat2;
                    currentRepeat2 = 0;
                }
            }
            if (currentRepeat2 > maxRepeat2)
                maxRepeat2 = currentRepeat2;
            System.out.print(maxRepeat2 + " ");
            if (maxRepeat2 > maxString) {
                maxString = maxRepeat2;
                StringOfMaxRepeat = i;
            }
        }
        System.out.println();

        int maxColumn = 0, ColumnOfMaxRepeat = 0;
        for (int i = 0; i < mas2[0].length; i++) {
            int maxRepeat2 = 0, currentRepeat2 = 0;
            for (int j = 0; j < mas2.length; j++) {
                if (mas2[j][i] == 1)
                    currentRepeat2 += 1;
                else {
                    if (currentRepeat2 > maxRepeat2)
                        maxRepeat2 = currentRepeat2;
                    currentRepeat2 = 0;
                }
            }
            if (currentRepeat2 > maxRepeat2)
                maxRepeat2 = currentRepeat2;
            System.out.print(maxRepeat2 + " ");
            if (maxRepeat2 > maxColumn) {
                maxColumn = maxRepeat2;
                ColumnOfMaxRepeat = i;
            }
        }
        System.out.println();
        if (maxString > maxColumn)
            System.out.println("max repeat " + maxString + " string of max repeat " + (StringOfMaxRepeat + 1));
        else
            System.out.println("max repeat " + maxColumn + " column of max repeat " + (ColumnOfMaxRepeat + 1));


    }*/
}
