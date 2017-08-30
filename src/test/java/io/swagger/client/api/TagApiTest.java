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
import io.swagger.client.model.InlineResponse20010;
import io.swagger.client.model.InlineResponse2009;
import io.swagger.client.model.ServerListResponse;
import io.swagger.client.model.Tag;
import io.swagger.client.model.Tag1;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TagApi
 */
@Ignore
public class TagApiTest {

    private final TagApi api = new TagApi();

    
    /**
     * Assign tag to a server
     *
     * Servers can be tagged with one or more tags. The tags used must exist
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void serverServerIdTagTagListPostTest() throws ApiException {
        UUID serverId = null;
        String tagList = null;
        ServerListResponse response = api.serverServerIdTagTagListPost(serverId, tagList);

        // TODO: test validations
    }
    
    /**
     * Remove tag from server
     *
     * Untags tags from given server. The tag(s) must exist
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void serverServerIdUntagTagNamePostTest() throws ApiException {
        UUID serverId = null;
        String tagName = null;
        ServerListResponse response = api.serverServerIdUntagTagNamePost(serverId, tagName);

        // TODO: test validations
    }
    
    /**
     * List existing tags
     *
     * Returns all existing tags with their properties and servers tagged
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagGetTest() throws ApiException {
        InlineResponse2009 response = api.tagGet();

        // TODO: test validations
    }
    
    /**
     * Create a new tag
     *
     * Creates a new tag. Existing servers can be tagged in same request
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagPostTest() throws ApiException {
        Tag tag = null;
        InlineResponse20010 response = api.tagPost(tag);

        // TODO: test validations
    }
    
    /**
     * Delete tag
     *
     * Deleting existing tag untags all servers from specified tag and deletes tag definition
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagTagNameDeleteTest() throws ApiException {
        String tagName = null;
        api.tagTagNameDelete(tagName);

        // TODO: test validations
    }
    
    /**
     * Modify existing tag
     *
     * Changes attributes of an existing tag
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void tagTagNamePutTest() throws ApiException {
        String tagName = null;
        Tag1 tag = null;
        InlineResponse20010 response = api.tagTagNamePut(tagName, tag);

        // TODO: test validations
    }
    
}
