import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

    @RunWith(Parameterized.class)
    public class FelineGetKittensParameterizedTest {

        private final int inputKittens;
        private final int expectedKittens;
        private final Feline feline = new Feline();

        public FelineGetKittensParameterizedTest(int inputKittens, int expectedKittens) {
            this.inputKittens = inputKittens;
            this.expectedKittens = expectedKittens;
        }

        @Parameterized.Parameters(name="Введенное значение {0}, ожидаемое значение {1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1},
                    {5, 5},
                    {0, 0},
                    {10, 10},
                    {100, 100}
            });
        }

        @Test
        public void testGetKittensWithDifferentValues() {
            int actualKittens = feline.getKittens(inputKittens);
            assertEquals("Метод getKittens должен возвращать переданное число",
                    expectedKittens, actualKittens);
        }
}
