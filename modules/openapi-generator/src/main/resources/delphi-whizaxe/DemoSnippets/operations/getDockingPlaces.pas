var
  item: TDockingPlaceState;
begin
  result := TObjectList<ApiModel.DockingPlaceState.TDockingPlaceState>.Create(true);

  item := TDockingPlaceState.Create;
  item.idDockingPlace := 1;
  item.dpNo := 1;
  item.dpDescr := 'MD-1';
  item.active := true;
  item.dpState := TDpState.evEMPTY;
  result.Add(item);

  item := TDockingPlaceState.Create;
  item.idDockingPlace := 2;
  item.dpNo := 2;
  item.dpDescr := 'MD-2';
  item.active := true;
  item.dpState := TDpState.evCONNECTED;
  item.plateNo := 'KR 1234AB';
  item.capacity := 480;
  result.Add(item);

  item := TDockingPlaceState.Create;
  item.idDockingPlace := 3;
  item.dpNo := 3;
  item.dpDescr := 'MD-3';
  item.active := true;
  item.dpState := TDpState.evTO_RETURN;
  item.plateNo := 'KR 5SW123';
  item.capacity := 540;
  result.Add(item);
end;

