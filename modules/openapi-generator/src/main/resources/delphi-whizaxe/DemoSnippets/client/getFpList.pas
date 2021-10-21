var 
  lClient: TvPOSAPIClient;
  FpList: TFpList;
begin
  lClient := getClient();
  FpList := lClient.getFpList();
  memo1.Lines.Add(FpList.AsJson);
  lClient.Free;
end;
