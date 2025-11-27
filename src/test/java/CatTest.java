import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
    cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
       String sound = cat.getSound();
       assertEquals("Кошка должна говорить 'Мяу'", "Мяу", sound);
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        cat.getFood();
        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodReturnsCorrectValue() throws Exception {
        List<String> expectedFood = List.of("Корм", "Молоко");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals("Метод getFood должен возвращать еду от Feline",
                expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка питания"));
        cat.getFood();
    }

    @Test
    public void testCatConstructorCreatesObject() {
        assertNotNull("Конструктор Cat должен создавать объект", cat);
    }
}