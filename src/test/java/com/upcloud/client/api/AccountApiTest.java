/*
 * Upcloud api
 * The UpCloud API consists of operations used to control resources on UpCloud. The API is a web service interface. HTTPS is used to connect to the API. The API follows the principles of a RESTful web service wherever possible. The base URL for all API operations is  https://api.upcloud.com/. All API operations require authentication.
 *
 * OpenAPI spec version: 1.2.0
 * 
 */

package com.upcloud.client.api;

import com.upcloud.client.ApiException;
import com.upcloud.client.models.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * API tests for AccountApi
 */
public class AccountApiTest {

    private final static AccountApi api = new AccountApi();

    @BeforeAll
    public static void setUp() {
        Logger.getGlobal().info("Base path: " + api.getApiClient().getBasePath());
        api.getApiClient().setUsername("toughbyte");
        api.getApiClient().setPassword("Topsekret5");
//        api.getApiClient().setBasePath("http://localhost:8080/1.2");
    }

    /**
     * Account information
     * <p>
     * Returns information on the user&#39;s account.
     *
     * @throws ApiException *          if the Api call fails
     */
    @Test
    public void getAccountTest() throws ApiException {
        Account response = api.getAccount().getAccount();
        assertEquals(response.getUsername(), "toughbyte");
    }
}