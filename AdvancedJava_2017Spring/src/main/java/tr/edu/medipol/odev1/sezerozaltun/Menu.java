package tr.edu.medipol.odev1.sezerozaltun;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 0/25
Dosyaya Yazma:  10/25 (Bilgiler yazilmamis, Okumadan yazmanin bir manasi yok)
Genel Program: 10/15 (Tr karakter sorunlari, Sadece yazma kismi eklenmis-genel olarak ayni odev)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 10/20

 */
public class Menu {
	
	public static Scanner MenuSec = new Scanner(System.in);
	
	public static void MenuGoster()
	{
		System.out.println("1-) Ogrenci Ekleme");
		System.out.println("2-) Ogrenci Silme");
		System.out.println("3-) Ogrenci Listeleme");
		System.out.println("0-) ��k��");
		
		
	}
	public static void main(String[] args)
	
	{ 
		while(true){
			
		
		MenuGoster();
		System.out.println("L�tfen Se�im Yap�n�z: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
		MenuSecimi menuSecimi = MenuSecimi.enumaCevir(kullaniciSecimi);
		switch (menuSecimi) {
		case OGRENCI_EKLEME:
			OgrenciEkleme();
			
			break;
		case OGRENCI_SILME:
			ogrenciSilme();
		
		break;
		
		case OGRENCI_LISTELE:
			ogrencileriEkranaBas(0);
break;
		case CIKIS:
			
			System.out.println("Dosya Yaz�l�yor.......");
			System.out.println("Dosya Yaz�ld�.");
			System.out.println("��k�� yap�ld�.");
			dosyaYaz();
	     	MenuSec.close();
	     	System.exit(0);
			
			
			break;
			
		default:
			break;
		}
	
		
		
			
					

				
		
		
		}	
	}
	public static void OgrenciEkleme()
	{
		System.out.println("L�tfen ad soyad giriniz: ");
		String adSoyad = MenuSec.nextLine();
		
		System.out.println("��renci Tipini Griniz (MYO/Lisans/YL/Doktora");
		String ogrenciTip =  MenuSec.nextLine();
		
		System.out.println("Ogrenci B�l�m Giriniz: (M�hendislik,��letme,Hukuk.. vs.. )");
		String bolum = MenuSec.nextLine();
		Ogrenci yeniOgrenci = null;
		if (ogrenciTip.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
		} else if (ogrenciTip.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
		} 
		else if (ogrenciTip.equals("Lisans")) {
			yeniOgrenci = new LisansOgrencisi(adSoyad, bolum);
		} 

		if (yeniOgrenci != null) {
			OgrenciListesi.add(yeniOgrenci);
			System.out.println(adSoyad + " isimli ogrenci eklendi.");
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
		
	
	}
	private static void ogrenciSilme() {
		System.out.println("Silmek istediginiz ogrenciyi seciniz: ");
		ogrencileriEkranaBas(0);
		System.out.print("Seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
		System.out.println(OgrenciListesi.get(kullaniciSecimi-1) 
				+ " isimli ogrenci siliniyor.");
		OgrenciListesi.remove(kullaniciSecimi-1);
		
	}
	private static Integer kullaniciIntegerGirdiAl() {
		String kullaniciGirisi = "";
		int girdi = -1;
		try {
			kullaniciGirisi = MenuSec.nextLine();
			girdi = Integer.valueOf( kullaniciGirisi );
		} catch(Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: " 
					+ kullaniciGirisi);
		}
		return girdi;
	}
	
	public static List<Ogrenci> OgrenciListesi = new ArrayList<>();
	
	public static void ogrencileriEkranaBas(int yontem) {
		if (OgrenciListesi.isEmpty()) {
			System.out.println("<< Sistemde kayitli ogrenci yok >>");
			return;
		}
		
		if (yontem == 0) {
			int no = 1;
			for (Ogrenci ogrenci : OgrenciListesi) {
				System.out.println(no + " -) " + ogrenci.ogrenciBilgileriAl());
				no++;
			}
		} else if (yontem == 1) {
			System.out.println(OgrenciListesi);
		} else {
			for (int i = 0; i < OgrenciListesi.size(); i++) {
				System.out.println(i + " -) " + OgrenciListesi.get(i));
			}
		}
	}
   public static void ogrenciListeleme() {
		ogrencileriEkranaBas(0);
	}
  
   public static void dosyaYaz() {

	    try {
	        FileWriter fos = new FileWriter("ogrenciler.txt");
	        PrintWriter out = new PrintWriter(fos);

	        for (int i = 0; i < OgrenciListesi.size(); i++) {

	            out.write(String.valueOf(OgrenciListesi.get(i)));
	            out.write(",");

	        }
	        out.close();

	    } catch (Exception e) {

	    }
	}
       

}






