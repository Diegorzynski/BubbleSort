import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleStringListSortTestVersion1 {

    @Test
    public void canSortStrings(){
        List<String> actualNames = new ArrayList<String>(Arrays.asList("Maria", "Diego",
                "Buchecha", "Ana", "Nelson"));
        Collections.sort(actualNames);

        Assert.assertEquals(new ArrayList<>(Arrays.asList("Ana","Buchecha","Diego","Maria","Nelson")), actualNames);

    }

}
