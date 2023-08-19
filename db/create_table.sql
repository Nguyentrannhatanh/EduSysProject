create database EduSys
use EduSys
create table NhanVien
(
MaNV nvarchar(50) not null,
MatKhau nvarchar(50) not null,
HoTen nvarchar(50) not null,
VaiTro Bit not null,
Primary Key(MaNV)
)
create table ChuyenDe
(
MaCD nchar(5) not null,
TenCD nvarchar(50) not null,
HocPhi Float not null,
ThoiLuong Int not null,
Hinh nvarchar(50) not null,
MoTa nvarchar(255) not null,
primary key(MaCD)
)
create table KhoaHoc
(
MaKH Int identity(1,1) not null,
MaCD nchar(5) not null,
HocPhi Float not null,
ThoiLuong Int not null,
NgayKG Date not null,
GhiChu nvarchar(50) null,
MaNV nvarchar(50) not null,
NgayTao Date not null,
primary key(MaKH),
Foreign key(MaCD) References ChuyenDe(MaCD) on Delete no action on update cascade,
Foreign key(MaNV) References NhanVien(MaNV) on Delete no action on update cascade
)
create table NguoiHoc
(
MaNH nchar(7) not null,
HoTen nvarchar(50) not null,
NgaySinh Date not null,
GioiTinh Bit not null,
DienThoai nvarchar(50) not null,
Email nvarchar(50) not null,
GhiChu nvarchar(max)null,
MaNV nvarchar(50) not null,
NgayDK Date not null,
primary key(MaNH),
foreign key(MaNV) references NhanVien(MaNV) on Delete no action on update cascade
)
create table HocVien
(
MaHV int identity(1,1) not null,
MaKH int not null,
MaNH nchar(7) not null,
Diem float not null,
primary key(MaHV),
foreign key(MaNH) references NguoiHoc(MaNH) on delete no action on update cascade,
foreign key(MaKH) references KhoaHoc(MaKH) 
)
create table MonHoc
(
MaMH nvarchar(50) not null,
TenMon nvarchar(100),
ThoiLuong int not null,
MoTa nvarchar(50),
primary key(MaMH),
)
SET IDENTITY_INSERT MonHoc on
insert into MonHoc(MaMH, TenMon, ThoiLuong, MoTa)values
('JAV01',N'Lập Trình java','300',N'Không'),
('JAV02',N'Lập Trình java2','300',N'Không'),
('JAV04',N'Dự Án Mẫu','300',N'Không'),
('JAV05',N'Cơ Sở Dữ Liệu','100',N'Không')
select * from MonHoc;
insert into NhanVien(MaNV, MatKhau, HoTen, VaiTro)values
('NoPT','123456','Phạm Thin Nở','1' ),
('PheoNC','123456','Nguyễn Chí Phèo','1' ),
('NamNV','123456','Nguyễn Văn Nam','2' )
select * from NhanVien where  MatKhau = '123456';
insert into ChuyenDe(MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa)values
('JAV01','Lập Trình java','300','90','Game.png','Không'),
('JAV02','Lập Trình java','300','90','HTCS.jpg','Không'),
('JAV03','Lập Trình mạng','200','70','INMA.jpg','Không'),
('PRO01','Dự Án Với Windown','300','90','LAYO.jpg','Không'),
('RDB01','Cơ Sở Dữ Liệu','100','50','MOWE.png','Không')
select * from ChuyenDe;
insert into KhoaHoc(MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao)values
(1,'JAV01','300','90','1/10/2018','Không','NamNV','12/31/2017'),
(2,'JAV02','300','90','1/10/2018','Không','NamNV','12/31/2017'),
(3,'PRO01','300','90','1/10/2018','Không','NamNV','12/31/2017'),
(4,'RDB01','100','50','1/10/2018','Không','NamNV','12/31/2017')
SET IDENTITY_INSERT KhoaHoc off
select * from KhoaHoc;
insert into NguoiHoc(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK)values
('PS0456','Nguyễn Văn B','2003/1/5',1,'03421312782','PS0456bnvb@fpt.edu.vn','Không','PheoNC','2018/9/2'),
('PS0789','Phạm Thị N','2003/2/2',2,'03887652424','PS0789nptn@fpt.edu.vn','Không','NamNV','2018/3/1'),
('PS0112','Phạm Ngọc T','2003/8/9',2,'05678456727','PS0112@fpt.edu.vn','Không','NamNV','2018/6/2'),
('PS0123','Nguyễn Văn A','2003/10/1',1,'0355798291','PS0123anva@fpt.edu.vn','Không','PheoNC','2018/5/1')
select * from NguoiHoc;
insert into HocVien(MaHV, MaKH, MaNH, Diem)values
(1,1,'PS0123',9),
(2,3,'PS0112',8),
(3,2,'PS0456',6.5),
(4,4,'PS0789',9)
SET IDENTITY_INSERT HocVien on
select * from HocVien
1