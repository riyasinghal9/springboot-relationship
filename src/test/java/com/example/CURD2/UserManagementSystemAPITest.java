import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserManagementSystemAPITest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api"; // Replace with your API's base URL
    }

    @Test
    public void testUserRegistration() {
        
        String registrationUrl = baseUrl + "/register";
        UserRegistrationRequest registrationRequest = new UserRegistrationRequest("testuser", "password123");

        ResponseEntity<UserRegistrationResponse> response = restTemplate.postForEntity(registrationUrl, registrationRequest, UserRegistrationResponse.class);
        
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    public void testUserLogin() {
        
        String loginUrl = baseUrl + "/login";
        UserLoginRequest loginRequest = new UserLoginRequest("testuser", "password123");

        
        ResponseEntity<UserLoginResponse> response = restTemplate.postForEntity(loginUrl, loginRequest, UserLoginResponse.class);

    
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        String authToken = response.getBody().getAuthToken();
        assertNotNull(authToken);
    }
}
