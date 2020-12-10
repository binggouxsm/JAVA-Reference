package strategy;


public class Main {

    public static void main(String[] args) {
        Cat[] arr = new Cat[]{new Cat(1,2),new Cat(2,1),new Cat(3,3)};
        Sorter sorter = new Sorter(new CatWeightComparator());
        sorter.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        sorter.setComparator(new CatHeightComparator());
        sorter.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }


    }


}
