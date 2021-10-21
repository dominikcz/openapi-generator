begin
  if basketId <> '1' then
    raise EWxRestBusinessLogicException.Create('Basket Id nie jest jeden', TErrorCodes.AsString(evCE_UNKNOWN_PLU) );
end;