import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionManeParameterizedTest {

    @Mock
    private Feline feline;

    private final String sex;
    private final boolean expectedHasMane;

    public LionManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name="Пол {0}, Наличие гривы {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveManeForDifferentSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean result = lion.doesHaveMane();
        assertEquals(expectedHasMane, result);
    }
}
