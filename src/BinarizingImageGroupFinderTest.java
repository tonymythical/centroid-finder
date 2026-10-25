import static org.junit.jupiter.api.Assertions.*;
 import java.awt.image.BufferedImage;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BinarizingImageGroupFinderTest {

    private FakeImageBinarizer fakeBinarizer;
    private FakeBinaryGroupFinder fakeGroupFinder;
    private BinarizingImageGroupFinder finder;

    private static class FakeImageBinarizer implements ImageBinarizer {

        int[][] binaryArray = {
            {1, 1, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        @Override public int[][] toBinaryArray(BufferedImage image) {
        return binaryArray;
    }
    @Override
     public BufferedImage toBufferedImage(int[][] image) {
        throw new UnsupportedOperationException("Not needed for this test");
    }
    }

    private static class FakeBinaryGroupFinder implements BinaryGroupFinder {
        int[][] receivedArray;
        List<Group> groupsToReturn = List.of();

        @Override 
        public List<Group> findConnectedGroups(int[][] image) {
            receivedArray = image;
            return groupsToReturn;
        }
    }

    
    


    @BeforeEach
   


    void setUp() {
         fakeBinarizer = new FakeImageBinarizer();
         fakeGroupFinder = new FakeBinaryGroupFinder();

         finder = new BinarizingImageGroupFinder(fakeBinarizer, fakeGroupFinder);

        
    }

    @Test
    

    
}
