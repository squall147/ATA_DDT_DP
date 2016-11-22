package tests.ddt.redundancy;

import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

/**
 * Created by Robert_Kaszubowski on 11/22/2016.
 */
public class RegistrationDataTestConverter extends AbstractConverter<RegistrationTestData> {

    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMAIL = "email";
    private static final String ADDRESS_1 = "address1";
    private static final String ADDRESS_2 = "address2";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIP_CODE = "zipCode";
    private static final String COUNTRY = "country";

    @Override
    public RegistrationTestData convert(Map<String, Object> convertFrom) {
        if (convertFrom == null) {
            throw new IllegalArgumentException("Can't convert from not existing map");
        }

        RegistrationTestData registrationTestData = new RegistrationTestData();

        registrationTestData.setUserName((String) convertFrom.get(USERNAME));
        registrationTestData.setPassword((String) convertFrom.get(PASSWORD));
        registrationTestData.setFirstName((String) convertFrom.get(FIRST_NAME));
        registrationTestData.setLastName((String) convertFrom.get(LAST_NAME));
        registrationTestData.setPhoneNumber((String) convertFrom.get(PHONE_NUMBER));
        registrationTestData.setEmail((String) convertFrom.get(EMAIL));
        registrationTestData.setAddress1((String) convertFrom.get(ADDRESS_1));
        registrationTestData.setAddress2((String) convertFrom.get(ADDRESS_2));
        registrationTestData.setCity((String) convertFrom.get(CITY));
        registrationTestData.setState((String) convertFrom.get(STATE));
        registrationTestData.setZipCode((String) convertFrom.get(ZIP_CODE));
        registrationTestData.setCountry((String) convertFrom.get(COUNTRY));

        return registrationTestData;
    }
}
