import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        int[] permutation = new int[amount];
        // define permutation
        for(int i = 0; i < amount; i++) {
            permutation[i] = input.nextInt();
        } // end definition
        int fMod = permutation[0];
        PopulatedList leftInCircle;
        while(true){
            //System.out.println(fMod + " fMod");
            leftInCircle = new PopulatedList(amount);
            if(goThrough(fMod, leftInCircle, permutation)){
                break;
            }
            fMod += amount;
        }
        System.out.println(fMod + " is the answer");
    }

    public static boolean goThrough(int fMod, PopulatedList array, int[] permutation){
        int p = -1;
        int size = array.size();
        for(int i = 0; i < permutation.length; i++){
            if(size == 1){
                return array.get(0) == permutation[permutation.length - 1];
            }
            if(p + (fMod % size) >= size){
                p -= size;
            }
            p += fMod % size;
            if(size >= 2 && p == -1 && fMod % size == 0){
                p = size - 1;
            }
            //System.out.println("permutation[i]" + permutation[i] + " array.get(p)" + array.get(p) + " -> P: " + p);
            if(permutation[i] == array.get(p)){
                array.remove(p);
            } else {
                return false;
            }
            p--;
            size--;
        }
        return true;
    }

    public static class PopulatedList{
        ArrayList<Integer> array = new ArrayList<Integer>();
        PopulatedList(int num){
            for(int i = 1; i <= num; i++){
                array.add(i);
            }
        }

        public void add(int num){array.add(num);}

        public void remove(int num){array.remove(num);}

        public int size(){return array.size();}

        public int get(int index){return array.get(index);}

        public void print(){System.out.println(array);}
    }
}