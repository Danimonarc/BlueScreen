USE [master]
GO
/****** Object:  Database [BlueCoes]    Script Date: 08-Jan-19 5:31:08 PM ******/
CREATE DATABASE [BlueCoes]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BlueCoes', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\BlueCoes.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BlueCoes_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\BlueCoes_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [BlueCoes] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BlueCoes].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BlueCoes] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BlueCoes] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BlueCoes] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BlueCoes] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BlueCoes] SET ARITHABORT OFF 
GO
ALTER DATABASE [BlueCoes] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BlueCoes] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BlueCoes] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BlueCoes] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BlueCoes] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BlueCoes] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BlueCoes] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BlueCoes] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BlueCoes] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BlueCoes] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BlueCoes] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BlueCoes] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BlueCoes] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BlueCoes] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BlueCoes] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BlueCoes] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BlueCoes] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BlueCoes] SET RECOVERY FULL 
GO
ALTER DATABASE [BlueCoes] SET  MULTI_USER 
GO
ALTER DATABASE [BlueCoes] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BlueCoes] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BlueCoes] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BlueCoes] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BlueCoes] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'BlueCoes', N'ON'
GO
ALTER DATABASE [BlueCoes] SET QUERY_STORE = OFF
GO
USE [BlueCoes]
GO
/****** Object:  Table [dbo].[apadrinamiento]    Script Date: 08-Jan-19 5:31:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[apadrinamiento](
	[beneficiario_persona_id] [int] NOT NULL,
	[socio_persona_id] [int] NOT NULL,
	[sede_proyecto_id] [int] NOT NULL,
 CONSTRAINT [primary] PRIMARY KEY CLUSTERED 
(
	[beneficiario_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[beneficiario]    Script Date: 08-Jan-19 5:31:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[beneficiario](
	[persona_id] [int] NOT NULL,
	[proyecto_id] [int] NOT NULL,
	[coordinador_persona_id] [int] NOT NULL,
	[fechaaltaproyecto] [date] NULL,
	[fechabajaproyecto] [date] NULL,
	[beca] [varchar](50) NULL,
	[notacurso] [real] NULL,
	[comunidadnacimiento] [varchar](50) NULL,
	[comunidadresidencia] [varchar](50) NULL,
 CONSTRAINT [primary1] PRIMARY KEY CLUSTERED 
(
	[persona_id] ASC,
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cartas]    Script Date: 08-Jan-19 5:31:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cartas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [date] NOT NULL,
	[apadrinamiento_beneficiario_persona_id] [int] NOT NULL,
 CONSTRAINT [primary2] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[apadrinamiento_beneficiario_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[coordinador]    Script Date: 08-Jan-19 5:31:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[coordinador](
	[persona_id] [int] NOT NULL,
	[proyecto_id] [int] NOT NULL,
	[nivelpermisos] [int] NOT NULL,
	[posicion] [varchar](50) NOT NULL,
	[telefono] [varchar](20) NULL,
	[direccion] [varchar](200) NULL,
 CONSTRAINT [primary3] PRIMARY KEY CLUSTERED 
(
	[persona_id] ASC,
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[egreso]    Script Date: 08-Jan-19 5:31:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[egreso](
	[movimiento_id] [int] NOT NULL,
	[beneficiario_persona_id] [int] NOT NULL,
	[nombrebeneficiario] [varchar](50) NULL,
 CONSTRAINT [primary4] PRIMARY KEY CLUSTERED 
(
	[movimiento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ingreso]    Script Date: 08-Jan-19 5:31:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ingreso](
	[movimiento_id] [int] NOT NULL,
	[procedencia] [varchar](50) NOT NULL,
 CONSTRAINT [primary5] PRIMARY KEY CLUSTERED 
(
	[movimiento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movimiento]    Script Date: 08-Jan-19 5:31:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movimiento](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[proyecto_id] [int] NOT NULL,
	[fecha] [date] NOT NULL,
	[cantidad] [real] NOT NULL,
	[descripcion] [varchar](100) NULL,
 CONSTRAINT [primary6] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[persona]    Script Date: 08-Jan-19 5:31:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persona](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[apellidos] [varchar](50) NULL,
	[sexo] [varchar](10) NOT NULL,
	[foto] [varbinary](1) NULL,
	[fechanacimiento] [date] NULL,
	[fechaalta] [date] NOT NULL,
	[fechabaja] [date] NULL,
	[comentarios] [varchar](300) NULL,
 CONSTRAINT [primary7] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[proyecto]    Script Date: 08-Jan-19 5:31:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proyecto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[localización] [varchar](200) NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [primary8] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sede]    Script Date: 08-Jan-19 5:31:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sede](
	[proyecto_id] [int] NOT NULL,
	[provincia] [varchar](50) NOT NULL,
 CONSTRAINT [primary9] PRIMARY KEY CLUSTERED 
(
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[socio]    Script Date: 08-Jan-19 5:31:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[socio](
	[persona_id] [int] NOT NULL,
	[dni] [varchar](10) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[codigopostal] [int] NOT NULL,
	[poblacion] [varchar](50) NOT NULL,
	[provincia] [varchar](50) NOT NULL,
	[direccion] [varchar](200) NOT NULL,
	[telefono] [varchar](20) NULL,
	[movil] [varchar](20) NULL,
	[certificado] [smallint] NOT NULL,
 CONSTRAINT [primary10] PRIMARY KEY CLUSTERED 
(
	[persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [fk_apadrinamiento_sede1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_apadrinamiento_sede1_idx] ON [dbo].[apadrinamiento]
(
	[sede_proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_apadrinamiento_socio1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_apadrinamiento_socio1_idx] ON [dbo].[apadrinamiento]
(
	[socio_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_beneficiario_coordinador1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_beneficiario_coordinador1_idx] ON [dbo].[beneficiario]
(
	[coordinador_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_beneficiario_proyecto1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_beneficiario_proyecto1_idx] ON [dbo].[beneficiario]
(
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [persona_id_unique]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [persona_id_unique] ON [dbo].[beneficiario]
(
	[persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_cartas_apadrinamiento1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_cartas_apadrinamiento1_idx] ON [dbo].[cartas]
(
	[apadrinamiento_beneficiario_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_coordinador_proyecto1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_coordinador_proyecto1_idx] ON [dbo].[coordinador]
(
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [persona_id_unique1]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [persona_id_unique1] ON [dbo].[coordinador]
(
	[persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_egreso_beneficiario1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_egreso_beneficiario1_idx] ON [dbo].[egreso]
(
	[beneficiario_persona_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [fk_movimiento_proyecto1_idx]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE NONCLUSTERED INDEX [fk_movimiento_proyecto1_idx] ON [dbo].[movimiento]
(
	[proyecto_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [dni_unique]    Script Date: 08-Jan-19 5:31:12 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [dni_unique] ON [dbo].[socio]
(
	[dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[apadrinamiento]  WITH CHECK ADD  CONSTRAINT [beneficiario_apadrinamiento] FOREIGN KEY([beneficiario_persona_id])
REFERENCES [dbo].[beneficiario] ([persona_id])
GO
ALTER TABLE [dbo].[apadrinamiento] CHECK CONSTRAINT [beneficiario_apadrinamiento]
GO
ALTER TABLE [dbo].[apadrinamiento]  WITH CHECK ADD  CONSTRAINT [sede_apadrinamiento] FOREIGN KEY([sede_proyecto_id])
REFERENCES [dbo].[sede] ([proyecto_id])
GO
ALTER TABLE [dbo].[apadrinamiento] CHECK CONSTRAINT [sede_apadrinamiento]
GO
ALTER TABLE [dbo].[apadrinamiento]  WITH CHECK ADD  CONSTRAINT [socio_apadrinamiento] FOREIGN KEY([socio_persona_id])
REFERENCES [dbo].[socio] ([persona_id])
GO
ALTER TABLE [dbo].[apadrinamiento] CHECK CONSTRAINT [socio_apadrinamiento]
GO
ALTER TABLE [dbo].[beneficiario]  WITH CHECK ADD  CONSTRAINT [coordinador_beneficiario] FOREIGN KEY([coordinador_persona_id])
REFERENCES [dbo].[coordinador] ([persona_id])
GO
ALTER TABLE [dbo].[beneficiario] CHECK CONSTRAINT [coordinador_beneficiario]
GO
ALTER TABLE [dbo].[beneficiario]  WITH CHECK ADD  CONSTRAINT [persona_beneficiario] FOREIGN KEY([persona_id])
REFERENCES [dbo].[persona] ([id])
GO
ALTER TABLE [dbo].[beneficiario] CHECK CONSTRAINT [persona_beneficiario]
GO
ALTER TABLE [dbo].[beneficiario]  WITH CHECK ADD  CONSTRAINT [proyecto_beneficiario] FOREIGN KEY([proyecto_id])
REFERENCES [dbo].[proyecto] ([id])
GO
ALTER TABLE [dbo].[beneficiario] CHECK CONSTRAINT [proyecto_beneficiario]
GO
ALTER TABLE [dbo].[cartas]  WITH CHECK ADD  CONSTRAINT [apadrinamiento_cartas] FOREIGN KEY([apadrinamiento_beneficiario_persona_id])
REFERENCES [dbo].[apadrinamiento] ([beneficiario_persona_id])
GO
ALTER TABLE [dbo].[cartas] CHECK CONSTRAINT [apadrinamiento_cartas]
GO
ALTER TABLE [dbo].[coordinador]  WITH CHECK ADD  CONSTRAINT [persona_coordinador] FOREIGN KEY([persona_id])
REFERENCES [dbo].[persona] ([id])
GO
ALTER TABLE [dbo].[coordinador] CHECK CONSTRAINT [persona_coordinador]
GO
ALTER TABLE [dbo].[coordinador]  WITH CHECK ADD  CONSTRAINT [proyecto_coordinador] FOREIGN KEY([proyecto_id])
REFERENCES [dbo].[proyecto] ([id])
GO
ALTER TABLE [dbo].[coordinador] CHECK CONSTRAINT [proyecto_coordinador]
GO
ALTER TABLE [dbo].[egreso]  WITH CHECK ADD  CONSTRAINT [beneficiario_egreso] FOREIGN KEY([beneficiario_persona_id])
REFERENCES [dbo].[beneficiario] ([persona_id])
GO
ALTER TABLE [dbo].[egreso] CHECK CONSTRAINT [beneficiario_egreso]
GO
ALTER TABLE [dbo].[egreso]  WITH CHECK ADD  CONSTRAINT [movimiento_egreso] FOREIGN KEY([movimiento_id])
REFERENCES [dbo].[movimiento] ([id])
GO
ALTER TABLE [dbo].[egreso] CHECK CONSTRAINT [movimiento_egreso]
GO
ALTER TABLE [dbo].[ingreso]  WITH CHECK ADD  CONSTRAINT [movimiento_ingreso] FOREIGN KEY([movimiento_id])
REFERENCES [dbo].[movimiento] ([id])
GO
ALTER TABLE [dbo].[ingreso] CHECK CONSTRAINT [movimiento_ingreso]
GO
ALTER TABLE [dbo].[movimiento]  WITH CHECK ADD  CONSTRAINT [proyecto_movimiento] FOREIGN KEY([proyecto_id])
REFERENCES [dbo].[proyecto] ([id])
GO
ALTER TABLE [dbo].[movimiento] CHECK CONSTRAINT [proyecto_movimiento]
GO
ALTER TABLE [dbo].[sede]  WITH CHECK ADD  CONSTRAINT [proyecto_sede] FOREIGN KEY([proyecto_id])
REFERENCES [dbo].[proyecto] ([id])
GO
ALTER TABLE [dbo].[sede] CHECK CONSTRAINT [proyecto_sede]
GO
ALTER TABLE [dbo].[socio]  WITH CHECK ADD  CONSTRAINT [persona_socio] FOREIGN KEY([persona_id])
REFERENCES [dbo].[persona] ([id])
GO
ALTER TABLE [dbo].[socio] CHECK CONSTRAINT [persona_socio]
GO
USE [master]
GO
ALTER DATABASE [BlueCoes] SET  READ_WRITE 
GO
