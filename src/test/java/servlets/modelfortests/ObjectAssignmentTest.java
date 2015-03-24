package servlets.modelfortests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class ObjectAssignmentTest {

    private final Context context;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[] { Context.J },
                new Object[] { Context.C }
                );
    }

    public ObjectAssignmentTest(Context context) {
        this.context = context;
    }

    @Test
    public void paramTest() {
        //given
        //when
        ObjectAssignment objectAssignment = new ObjectAssignment(context);
        objectAssignment.displayContextMessage();
        //then
    }

}
