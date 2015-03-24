package servlets.modelfortests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
}
