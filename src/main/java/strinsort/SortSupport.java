package strinsort;

import java.util.Comparator;

public interface SortSupport {
    void setSwapper(Swapper swap);

    void setComparator(Comparator compare);
}
