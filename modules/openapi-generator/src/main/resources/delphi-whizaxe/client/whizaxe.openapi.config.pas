unit whizaxe.openapi.config;

interface

uses
  Generics.Collections,
  REST.Client;

type
  TOpenApiSecurityType = (Basic, Bearer, ApiKey, OpenId, OAuth2);

  TOpenApiConfig = class
  public
    secutityType: TOpenApiSecurityType;
    basePath: string;
  end;

implementation


end.
