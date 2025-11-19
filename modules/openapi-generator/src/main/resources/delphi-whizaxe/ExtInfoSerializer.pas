unit ExtInfoSerializer;

interface

uses
  System.SysUtils, System.Classes, System.Rtti, System.TypInfo,
  System.Generics.Collections, System.JSON,

  Neon.Core.Types,
  Neon.Core.Attributes,
  Neon.Core.Persistence;

type
  TExtInfoSerializer = class(TCustomSerializer)
  protected
    class function GetTargetInfo: PTypeInfo; override;
    class function CanHandle(AType: PTypeInfo): Boolean; override;
  public
    function Serialize(const AValue: TValue; ANeonObject: TNeonRttiObject; AContext: ISerializerContext)
      : TJSONValue; override;
    function Deserialize(AValue: TJSONValue; const AData: TValue; ANeonObject: TNeonRttiObject;
      AContext: IDeserializerContext): TValue; override;
  end;

implementation

uses
  whizaxe.ExtInfo,
  Neon.Core.Utils;

{ TExtInfoSerializer }

class function TExtInfoSerializer.CanHandle(AType: PTypeInfo): Boolean;
begin
  Result := TypeInfoIs(AType);
end;

class function TExtInfoSerializer.GetTargetInfo: PTypeInfo;
begin
  Result := TExtInfo.ClassInfo;
end;

function TExtInfoSerializer.Serialize(const AValue: TValue; ANeonObject: TNeonRttiObject; AContext: ISerializerContext)
  : TJSONValue;
begin
  Result := TJSONObject.ParseJSONValue(AValue.AsType<TExtInfo>.AsString);
end;

function TExtInfoSerializer.Deserialize(AValue: TJSONValue; const AData: TValue; ANeonObject: TNeonRttiObject;
  AContext: IDeserializerContext): TValue;
begin
  Result := TExtInfo.CreateFromJson(AValue.ToString);
end;

end.