var
  lClient: TvPOSAPIClient;
  item: TBasketItemRequest;
  errorMsg: string;
begin
  lClient := getClient();
  item := TBasketItemRequest.Create;
  item.idRefuelling := 123;
  try
    lClient.addItemToBasket('1234', item, nil);
  except
    on E: Exception do
    begin
      errorMsg := E.Message;
      memo1.Lines.Add(errorMsg);
    end;
  end;
  lClient.Free;
end;
