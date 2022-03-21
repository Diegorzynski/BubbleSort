import org.junit.Assert;
import org.junit.Test;
import strinsort.BubbleSort;
import strinsort.Sortable;
import strinsort.Swapper;


import java.util.*;

public class BubbleSortTest {
    public class ArrayListSortable implements Sortable {
        final private ArrayList actualNames;
        ArrayListSortable(ArrayList actualNames){
            this.actualNames = actualNames;
        }

        @Override
        public Object get(int i) {
            return actualNames.get(i);
        }

        @Override
        public int size() {
            return actualNames.size();
        }
    }

    public class ArrayListSwapper implements Swapper{
        final private ArrayList actualNames;

        ArrayListSwapper(ArrayList actualNames) {
            this.actualNames = actualNames;
        }

        @Override
        public void swap(int i, int j) {
            Object temp = actualNames.get(i);
            actualNames.set(i, actualNames.get(j));
            actualNames.set(j, temp);
        }
    }

    @Test
     public void canSortStrings2(){
        List<String> actualNames = new ArrayList<>(List.of(
                "Maria", "Diego","Buchecha","Ana", "Nelson"));


        List<String> expected = new ArrayList<>(List.of(
                "Ana","Bucheche","Diego","Maria","Nelson"));


        ArrayListSortable names = new ArrayListSortable((ArrayList)actualNames);
        BubbleSort sort = new BubbleSort();
        sort.setComparator(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                final String first = (String) o1;
                final String second = (String) o2;

                return first.compareTo(second);
            }
        });

        sort.setSwapper(new ArrayListSwapper((ArrayList) actualNames));
        sort.sort(names);

        Assert.assertEquals(expected, actualNames);



    }
  };





