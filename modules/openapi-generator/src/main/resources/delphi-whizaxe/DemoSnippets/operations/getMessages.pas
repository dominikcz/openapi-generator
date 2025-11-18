var
  msg: TMessageModel;
begin
  msg := TMessageModel.Create;
  msg.IdExternal := 'EXT-12345';
  msg.MessageType := TMessageType.evINFO;
  msg.DtFrom := Now - 1;
  msg.DtTo := Now + 1;
  msg.IdSender := 'sender-001';
  msg.OriginPosNo := 1;
  msg.Captcha := 'ABC123';
  msg.IdMessage := 'MSG-67890';
  msg.PosNo := 2;
  msg.Status := TMessageStatus.evreceived;
  msg.Model := TExtInfo.create;
  msg.Model.S['aqq'] := 'qqrq';

  result := ApiCSP2Model.MessagesList.TMessagesList.Create;
  result.Add(msg);
end;