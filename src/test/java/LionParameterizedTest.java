import com.example.FelineInterface;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Predator predator;

    @Mock
    private FelineInterface felineInterface;

    private String sex;
    private boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveManeForDifferentSex() throws Exception {
        Lion lion = new Lion(sex, predator, felineInterface);
        boolean result = lion.doesHaveMane();

        assertEquals("Для пола '" + sex + "' грива должна быть: " + expectedHasMane,
                expectedHasMane, result);
    }
}
