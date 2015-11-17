package servlets.modelfortests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;


/*WHEN TO USE ARGUMENT CAPTOR?
Use ArgumentCaptor to ensure that this method was called and its argument was correct.*/

public class CarsBuilderTest {

    @InjectMocks
    private CarsBuilder carsBuilder;

    @Mock
    private Supplier wheelsSupplierMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void testNoOfWheelsInBuiltCar() {
        //given
        Integer numberOfWheels = 4;

        //when
        carsBuilder.buildCar();

        //then
        ArgumentCaptor<Integer> captorNoOfRequestedWheels = ArgumentCaptor.forClass(Integer.class);
        verify(wheelsSupplierMock).getElement(captorNoOfRequestedWheels.capture());
        assertEquals(numberOfWheels.intValue(), captorNoOfRequestedWheels.getValue().intValue());
    }

    @Test
    public void hashMapTest() {

        List<String> list = new ArrayList();
        list.add("Field 1");
        list.add(null);
        list.add("Field 3");
        list.add("Field 4");
        list.add("Field 5");
        list.add("Field 6");
        list.add("Field 7");
        list.add("Field 8");

        Map<Integer, String> map = new HashMap<Integer, String>();
        Integer index = 1;
        for (String field : list) {
            if(field != null) map.put(index, field);
            index++;
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer order = entry.getKey();
            String value = entry.getValue();
            System.out.println(order + " " + value);
        }
    }

}
