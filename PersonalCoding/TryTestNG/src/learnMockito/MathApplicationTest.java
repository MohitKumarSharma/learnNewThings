package learnMockito;

import static org.testng.Assert.assertEquals;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MathApplicationTest {
	// Spy is the same exactly by called on actual object.
	@Mock
	CalculatorService calService;
	
	@InjectMocks
	MathApplication mathApplication;
	
	@Captor
	ArgumentCaptor<Integer> captor;
	
	@BeforeClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void add() {
		Mockito.when(calService.add(10, 5)).thenReturn(15);
		
		assertEquals(mathApplication.add(10, 5), 15);
	}
	
	@Test
	public void testAddThroughAnonymousClass() {
		Mockito.reset(calService); // explain reset
		
		Mockito.doAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				Object args[] = invocation.getArguments();
				
				if (args.length < 2) {
					return -1;
				}
				
				int a = (int) args[0];
				int b = (int) args[1];
				return a + b;
			}
		}).when(calService).add(Mockito.anyInt(), Mockito.anyInt());
		// explain argument matcher/ means bases on class. must be all same
		
		
		assertEquals(mathApplication.add(45, 26), 71);
		assertEquals(mathApplication.add(40, 26), 66);

		// There are multiple methods of verification. like atleast or max etc with verification mode.
		Mockito.verify(calService, Mockito.times(2)).add(captor.capture(), captor.capture());
		
		System.out.println("Arguement collected " + captor.getAllValues());
	}
	
	@Test(expectedExceptions= {RuntimeException.class})
	public void testAddException() {
		Mockito.doThrow(new RuntimeException()).when(calService.add(0, 0));
		
		assertEquals(mathApplication.add(0, 0), 0);
	}
}
