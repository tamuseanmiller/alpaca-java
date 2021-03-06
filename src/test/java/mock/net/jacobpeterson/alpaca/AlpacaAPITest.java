package mock.net.jacobpeterson.alpaca;

import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.enums.api.DataAPIType;
import net.jacobpeterson.alpaca.enums.api.EndpointAPIType;
import org.junit.jupiter.api.Test;

/**
 * {@link AlpacaAPITest} tests {@link AlpacaAPI} using mocked objects with Mockito.
 */
public class AlpacaAPITest {

    static {
        // Log trace-level
        System.setProperty("org.slf4j.simpleLogger.log.net.jacobpeterson", "trace");
        System.setProperty("org.slf4j.simpleLogger.log.mock.net.jacobpeterson", "trace");
    }

    /**
     * Tests {@link AlpacaAPI#AlpacaAPI()}.
     */
    @Test
    public void testAlpacaAPIConstructor_Default() {
        new AlpacaAPI();
    }

    /**
     * Tests {@link AlpacaAPI#AlpacaAPI(String, String)}.
     */
    @Test
    public void testAlpacaAPIConstructor_keyID_secret() {
        String keyID = "ABCDEFGHIJKLM";
        String secret = "NOPQURSTUVWXYZ";

        new AlpacaAPI(keyID, secret);
    }

    /**
     * Tests {@link AlpacaAPI#AlpacaAPI(String, String, EndpointAPIType, DataAPIType)}.
     */
    @Test
    public void testAlpacaAPIConstructor_keyID_secret_endpointAPIType_dataAPIType() {
        String keyID = "ABCDEFGHIJKLM";
        String secret = "NOPQURSTUVWXYZ";

        new AlpacaAPI(keyID, secret, EndpointAPIType.PAPER, DataAPIType.IEX);
        new AlpacaAPI(keyID, secret, EndpointAPIType.LIVE, DataAPIType.SIP);
    }

    /**
     * Tests {@link AlpacaAPI#AlpacaAPI(String)}.
     */
    @Test
    public void testAlpacaAPIConstructor_oAuthToken() {
        String oAuthToken = "ABCDEFGHIJKLMNOPQURSTUVWXYZ";

        new AlpacaAPI(oAuthToken);
    }

    /**
     * Tests {@link AlpacaAPI#AlpacaAPI(String, String, String, EndpointAPIType, DataAPIType)}.
     */
    @Test
    public void testAlpacaAPIConstructor_keyID_secret_oAuthToken_endpointAPIType_dataAPIType() {
        String keyID = "ABCDEFGHIJKLM";
        String secret = "NOPQURSTUVWXYZ";
        String oAuthToken = "ABCDEFGHIJKLMNOPQURSTUVWXYZ";

        new AlpacaAPI(keyID, secret, oAuthToken, EndpointAPIType.PAPER, DataAPIType.IEX);
        new AlpacaAPI(keyID, secret, oAuthToken, EndpointAPIType.LIVE, DataAPIType.SIP);
    }
}
