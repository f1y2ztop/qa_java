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
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionKittensParameterizedTest {

    @Mock
    private Predator predator;

    @Mock
    private FelineInterface felineInterface;

    private int expectedKittens;

    public LionKittensParameterizedTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {10}, {100}, {1000}, {10000}
        });
    }

    @Test
    public void testGetKittensWithDifferentValues() throws Exception {
        Lion lion = new Lion("Самец", predator, felineInterface);
        when(felineInterface.getKittens()).thenReturn(expectedKittens);
        int result = lion.getKittens();

        assertEquals(expectedKittens, result);
        verify(felineInterface, times(1)).getKittens();
    }
}