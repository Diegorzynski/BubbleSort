import org.junit.Assert;
import org.junit.Test;
import strinsort.BubbleSort;
import strinsort.Sortable;
import strinsort.Swapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BubbleSortTest1 {


    public class ArrayListSortable implements Sortable{
        final private ArrayList actualNames;

        ArrayListSortable(ArrayList actualNames){
        this.actualNames = actualNames;
    }

    @Override
    public Object get(int i){
        return actualNames.get(i);
    }


    @Override
    public int size(){
        return actualNames.size();

    }


    public class ArrayListSwapper implements Swapper{
        final private ArrayList actualNames;

        ArrayListSwapper(ArrayList actualNames){
            this.actualNames = actualNames;
        }

        @Override
        public void swap(int i, int j){
            Object temp = actualNames.get(i);
            actualNames.set(i, actualNames.get(j));
            actualNames.set(j, temp);
        }

    }
        @Test
        public void testSize(){
            int expected = 5;
            int result=  actualNames.size();
            Assert.assertEquals(5,result );
        }

    @Test
    public void canSortStrings2() {

        List<String> ctualNames = new ArrayList<>(Arrays.asList("Maria", "Diego",
                "Buchecha", "Ana", "Nelson"));

        List<String> expectedResult = new ArrayList<>((Arrays.asList(
                "Ana", "Buchecha", "Diego",
                "Maria", "Nelson")));

        //comparing Strings is straightforward
        Comparator stringCompare = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                final String first = (String) o1;
                final String second = (String) o2;
                return first.compareTo(second);

            }
        };

        //named class also possible, but not always recommended
        class SwapActualNamesArrayElements implements Swapper {
            @Override
            public void swap(int i, int j) {
                final Object temp = actualNames.get(i);
                actualNames.set(i, actualNames.get(j));
                actualNames.set(j, (String) temp);
            }
        }

        ArrayListSortable names = new ArrayListSortable((ArrayList) actualNames);
        BubbleSort sort = new BubbleSort();
        sort.setComparator(stringCompare);
        sort.setSwapper(new ArrayListSwapper((ArrayList) actualNames));
        sort.sort(names);

        Assert.assertEquals(expectedResult, actualNames);
      }
    }
 }


