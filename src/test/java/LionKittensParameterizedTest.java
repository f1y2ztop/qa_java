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
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionKittensParameterizedTest {

    @Mock
    private Feline feline;

    private final int expectedKittens;

    public LionKittensParameterizedTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name="Кол-во котят {0}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {10}, {100}, {1000}
        });
    }

    @Test
    public void testGetKittensWithDifferentValues() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(expectedKittens);
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }
}