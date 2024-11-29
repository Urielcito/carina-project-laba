package org.laba;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.laba.carina.api.GetCurrentWeatherMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.carina.demo.api.DeleteUserMethod;
import org.example.carina.demo.api.GetUserMethods;
import org.example.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class OurAPISampleTest implements IAbstractTest{
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner="nicuri")
    public void testGetCurrentWeather() {
        GetCurrentWeatherMethod getCurrentWeatherMethod = new GetCurrentWeatherMethod();
        getCurrentWeatherMethod.callAPIExpectSuccess();
        //getCurrentWeatherMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCurrentWeatherMethod.validateResponseAgainstSchema("api/weather/_current/rs.schema");
    }

}
