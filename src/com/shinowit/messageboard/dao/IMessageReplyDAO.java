package com.shinowit.messageboard.dao;

import java.util.List;

import com.shinowit.messageboard.model.MessageReply;

public interface IMessageReplyDAO {
	   public List<MessageReply> queryForReplyByMsgId(int msg_id);
}
