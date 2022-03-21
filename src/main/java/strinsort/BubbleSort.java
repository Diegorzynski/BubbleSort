package strinsort;
import java.util.Comparator;

public class BubbleSort implements Sort, SortSupport{
    private Comparator comparator = null;
    private Swapper swapper = null;


    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    @Override
    public void setComparator(Comparator comparator){
        this.comparator = comparator;
    }

    @Override
    public void sort(Sortable collection) {
        int n = collection.size();
        while(n > 1){
            for(int i=0; i < n -1; i++){
                if(comparator.compare(collection.get(i),collection.get(i+1)) > 0){
                    swapper.swap(i, i+1);
                }
            }
            n--;
        }
    }
}
