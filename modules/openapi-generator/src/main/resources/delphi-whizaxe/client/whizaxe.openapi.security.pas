unit whizaxe.openapi.security;

interface

uses
  System.SysUtils,
  Generics.Collections,
  REST.Client,
  REST.Authenticator.OAuth;

type
  IOpenApiSecurity = interface
  ['{B8133263-1953-41C1-8468-7749EA11B886}']
    function CreateAuthenticator: TCustomAuthenticator;
  end;

  TApiKey = class
  public
    type TLocation = (header, query, cookie);
  public
    locaction: TLocation;
    name: string;
    value: string;
  end;

  TApiKeyList = class(TObjectList<TApiKey>)
  public
    constructor Create; reintroduce;
  end;

  TOpenApiSecurityBasic = class(TInterfacedObject, IOpenApiSecurity)
  protected
    FUsername: string;
    FPassword: string;
  public
    constructor Create(const AUsername, aPassword: string);
    function CreateAuthenticator: TCustomAuthenticator;
  end;

  TOpenApiSecurityBearer = class(TInterfacedObject, IOpenApiSecurity)
  protected
    FToken: string;
    FOnTokenRefresh: TFunc<string>;
  public
    constructor Create(const AToken: string; AOnTokenRefresh: TFunc<string>);
    function CreateAuthenticator: TCustomAuthenticator;
  end;

  TOpenApiSecurityApiKeys = class(TInterfacedObject, IOpenApiSecurity)
  protected
    FApiKeys: TApiKeyList;
    FOnRefresh: TFunc<TApiKeyList>;
  public
    constructor Create(const AApiKeys: TApiKeyList; AOnRefresh: TFunc<TApiKeyList>);
    function CreateAuthenticator: TCustomAuthenticator;
  end;

  TOpenApiSecurityOAuth2 = class(TInterfacedObject, IOpenApiSecurity)
  protected
    FOauth2: TOAuth2Authenticator;
    FAfterCreate: TProc;
  public
    constructor Create(const AAfterCreate: TProc = nil);
    function CreateAuthenticator: TCustomAuthenticator;

    property OAuth2: TOAuth2Authenticator read FOauth2;
  end;

  TOpenApiSecurityOpenId = class(TInterfacedObject, IOpenApiSecurity)
  protected
  public
    constructor Create();
    function CreateAuthenticator: TCustomAuthenticator;
  end;

implementation

uses
  rest.Authenticator.Basic;

{ TOpenApiSecurityBasic }

constructor TOpenApiSecurityBasic.Create(const AUsername, aPassword: string);
begin
  FUsername := AUsername;
  FPassword := APassword;
end;

function TOpenApiSecurityBasic.CreateAuthenticator: TCustomAuthenticator;
begin
  result := THTTPBasicAuthenticator.Create(FUsername, FPassword);
end;

{ TOpenApiSecurityBearer }

constructor TOpenApiSecurityBearer.Create(const AToken: string; AOnTokenRefresh: TFunc<string>);
begin
  FToken := AToken;
  FOnTokenRefresh := AOnTokenRefresh;
end;

function TOpenApiSecurityBearer.CreateAuthenticator: TCustomAuthenticator;
begin
  result := TOAuth2Authenticator.Create(nil);
  TOAuth2Authenticator(result).TokenType := TOAuth2TokenType.ttBEARER;
  TOAuth2Authenticator(result).AccessToken := FToken;
end;

{ TOpenApiSecurityApiKeys }

constructor TOpenApiSecurityApiKeys.Create(const AApiKeys: TApiKeyList; AOnRefresh: TFunc<TApiKeyList>);
begin
  FApiKeys := AApiKeys;
  FOnRefresh := AOnRefresh;
end;

function TOpenApiSecurityApiKeys.CreateAuthenticator: TCustomAuthenticator;
begin
  TOAuth2Authenticator(result).TokenType := TOAuth2TokenType.ttBEARER;
//  TOAuth2Authenticator(result).AccessToken := ;

end;

{ TOpenApiSecurityOAuth2 }

constructor TOpenApiSecurityOAuth2.Create(const AAfterCreate: TProc);
begin

end;

function TOpenApiSecurityOAuth2.CreateAuthenticator: TCustomAuthenticator;
begin

end;

{ TOpenApiSecurityOpenId }

constructor TOpenApiSecurityOpenId.Create;
begin

end;

function TOpenApiSecurityOpenId.CreateAuthenticator: TCustomAuthenticator;
begin

end;

{ TApiKeyList }

constructor TApiKeyList.Create;
begin
  inherited Create(true);
end;

end.
