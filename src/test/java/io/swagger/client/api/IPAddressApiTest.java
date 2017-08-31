/*
 * Upcloud api
 * The UpCloud API consists of operations used to control resources on UpCloud. The API is a web service interface. HTTPS is used to connect to the API. The API follows the principles of a RESTful web service wherever possible. The base URL for all API operations is  https://api.upcloud.com/. All API operations require authentication.
 *
 * OpenAPI spec version: 1.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Error;
import io.swagger.client.model.InlineResponse2006;
import io.swagger.client.model.InlineResponse2011;
import io.swagger.client.model.IpAddress;
import io.swagger.client.model.IpAddress1;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for IPAddressApi
 */
@Ignore
public class IPAddressApiTest {

    private final IPAddressApi api = new IPAddressApi();

    
    /**
     * List IP addresses
     *
     * Returns a list of all IP addresses assigned to servers on the current user account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ipAddressGetTest() throws ApiException {
        InlineResponse2006 response = api.ipAddressGet();

        // TODO: test validations
    }
    
    /**
     * Release IP address
     *
     * Removes an IP address from a server.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ipAddressIpDeleteTest() throws ApiException {
        String ip = null;
        api.ipAddressIpDelete(ip);

        // TODO: test validations
    }
    
    /**
     * Get IP address details
     *
     * Returns detailed information about a specific IP address.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ipAddressIpGetTest() throws ApiException {
        String ip = null;
        InlineResponse2011 response = api.ipAddressIpGet(ip);

        // TODO: test validations
    }
    
    /**
     * Modify IP address
     *
     * Modifies the reverse DNS PTR record corresponding to an IP address. The PTR record can only be set to public IP address.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ipAddressIpPutTest() throws ApiException {
        String ip = null;
        IpAddress1 ipAddress = null;
        InlineResponse2011 response = api.ipAddressIpPut(ip, ipAddress);

        // TODO: test validations
    }
    
    /**
     * Assign IP address
     *
     * Assigns a new IP address to a server.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void ipAddressPostTest() throws ApiException {
        IpAddress ipAddress = null;
        InlineResponse2011 response = api.ipAddressPost(ipAddress);

        // TODO: test validations
    }
    
}