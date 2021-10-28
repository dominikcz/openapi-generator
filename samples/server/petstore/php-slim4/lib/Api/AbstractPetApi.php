<?php

/**
 * OpenAPI Petstore
 * PHP version 7.3
 *
 * @package OpenAPIServer
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */

/**
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */

/**
 * NOTE: This class is auto generated by the openapi generator program.
 * https://github.com/openapitools/openapi-generator
 * Do not edit the class manually.
 */
namespace OpenAPIServer\Api;

use Psr\Container\ContainerInterface;
use Psr\Http\Message\ServerRequestInterface;
use Psr\Http\Message\ResponseInterface;
use Slim\Exception\HttpNotImplementedException;

/**
 * AbstractPetApi Class Doc Comment
 *
 * @package OpenAPIServer\Api
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */
abstract class AbstractPetApi
{

    /**
     * @var ContainerInterface|null Slim app container instance
     */
    protected $container;

    /**
     * Route Controller constructor receives container
     *
     * @param ContainerInterface|null $container Slim app container instance
     */
    public function __construct(ContainerInterface $container = null)
    {
        $this->container = $container;
    }


    /**
     * POST addPet
     * Summary: Add a new pet to the store
     * Output-Formats: [application/xml, application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function addPet(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $body = $request->getParsedBody();
        $message = "How about implementing addPet as a POST method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * DELETE deletePet
     * Summary: Deletes a pet
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function deletePet(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $headers = $request->getHeaders();
        $apiKey = $request->hasHeader('api_key') ? $headers['api_key'] : null;
        $petId = $args['petId'];
        $message = "How about implementing deletePet as a DELETE method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * GET findPetsByStatus
     * Summary: Finds Pets by status
     * Notes: Multiple status values can be provided with comma separated strings
     * Output-Formats: [application/xml, application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function findPetsByStatus(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $queryParams = $request->getQueryParams();
        $status = (key_exists('status', $queryParams)) ? $queryParams['status'] : null;
        $message = "How about implementing findPetsByStatus as a GET method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * GET findPetsByTags
     * Summary: Finds Pets by tags
     * Notes: Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * Output-Formats: [application/xml, application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     * @deprecated
     */
    public function findPetsByTags(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $queryParams = $request->getQueryParams();
        $tags = (key_exists('tags', $queryParams)) ? $queryParams['tags'] : null;
        $message = "How about implementing findPetsByTags as a GET method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * GET getPetById
     * Summary: Find pet by ID
     * Notes: Returns a single pet
     * Output-Formats: [application/xml, application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function getPetById(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $petId = $args['petId'];
        $message = "How about implementing getPetById as a GET method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * PUT updatePet
     * Summary: Update an existing pet
     * Output-Formats: [application/xml, application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function updatePet(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $body = $request->getParsedBody();
        $message = "How about implementing updatePet as a PUT method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * POST updatePetWithForm
     * Summary: Updates a pet in the store with form data
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function updatePetWithForm(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $petId = $args['petId'];
        $body = $request->getParsedBody();
        $name = (isset($body['name'])) ? $body['name'] : null;
        $status = (isset($body['status'])) ? $body['status'] : null;
        $message = "How about implementing updatePetWithForm as a POST method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }

    /**
     * POST uploadFile
     * Summary: uploads an image
     * Output-Formats: [application/json]
     *
     * @param ServerRequestInterface $request  Request
     * @param ResponseInterface      $response Response
     * @param array|null             $args     Path arguments
     *
     * @return ResponseInterface
     * @throws HttpNotImplementedException to force implementation class to override this method
     */
    public function uploadFile(ServerRequestInterface $request, ResponseInterface $response, array $args)
    {
        $petId = $args['petId'];
        $body = $request->getParsedBody();
        $additionalMetadata = (isset($body['additionalMetadata'])) ? $body['additionalMetadata'] : null;
        $file = (key_exists('file', $request->getUploadedFiles())) ? $request->getUploadedFiles()['file'] : null;
        $message = "How about implementing uploadFile as a POST method in OpenAPIServer\Api\PetApi class?";
        throw new HttpNotImplementedException($request, $message);
    }
}
