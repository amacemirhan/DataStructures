package librarymanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author amacemirhan 
 * Mehmed Emirhan Amaç - 170420517
 * Lütfen girdilerinizde türkçe karakter kullanmayınız.Ve
 * kullanıcı adı, şifrenizde boşluk bulunmasın. Program büyük küçük karaktere
 * duyarlıdır.
 * 
 *
 */
public class LibraryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        LibraryManagement lm = new LibraryManagement();
        
        Personal ps = new Personal();
        User us = new User();

        String nameLogin;
        String passLogin;
        String type;
        String kayit;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Giris yapmak icin herhangi bir tuşa basin.\n"
                    + "Kayit eklemek istiyorsaniz 'kayit' yaziniz.\n"
                    + "Çıkmak istiyorsanız 'exit'\n"
            );
            kayit = s.nextLine();
            if (kayit.equals("exit")) {
                System.exit(0);
            }

            System.out.println("İsminizi giriniz [bosluksuz tek kelime olmali]:");
            nameLogin = s.nextLine();
            System.out.println("Şifrenizi girniz [bosluksuz tek kelime olmali]:");
            passLogin = s.nextLine();
            System.out.println("Personel misiniz User mi [p veya u]:");
            type = s.nextLine();
            if (kayit.equals("kayit")) {
                lm.addRecords(nameLogin, passLogin, type);
                nameLogin = "";
                passLogin = "";
                type = "";
            }
        } while (!lm.controlRecords(nameLogin, passLogin, type));
        System.out.println("giriş yapildi");
        if (type.equals("p")) {
            ps.personalMain();
        } else if (type.equals("u")) {
            us.userMain();
        }
    }

    public boolean controlRecords(String Name, String Pass, String Type) throws IOException {
        File hum = new File("humans.txt");//humans
        try {
            Scanner myReader = new Scanner(hum);
            while (myReader.hasNext()) {
                String data = myReader.next();
                if (data.equals(Name)) {
                    data = myReader.next();
                    if (data.equals(Pass)) {
                        data = myReader.next();
                        if (data.equals(Type)) {
                            return true;
                        }
                    }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı yeni dosya oluşturuluyor.");
            if (hum.createNewFile()) {
                System.out.println("Dosya oluşturuldu: " + hum.getName());
            }
        }
        return false;
    }

    public void addRecords(String Name, String Pass, String Type) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("humans.txt", true));

        if (Type.equals("p") || Type.equals("u")) {
            bw.write(Name + " " + Pass + " " + Type + "\n");
            System.out.println("Kayıt yapildi.");
            bw.close();
        } else {
            System.out.println("Kullanici tipi yanlış kayit yapılamadı.");
        }
    }

}

class Books {

    public void addBooks() throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("books.txt", true));
        Scanner scb = new Scanner(System.in);
        System.out.println("Eklemek istediginiz kitabın adını giriniz:");
        String bookName = scb.nextLine();
        bw.write(bookName + "\n\n");
        System.out.println("Kitap eklendi.");
        bw.close();
    }

    public void bookList() throws FileNotFoundException {
        File book = new File("books.txt");//humans
        Scanner myReader = new Scanner(book);
        System.out.println("Kitap Listesi:");
        while (myReader.hasNext()) {

            String data = myReader.nextLine();
            System.out.println(data);
        }
    }

    public boolean bookAuth(String BOOK) throws FileNotFoundException {
        File book = new File("books.txt");//books
        String bookName;

        Scanner myReader = new Scanner(book);
        while (myReader.hasNextLine()) {
            bookName = myReader.nextLine();
            

            if (bookName.equals(BOOK)) {
                return true;
            }
        }
        return false;
    }

}

class Human {

}

class Personal extends Human {

    public void personalMain() throws FileNotFoundException, IOException, InterruptedException {
    
        Books bk = new Books();
        

        String state = new String();
        Scanner s = new Scanner(System.in);
        while (!"geri".equals(state)) {
            System.out.println("Kütüphane personeli ekranı.\n"
                    + "Kitap eklemek istiyorsanız 'kitap'yaziniz.\n"
                    + "Kitap listesi için 'list' \n"
                    + "Ana ekrana dönmek için 'geri'\n"
                    + "Çıkmak istiyorsanız 'exit'\n"
            );
            state = s.nextLine();
            switch (state) {
                case "kitap":
                    bk.addBooks();
                    break;
                case "list":
                    bk.bookList();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }
        LibraryManagement.main(null);
    }

}

class User extends Human {

    public void userMain() throws IOException, InterruptedException {
        User us = new User();
        Books bk = new Books();
        

        String state = new String();
        Scanner s = new Scanner(System.in);
        while (!"geri".equals(state)) {
            System.out.println("Kütüphane kullanıcı ekranı.\n"
                    + "Kitap ödünç almak istiyorsanız 'odunc'yaziniz.\n"
                    + "Kitap listesi için 'list' \n"
                    + "Ana ekrana dönmek için 'geri'\n"
                    + "Çıkmak istiyorsanız 'exit'\n"
            );
            state = s.nextLine();
            switch (state) {
                case "odunc":
                    us.KayitEkle();
                    break;
                case "list":
                    bk.bookList();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }
        LibraryManagement.main(null);

    }

    public boolean Auth(String NAME) throws FileNotFoundException {
        File hum = new File("humans.txt");//humans
        String Name;
        String Type;

        Scanner myReader = new Scanner(hum);
        while (myReader.hasNextLine()) {
            Name = myReader.next();
            myReader.next();
            Type = myReader.next();
            if (Name.equals(NAME) && Type.equals("u")) {
                return true;
            }
        }
        return false;

    }

    public void KayitEkle() throws IOException {
        User us = new User();
        Books bk = new Books();

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("contacts.txt", true));
        Scanner s = new Scanner(System.in);
        String name;
        String kitap;
        System.out.println("Dogrulama icin isminizi giriniz:");
        name = s.nextLine();
        bk.bookList();
        System.out.println("Odünc almak istediginiz kitabın ismini giriniz.");
        kitap = s.nextLine();

        if (us.Auth(name)) {
            if (bk.bookAuth(kitap)) {
                bw.write(name + " " + kitap + "\n");
                bw.close();
                System.out.println("Odunc tablosuna ekendi.");
            } else {
                System.out.println("O isimde bir kitap bulunamadı.");
            }

        } else {
            System.out.println("O isimde bir kullanıcı bulunamadı.");
        }

    }

}
