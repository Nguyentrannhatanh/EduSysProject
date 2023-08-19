package Entity;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import DAO.NhanVienDAO;

public class TestNV {
	@Test(expected = Exception.class)
	public void testInsertValid() {
		NhanVien model = new NhanVien();
		model.setMaNV(null);
		model.setMatKhau(null);
		model.setHoTen(null);		
		model.isVaiTro();
		
		NhanVienDAO kh = new NhanVienDAO();
		kh.insert(model);
	}
	@Test
	public void testUpdateValid() {
		NhanVien model = new NhanVien();
		model.setMatKhau("123");
		model.setHoTen("Pham Hoang Son Lam");
		model.setVaiTro (false);		
		model.setMaNV("NV01");
		
		NhanVienDAO khDao = new NhanVienDAO();
		khDao.update(model);
	}
	@Test
	public void testDeleteValid() {
		     NhanVienDAO nvDao = new NhanVienDAO();
			String manv = "NV01";
			int i = 0;
			List<NhanVien> result = nvDao.selectAll();
			for (NhanVien nhanvien : result) {
				String list = nhanvien.getMaNV();
				if(list.equalsIgnoreCase(manv)) {
					String expectedResult = list.toString();
					System.out.println(expectedResult);
					nvDao.delete(list);
					i = 1;
				}
			}
			if(i == 0) {
				fail("Lỗi");
			}
	}
}
