import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){
        return Stream.of(
                // TODO: return Stream
                // pass
                arguments(new int[]{5, 8, 3, 2}, new int[]{2, 3, 5, 8}),
                // fail
                // arguments(new int[]{6, 9, 4, 3}, new int[]{2, 3, 5, 8}),
                arguments(new int[]{3, -1, 7}, new int[]{-1, 3, 7}),
                arguments(new int[]{9, 4, -5, 1, 0}, new int[]{-5, 0, 1, 4, 9}),
                arguments(new int[]{4, -8, 5, 9, -2, 0}, new int[]{-8, -2, 0, 4, 5, 9}),
                arguments(new int[]{-7, 1, 4, 0, 2}, new int[]{-7, 0, 1, 2, 4})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //TODO: random_array add to PriorityQueue
        for(index = 0; index<random_array.length; index++){
            s = random_array[index];
            test.add(s);
        }

        //TODO: get PriorityQueue result
        for(index = 0; index<random_array.length; index++){
            s = test.poll();
            result[index] = s;
        }

        assertArrayEquals(correct_array, result);
    }

    //TODO: 3 unique Exception
    @Test
    public void whenExceptionThrown_thenInitialCapacityLessThanOne(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(0);
        });
    }
    @Test
    public void whenExceptionThrown_thenAnyOfElementsIsNull(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenNoElementsCanRemove(){
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.remove();
        });
    }
}