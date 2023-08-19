package Entity;

import org.junit.Test;

import DAO.NguoiHocDAO;

public class TestNH {
	@Test(expected = Exception.class)
	public void testInsertValid() {
		NguoiHoc model = new NguoiHoc();
		model.setDienThoai(null);
		model.setEmail(null);
		model.setGhiChu(null);
		model.isGioiTinh();
		model.setHoTen(null);
		model.setMaNH(null);
		model.setMaNV(null);
		model.setNgayDK(null);
		model.setNgaySinh(null);
		NguoiHocDAO kh = new NguoiHocDAO();
		kh.insert(model);
	}
}
