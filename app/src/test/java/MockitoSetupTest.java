import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.List;



class MockitoSetupTest {

    @Test
    void testMockito() {
        // Create a mock list
        List<String> mockList = Mockito.mock(List.class);

        // Define behavior
        when(mockList.get(0)).thenReturn("Hello, Mockito!");

        // Verify behavior
        assert "Hello, Mockito!".equals(mockList.get(0));
        verify(mockList).get(0);
    }
}
