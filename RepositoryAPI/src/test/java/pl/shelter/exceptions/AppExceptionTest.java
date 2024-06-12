package pl.shelter.exceptions;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import static org.junit.jupiter.api.Assertions.*;

class AppExceptionTest {
    public AppExceptionTest() {
    }

   // @Test
    public void testAppExcpetionMessages() {
        Locale locale = new Locale.Builder().setLanguage("en").build();
        Locale.setDefault(locale);
        AppException appException = new AppException(AppException.NOT_FOUND);
        System.out.println(appException.getMessage());
        System.out.println(appException.getLocalizedMessage());
        assertThat(appException.getLocalizedMessage(), startsWith("Not found."));
    }

    @Test
    public void testAppExcpetionMessagesPL() {
        Locale locale = new Locale.Builder().setLanguage("pl").build();
        Locale.setDefault(locale);
        AppException appException = new AppException(AppException.NOT_FOUND);
        System.out.println(appException.getMessage());
        System.out.println(appException.getLocalizedMessage());
        assertThat(appException.getLocalizedMessage(), startsWith("Nie znaleziniono."));
    }

}