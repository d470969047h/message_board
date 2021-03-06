USE [message_board]
GO
/****** Object:  Table [dbo].[sex_types]    Script Date: 09/01/2014 23:39:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sex_types](
	[sex_type_code] [int] NOT NULL,
	[sex_type_name] [varchar](50) NULL,
 CONSTRAINT [PK_SEX_TYPES] PRIMARY KEY CLUSTERED 
(
	[sex_type_code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'性别分类表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sex_types'
GO
/****** Object:  Table [dbo].[userinfo]    Script Date: 09/01/2014 23:39:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userinfo](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[sex_type_code] [int] NULL,
	[login_name] [varchar](50) NOT NULL,
	[login_pass] [varchar](50) NOT NULL,
	[pass_question] [varchar](200) NULL,
	[pass_ques_answer] [varchar](200) NULL,
	[birthday] [smalldatetime] NULL,
	[nick_name] [varchar](30) NULL,
	[ques_email_addr] [varchar](50) NULL,
	[pic] [varchar](500) NULL,
 CONSTRAINT [PK_USERINFO] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户信息表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'userinfo'
GO
/****** Object:  Table [dbo].[message]    Script Date: 09/01/2014 23:39:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[message](
	[msg_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[post_time] [datetime] NULL,
	[msg_content] [varchar](2000) NULL,
 CONSTRAINT [PK_MESSAGE] PRIMARY KEY CLUSTERED 
(
	[msg_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'留言信息表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'message'
GO
/****** Object:  Table [dbo].[reply_msg]    Script Date: 09/01/2014 23:39:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[reply_msg](
	[reply_msg_id] [int] IDENTITY(1,1) NOT NULL,
	[msg_id] [int] NULL,
	[user_id] [int] NULL,
	[reply_time] [datetime] NULL,
	[reply_content] [varchar](2000) NULL,
 CONSTRAINT [PK_REPLY_MSG] PRIMARY KEY CLUSTERED 
(
	[reply_msg_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'回复信息表' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'reply_msg'
GO
/****** Object:  ForeignKey [FK_MESSAGE_REFERENCE_USERINFO]    Script Date: 09/01/2014 23:39:43 ******/
ALTER TABLE [dbo].[message]  WITH CHECK ADD  CONSTRAINT [FK_MESSAGE_REFERENCE_USERINFO] FOREIGN KEY([user_id])
REFERENCES [dbo].[userinfo] ([user_id])
GO
ALTER TABLE [dbo].[message] CHECK CONSTRAINT [FK_MESSAGE_REFERENCE_USERINFO]
GO
/****** Object:  ForeignKey [FK_REPLY_MS_REFERENCE_MESSAGE]    Script Date: 09/01/2014 23:39:43 ******/
ALTER TABLE [dbo].[reply_msg]  WITH CHECK ADD  CONSTRAINT [FK_REPLY_MS_REFERENCE_MESSAGE] FOREIGN KEY([msg_id])
REFERENCES [dbo].[message] ([msg_id])
GO
ALTER TABLE [dbo].[reply_msg] CHECK CONSTRAINT [FK_REPLY_MS_REFERENCE_MESSAGE]
GO
/****** Object:  ForeignKey [FK_REPLY_MS_REFERENCE_USERINFO]    Script Date: 09/01/2014 23:39:43 ******/
ALTER TABLE [dbo].[reply_msg]  WITH CHECK ADD  CONSTRAINT [FK_REPLY_MS_REFERENCE_USERINFO] FOREIGN KEY([user_id])
REFERENCES [dbo].[userinfo] ([user_id])
GO
ALTER TABLE [dbo].[reply_msg] CHECK CONSTRAINT [FK_REPLY_MS_REFERENCE_USERINFO]
GO
/****** Object:  ForeignKey [FK_USERINFO_REFERENCE_SEX_TYPE]    Script Date: 09/01/2014 23:39:43 ******/
ALTER TABLE [dbo].[userinfo]  WITH CHECK ADD  CONSTRAINT [FK_USERINFO_REFERENCE_SEX_TYPE] FOREIGN KEY([sex_type_code])
REFERENCES [dbo].[sex_types] ([sex_type_code])
GO
ALTER TABLE [dbo].[userinfo] CHECK CONSTRAINT [FK_USERINFO_REFERENCE_SEX_TYPE]
GO
