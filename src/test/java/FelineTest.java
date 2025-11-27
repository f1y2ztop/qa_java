import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Метод eatMeat должен возвращать пищу для хищников",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnsFeline() {
        String family = feline.getFamily();
        assertEquals("Метод getFamily должен возвращать 'Кошачьи'",
                "Кошачьи", family);
    }

    @Test
    public void testGetKittensWithoutParametersReturnsOne() {
        int kittensCount = feline.getKittens();
        assertEquals("Метод getKittens без параметров должен возвращать 1",
                1, kittensCount);
    }

    @Test
    public void testGetKittensWithParameterReturnsSameNumber() {
        int expectedCount = 5;
        int actualCount = feline.getKittens(expectedCount);
        assertEquals("Метод getKittens с параметром должен возвращать переданное число",
                expectedCount, actualCount);
    }

    @Test
    public void testGetKittensWithZeroReturnsZero() {
        int kittensCount = feline.getKittens(0);
        assertEquals("Метод getKittens с параметром 0 должен возвращать 0",
                0, kittensCount);
    }
}

