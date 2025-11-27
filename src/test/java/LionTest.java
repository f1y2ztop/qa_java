import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        maleLion = new Lion("Самец", feline);
        femaleLion = new Lion("Самка", feline);
    }
    @Test
    public void testMaleLionHasMane() {
        assertTrue("Самец льва должен иметь гриву", maleLion.doesHaveMane());
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() {
        assertFalse("Самка льва не должна иметь гриву", femaleLion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный", feline);
    }

    @Test
    public void testGetKittensCallsFelineGetKittens() {
        maleLion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        int kittens = maleLion.getKittens();
        assertEquals("Метод getKittens должен возвращать значение от Feline",
                3, kittens);
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        femaleLion.getFood();
        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodReturnsCorrectValue() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = femaleLion.getFood();
        assertEquals("Метод getFood должен возвращать еду от Feline",
                expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));
        maleLion.getFood();
    }
}