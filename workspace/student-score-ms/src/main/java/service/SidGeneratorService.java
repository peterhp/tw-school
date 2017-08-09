package service;

import org.springframework.stereotype.Service;

/**
 * Created by Shli on 09/08/2017.
 */
@Service
public class SidGeneratorService implements ISidGeneratorService {

    private long curMaxSid = 100;

    @Override
    public String getAvailableSid() {
        return String.format("S%d", ++curMaxSid);
    }
}
