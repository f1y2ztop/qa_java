import com.example.FelineInterface;
import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Mock
    private FelineInterface felineInterface;

    @Mock
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", predator, felineInterface);
    }

    @Test
    public void testGetKittens() {
        when(felineInterface.getKittens()).thenReturn(2);
        int amount = lion.getKittens();

        assertEquals(2, amount);
        verify(felineInterface, times(1)).getKittens();
    }

    @Test
    public void testDoesHaveManeForMale() throws Exception {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion femaleLion = new Lion("Самка", predator, felineInterface);
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птица", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        List<String> result = lion.eatMeat();

        assertEquals("Метод eatMeat должен возвращать еду из Predator", expectedFood, result);
        verify(predator, times(1)).eatMeat();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Птицы");
        when(predator.eatMeat()).thenReturn(expectedFood);
        List<String> result = lion.getFood();

        assertEquals(expectedFood, result);
        verify(predator, times(1)).eatMeat();
    }

    @Test
    public void testLionConstructorExceptionMessage() {
        try {
            new Lion("Неизвестный", predator, felineInterface);
            fail("Ожидалось исключение при неверном поле животного");
        } catch (Exception e) {
            assertEquals("Сообщение об ошибке должно быть корректным",
                    "Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }
}

