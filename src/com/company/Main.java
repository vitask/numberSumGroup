package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите размер массива");
        int arraySize = Integer.parseInt(reader.readLine());
        int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите " + (i + 1) + "-ый элемент: ");
            array[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println("Выберите число групп");
        int count = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<Integer>> gis = groupIntegerSum(array, count);*/

        int [] array = new int [] {1,9,2,8,4,6,7,3};
        ArrayList<ArrayList<Integer>> gis = groupIntegerSum(array,2);

        try {
            for (ArrayList<Integer> group : gis) {
                for (int i : group) {
                    System.out.print((i) + " ");
                }
                System.out.println();
            }
        }
            catch(NullPointerException e) {
                System.out.println(e);

            }
        }


    private static ArrayList<ArrayList<Integer>> groupIntegerSum(int[] array, int counts) {
        Integer[] integerArr = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
            integerArr[i] = array[i];
        ArrayList<Integer> arrList = new ArrayList(Arrays.asList(integerArr));
        ArrayList<ArrayList<Integer>> gisList = new ArrayList<>();
        System.out.println("Исходный массив:" + arrList);
        int sum = 0;
        for (int i : array)
            sum += i;
        System.out.println("Сумма чисел массива: " + sum);
        Collections.sort(arrList);
        if (sum % counts != 0)
            System.out.println("Невозможно поделить на равные группы");
        System.out.println("Отсортированный массив: " + arrList);
        try {
            for (int i = 0; i < counts; i++) {
                ArrayList<Integer> group = new ArrayList<>();
                int res = 0;
                int index = arrList.size() - 1;
                while (res != (sum / counts)) {
                    if (res + arrList.get(index) <= (sum / counts)) {
                        res += arrList.get(index);
                        group.add(arrList.get(index));
                        arrList.remove(index);
                    }
                    index--;

                }
                gisList.add(group);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не удалось создать на заданное количество групп");
        }
        return gisList;
    }
}
