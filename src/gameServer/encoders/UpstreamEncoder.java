package gameServer.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.Base64;

/**
 * Created by dan on 13.5.15.
 */
public class UpstreamEncoder implements Encoder.Text<String> {
    @Override
    public String encode(String s) throws EncodeException {
        return s;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
