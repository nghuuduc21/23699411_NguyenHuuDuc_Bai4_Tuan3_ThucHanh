package OOP_IUH_23699411_NguyenHuuDuc;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HangThucPham {
	private String codeFood;
	private String nameFood;
	private double price;
	private String dayFrist;
	private String dayLast;
	//-----------------------------------------------------
	public String getCodeFood() {
		return codeFood;
	}
	public void setCodeFood(String codeFood) {
		// rang buoc code
		if (this.codeFood != null) {
				this.codeFood = codeFood;
		} else {
			System.out.println("Erorr");
		}
	
	}
	//-----------------------------------------------------
	public String getNameFood() {
		return nameFood;
	}
	public void setNameFood(String nameFood) {
		if (nameFood != null) {
			
		}
		else {
			System.out.println("Erorr");
		}
	}
	//--------------------------------------------------------
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Error");
		}
		
	}
	//----------------------------------------------------------------
	public String getDayFist() {
		return dayFrist;
	}
	public void setDayFist(String dayFrist) {
		if (dayFrist != null) {
			this.dayFrist = dayFrist;
		}
		else
		{
			System.out.println("Error");
		}
	}
	//-----------------------------------------------------------------
	public String getDayLast() {
		return dayLast;
	}
	public void setDayLast(String dayLast) {
		if (dayLast != null) {
			
		}else {
			System.out.println("Error");
		}
	}
	//------------------------------------------------------------------------------
	// tao constructor cho Object
	public HangThucPham(String codeFood, String nameFood, double price, String dayFrist, String dayLast) {
		this.codeFood = codeFood;
		this.nameFood = nameFood;
		this.price = price;
		this.dayFrist = dayFrist;
		this.dayLast = dayLast;
	}
	
	// basic constructor
	public HangThucPham() {}
	
	public static HangThucPham nhap() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("code: ");
		String ma = sc.nextLine();
		
		System.out.print("Ten hang thuc pham: ");
		String ten = sc.nextLine();
		
		System.out.print("Don gia: ");
		Double gia = sc.nextDouble();
		
		sc.nextLine();
		System.out.print("Ngay San Xuat: ");
		String nxs = sc.nextLine();
		
		
		System.out.print("Ngay Het Han: ");
		String exp = sc.nextLine();

		
		HangThucPham sp1 = new HangThucPham(ma,ten,gia,nxs,exp);
		sp1.chuanHoaNSX();
		sp1.chuanHoaNHH();
		sp1.chuanHoaTen();
		
		return sp1;
	}
	
	public void chuanHoaNSX() {
		StringBuilder sb = new StringBuilder(dayFrist);
		if(sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if(sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
		this.dayFrist = sb.toString();
	}
	
	public void chuanHoaNHH() {
		StringBuilder sb = new StringBuilder(dayLast);
		if(sb.charAt(1) == '/') {
			sb.insert(0, "0");
		}
		if(sb.charAt(4) == '/') {
			sb.insert(3, "0");
		}
		this.dayLast = sb.toString();
	}
	
	public String dinhDangDonGia() {
		DecimalFormat dF = new DecimalFormat("#,###.00");
		return dF.format(price);
	}
	
	public void chuanHoaTen() {
		StringBuilder sb = new StringBuilder("");
		String []arrName = this.nameFood.split("\\s+");
		for(String x : arrName) {
			sb.append(Character.toUpperCase(x.charAt(0)));
			for(int i = 1 ; i<x.length() ; i++) {
				sb.append(Character.toLowerCase(x.charAt(i)));
			}
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		this.nameFood = sb.toString();
	}
	
	@Override
	public String toString() {
		if(this.dayFrist.compareTo(dayLast) < 0) {
			return "Ma hang: " + this.codeFood + " | Ten hang: " + this.nameFood + " | Don gia: " + dinhDangDonGia() + "VND"
					+ " | Ngay san xuat: " + this.dayFrist + " | Ngay het han: " + this.dayLast;
		}else {
			return "Loi Ngay Het Han ";
		}
    }
	
	public static void main(String[] args) {
		HangThucPham sp1 = HangThucPham.nhap();
		System.out.println(sp1.toString());
		
	}
	

}
