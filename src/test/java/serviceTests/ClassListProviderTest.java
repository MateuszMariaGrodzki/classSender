package serviceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ClassListProvider;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ClassListProviderTest {

    @Test
    @DisplayName("test getClassNameByPackage")
    public void testGetClassNamesByPackageNameMethod() throws Exception{
        List<String> expected = Arrays.asList("Calculator","HelloWorld","Human","Point2D","Point3D");
        List<String> actual = ClassListProvider.getClassNamesByPackageName(ClassListProvider.class.getClassLoader(),
                "classRepository");
        assertIterableEquals(expected,actual);
    }

}
