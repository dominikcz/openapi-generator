unit Model.ExtInfo;

interface

uses
  whizaxe.superobject,
  whizaxe.CustomAttributes;

type
  {$RTTI EXPLICIT METHODS([vcPublic])}
  TExtInfo = class(TWizaxeSuperObject)
  public
    constructor Create;
    constructor CreateFromJson(json: string); reintroduce;
    [SerializationAttribute(TSerializationBehaviour.IsSerialized)]
    function AsSerializedString: string;
    function Clone: TExtInfo;
    function IsInitalized: boolean;
    function Validate(out AErrorMsg: string): boolean;
  end;

implementation

uses
  SysUtils,
  superobject;

{ TExtInfo }

function TExtInfo.AsSerializedString: string;
var
  strJson: string;
begin
  if self.wxSO = nil then
    self.wxSO := SO;
  strJson := self.wxSO.AsJSon(false, false);
  if strJson.StartsWith('{') and strJson.EndsWith('}') then
    result := strJson.Substring(1, Length(strJson) - 2) ;
end;

function TExtInfo.Clone: TExtInfo;
begin
  result := TExtInfo.CreateFromJson(wxSO.AsString);
end;

constructor TExtInfo.Create;
begin
  inherited Create;
  IgnoreCase := false;
end;

constructor TExtInfo.CreateFromJson(json: string);
begin
  wxSO := SO(json);
end;

function TExtInfo.IsInitalized: boolean;
begin
  Result := wxSO <> nil;
end;

function TExtInfo.Validate(out AErrorMsg: string): boolean;
begin
  Result := True;
  AErrorMsg := '';
end;


end.