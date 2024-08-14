package dev.patika;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrandManager bm = new BrandManager();
        NotebookManager notebookManager = new NotebookManager();
        MobilePhoneManager mobilePhoneManager = new MobilePhoneManager();

        while (true) {
            System.out.println("\nPatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri\n2 - Cep Telefonu İşlemleri\n3 - Marka Listele\n0 - Çıkış Yap\n");
            System.out.print("Tercihiniz: ");
            int choice;
            try {
                choice = scanner.nextInt();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Lütfen bir sayı giriniz!");
                scanner.nextLine();
                continue;
            }

            if(choice == 0){
                System.out.println("Görüşmek üzere!");
                break;
            }else if(choice == 1){
                while (true) {
                    System.out.println("Notebook işlemleri\n0 - Geri\n1 - Yeni notebook ekle\n2 - Bir notebook sil\n3 - Markaya göre listele\n4 - Tüm notebookları listele\n");
                    System.out.print("Tercihiniz: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if(choice == 0)
                        break;
                    else if(choice == 1){
                        System.out.print("\nEklenecek ürünün adını giriniz: ");
                        String name = scanner.nextLine();
                        System.out.print("Eklenecek ürünün markasını giriniz: ");
                        String brandName = scanner.nextLine();
                        System.out.print("Eklenecek ürünün fiyatını giriniz: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Eklenecek ürünün ram giriniz: ");
                        int ram =scanner.nextInt();
                        System.out.print("Eklenecek ürünün depolama alanını giriniz: ");
                        int depolama =scanner.nextInt();
                        System.out.print("Eklenecek ürünün ekran boyutunu giriniz: ");
                        double ekran = scanner.nextDouble();
                        Brand brand = bm.getBrand(brandName);
                        if(brand == null){
                            brand = new Brand(brandName);
                            bm.add(brand);
                        }

                        if (notebookManager.add(new Notebook(price,0,1,name,brand,ram,depolama,ekran)))
                            System.out.println("Ürün başarıyla eklendi");
                    }else if(choice == 2){
                        System.out.print("\nSilinecek ürünün id sini giriniz: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if(notebookManager.delete(id))
                            System.out.println("Ürün başarıyla silindi");
                        else
                            System.out.println("Ürün silinemedi lütfen tekrar deneyiniz.");
                    }else if(choice == 3){
                        System.out.print("\nMarkayı giriniz: ");
                        String brand = scanner.nextLine();
                        notebookManager.listByBrand(brand);
                    }else if(choice == 4){
                        notebookManager.listAll();
                    }else {
                        System.out.println("\nHatalı değer girdiniz!\n");
                        continue;
                    }
                }

            }else if(choice == 2) {
                while (true) {
                    System.out.println("Cep Telefonu işlemleri\n0 - Geri\n1 - Yeni telefon ekle\n2 - Bir telefon sil\n3 - Markaya göre listele\n4 - Tüm telefonları listele\n");
                    System.out.print("Tercihiniz: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if(choice == 0)
                        break;
                    else if(choice == 1){
                        System.out.print("\nEklenecek ürünün adını giriniz: ");
                        String name = scanner.nextLine();
                        System.out.print("Eklenecek ürünün markasını giriniz: ");
                        String brandName = scanner.nextLine();
                        System.out.print("Eklenecek ürünün fiyatını giriniz: ");
                        double price = scanner.nextDouble();
                        System.out.print("Depolama alanını giriniz (GB): ");
                        int storage = scanner.nextInt();
                        System.out.print("Ekran boyutunu giriniz (inch): ");
                        double screenSize = scanner.nextDouble();
                        System.out.print("Batarya kapasitesini giriniz (mAh): ");
                        double battery = scanner.nextDouble();
                        System.out.print("RAM miktarını giriniz (GB): ");
                        int ram = scanner.nextInt();
                        System.out.print("Kamera çözünürlüğünü giriniz (MP): ");
                        int camera = scanner.nextInt();


                        scanner.nextLine();

                        Brand brand = bm.getBrand(brandName);
                        if(brand == null){
                            brand = new Brand(brandName);
                            bm.add(brand);
                        }

                        if (mobilePhoneManager.add(new MobilePhone(price,0,1,name,brand,storage,screenSize,battery,ram,camera,"Beyaz")))
                            System.out.println("Ürün başarıyla eklendi");
                    }else if(choice == 2){
                        System.out.print("\nSilinecek ürünün id sini giriniz: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if(mobilePhoneManager.delete(id))
                            System.out.println("Ürün başarıyla silindi");
                        else
                            System.out.println("Ürün silinemedi lütfen tekrar deneyiniz.");
                    }else if(choice == 3){
                        System.out.print("\nMarkayı giriniz: ");
                        String brand = scanner.nextLine();
                        mobilePhoneManager.listByBrand(brand);
                    }else if(choice == 4){
                        mobilePhoneManager.listAll();
                    }else {
                        System.out.println("\nHatalı değer girdiniz!\n");
                        continue;
                    }
                }
            }else if(choice == 3) {
                bm.printBrands();
            }else {
                System.err.println("Hatalı seçim yaptınız!");
                continue;
            }
        }

    }
}