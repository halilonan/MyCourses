package tr.edu.medipol.odev1.g7.firatkoc;

public class DoktoraOgrencisi extends Ogrenci {

	public DoktoraOgrencisi(String adSoyad, String bolum,int numara) {
		super(adSoyad, bolum,numara);
	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + " " +  adSoyad;
	}
	
	@Override
	public String ogrenciTipiniAl() {
		return "Doktora Ogrencisi";
	} 

}
