unit Model.ExtInfo;

interface

type
  TExtInfo = class
  public
    function Validate(out AErrorMsg: string): boolean;

  end;

implementation

{ TExtInfo }

function TExtInfo.Validate(out AErrorMsg: string): boolean;
begin
  Result := True;
  AErrorMsg := '';
end;

end.