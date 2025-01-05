# PetStoreAPITask

Bu proje, Pet Store API üzerinde otomatik test senaryoları oluşturmak ve çalıştırmak amacıyla geliştirilmiştir. Proje,
API testlerini gerçekleştirmek için Rest Assured ve TestNG kütüphanelerini kullanır.

<table>
  <tr>
    <td><img src="https://i.hizliresim.com/ta0fw1s.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
    <td><img src="https://i.hizliresim.com/hxpfjh3.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
    <td><img src="https://i.hizliresim.com/nlpy6w1.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
  </tr>
</table>


---
## Proje Yapısı

```plaintext
PetStoreAPITask
|-- .idea
|-- src
|   |-- test
|       |-- java
|           |-- com
|               |-- QAEmre
|                   |-- base
|                   |   |-- BaseTest.java
|                   |-- classes
|                   |   |-- Category.java
|                   |   |-- Pet.java
|                   |   |-- Tags.java
|                   |-- methods
|                   |   |-- Methods.java
|                   |-- tests
|                       |-- PetstoreNegativeApiTests.java
|                       |-- PetstorePositiveApiTests.java
|-- pom.xml
```

---

# Bağımlılıklar

&rarr; Bu proje aşağıdaki bağımlılıkları kullanmaktadır:

**`TestNG`** : Test otomasyonu için kullanılan bir framework.

**`Rest-Assured`** : RESTful web servislerini test etmek için kullanılan bir kütüphane.

**`Lombok`** : Java'da boilerplate kodu azaltmak için kullanılan bir kütüphane.

**`Gson`** : Java nesnelerini JSON'a ve JSON'dan dönüştürmek için kullanılan bir kütüphane.

<br>

---
# Sınıflar, Metotlar ve Fonksiyonlar

## BaseTest.java

- Bu sınıf, RestAssured tabanlı testlerin temellerini atan ve belirli yardımcı metotlar sağlayan bir taban sınıftır.

### Metotlar

- __`createValidPet()`__: Geçerli bir evcil hayvan nesnesi oluşturur ve döner.

- __`createInvalidPet()`__: Geçersiz bir evcil hayvan nesnesi oluşturur ve döner.

- __`checkStatusCode(Response response, Integer expectedStatusCode)`__: Gelen cevabın durum kodunu kontrol eder. Beklenen
  durum kodu ile karşılaştırır ve bir hata varsa bir mesajla bildirir.

- __`validateErrorMessage(Response response, String expectedMessage)`__ : Gelen cevaptaki hata mesajını kontrol eder. JSON
  formatında bir hata mesajı içerip içermediğini doğrular ve beklenen
  mesajla eşleşip eşleşmediğini kontrol eder.

- __`setup()`__ : Testler başlamadan önce çağrılır ve RestAssured'un temel URI'sini
  ayarlar (https://petstore.swagger.io/v2).

#### <u>Detaylı Açıklama</u>

Bu sınıf, API testleri yaparken kullanılacak geçerli ve geçersiz verileri oluşturma, yanıtların durum kodlarını ve hata
mesajlarını doğrulama gibi işlevler sağlar. Yardımcı metotlar, tekrar eden kodlardan kaçınılmasını ve testlerin daha
düzenli olmasını sağlar.

## Category.java

- Bu sınıf, evcil hayvanların kategorilerini tanımlamak için kullanılır ve `id` ve `name` özelliklerini içerir. `Category`
  sınıfı, evcil hayvanların hangi kategoriye ait olduklarını belirlemek için kullanışlıdır. Lombok kütüphanesi
  sayesinde, getter ve setter metotları otomatik olarak oluşturulur.

## Pet.java

- Bu sınıf, evcil hayvanların çeşitli özelliklerini tanımlamak için kullanılır ve `id`, `category`, `name`, `photoUrls`, `tags`,
  ve `status` özelliklerini içerir. `Pet` sınıfı, evcil hayvanların veritabanındaki veya API'deki temsilini sağlar. Lombok
  kütüphanesi sayesinde, getter ve setter metotları otomatik olarak oluşturulur.

## Tags.java

- Bu sınıf, evcil hayvanların etiketlerini tanımlamak için kullanılır ve `id` ve `name` özelliklerini içerir. `Tags` sınıfı,
  evcil hayvanlara ait etiketleri saklamak ve erişmek için kullanışlıdır. Lombok kütüphanesi sayesinde, getter ve setter
  metotları otomatik olarak oluşturulur.

## Methods.java

- Bu sınıf, RESTful API isteklerini gerçekleştirmek için çeşitli yardımcı metotlar sağlar ve RestAssured kütüphanesini
  kullanarak API'lerle etkileşimde bulunur.

### Metotlar

- __`postMethod(Pet pet)`__ : Bir Pet nesnesini JSON formatında POST isteği ile `/pet` endpoint'ine gönderir ve yanıtı
  döner.

- __`getMethod(long id)`__ : Belirtilen kimlik numarasına sahip evcil hayvanı GET isteği ile `/pet/{id}` endpoint'inden alır
  ve
  yanıtı döner.

- __`putMethod(Pet pet)`__ : Bir Pet nesnesini JSON formatında PUT isteği ile `/pet` endpoint'ine gönderir ve yanıtı döner.

- __`deleteMethod(long id)`__ : Belirtilen kimlik numarasına sahip evcil hayvanı DELETE isteği ile `/pet/{id}`
  endpoint'inden siler
  ve yanıtı döner.

- __`deleteMethod(String id)`__ : Belirtilen kimlik numarasına sahip evcil hayvanı DELETE isteği ile `/pet/{id}`
  endpoint'inden
  siler ve yanıtı döner.

#### <u>Detaylı Açıklama</u>

Bu sınıf, Pet nesneleri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için kullanılır.
Metotlar, RestAssured kütüphanesini kullanarak belirtilen endpoint'lere HTTP istekleri gönderir ve yanıtları döner. Gson
kütüphanesi, Pet nesnelerini JSON formatına dönüştürmek için kullanılır.

## PetstorePositiveApiTests.java

- Bu sınıf, Petstore API'si için pozitif test senaryolarını içeren bir test sınıfıdır. TestNG ve RestAssured
  kütüphanelerini kullanarak API isteklerini ve yanıtlarını test eder.

### Metotlar

- __`testCreatePet_Positive()`__ : Geçerli detaylarla yeni bir evcil hayvan oluşturmak için bir POST isteği gönderir ve
  yanıttaki
  evcil hayvan adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __`testGetPetById_Positive()`__ : Evcil hayvanı kimlik numarasıyla almak için bir GET isteği gönderir ve yanıttaki evcil
  hayvan
  adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __`testUpdatePet_Positive()`__ : Evcil hayvanın adını değiştirir ve güncellemek için bir PUT isteği gönderir; yanıttaki
  güncellenmiş evcil hayvan adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __`testDeletePet_Positive()`__ : Evcil hayvanı kimlik numarasıyla silmek için bir DELETE isteği gönderir ve yanıt
  mesajının
  evcil hayvanın kimlik numarasını içerdiğini doğrular.

#### <u>Detaylı Açıklama</u>

Bu sınıf, Petstore API'si üzerinde pozitif test senaryolarını gerçekleştirmek için kullanılır ve her test metodu belirli
API isteklerini gönderir ve yanıtları doğrular. `Reporter` sınıfı, test adımlarını raporlamak için kullanılır ve `Assert`
sınıfı, beklenen değerlerle karşılaştırmalar yapar.

## PetstoreNegativeApiTests.java

- Bu sınıf, Petstore API'si için negatif test senaryolarını içeren bir test sınıfıdır. TestNG ve RestAssured
  kütüphanelerini kullanarak API isteklerini ve yanıtlarını test eder.

### Metotlar

- __`testCreatePet_Negative()`__ : Geçersiz detaylarla yeni bir evcil hayvan oluşturmak için bir POST isteği gönderir ve
  yanıttaki evcil hayvan kimlik numarasının beklenen değeriyle eşleşmediğini doğrular. Ayrıca, yanıtın durum kodunu
  kontrol eder.

- __`testGetPetById_Negative()`__ : Geçersiz bir kimlik numarasıyla evcil hayvanı almak için bir GET isteği gönderir ve
  yanıtın
  durum kodunun 404 olduğunu doğrular. Ayrıca, yanıt mesajının "Pet not found" içerdiğini doğrular.

- __`testUpdatePet_Negative()`__ : Geçersiz detaylarla evcil hayvan bilgilerini güncellemek için bir PUT isteği gönderir
  ve
  yanıtın durum kodunun 405 olduğunu doğrular. Ayrıca, yanıttaki evcil hayvan kimlik numarasının beklenen değeriyle
  eşleşmediğini doğrular.

- __`testDeletePet_Negative()`__ : Geçersiz bir kimlik numarasıyla evcil hayvanı silmek için bir DELETE isteği gönderir ve
  yanıtın durum kodunun 404 olduğunu doğrular. Ayrıca, yanıt mesajının "Pet not found" içerdiğini doğrular.

- __`testDeletePetWithLargeID_Negative()`__ : Çok büyük bir kimlik numarasıyla evcil hayvanı silmek için bir DELETE isteği
  gönderir ve yanıtın durum kodunun 404 olduğunu doğrular. Ayrıca, yanıt mesajının "java.lang.NumberFormatException"
  içerdiğini doğrular.

#### <u>Detaylı Açıklama</u>

Bu sınıf, Petstore API'si üzerinde negatif test senaryolarını gerçekleştirmek için kullanılır ve her test metodu belirli
API isteklerini gönderir ve yanıtları doğrular. Reporter sınıfı, test adımlarını raporlamak için kullanılır ve Assert
sınıfı, beklenen değerlerle karşılaştırmalar yapar.

---
## Kurulum

Projeyi yerel makinenize klonladıktan sonra gerekli bağımlılıkları yüklemek için aşağıdaki adımları izleyin:

1. Projeyi klonlayın:

```bash
 git clone https://github.com/emresevincli/PetStoreAPITask.git 
``` 

2. Gerekli bağımlılıkları yükleyin:

```bash 
 mvn install 
 ```

3. Testleri çalıştırın:

```bash 
 mvn test 
 ```
---
## Test Raporlama

&rarr; Testler çalıştırıldığında, test sonuçları `target/surefire-reports` dizininde oluşturulacaktır. Bu dizinde, test
sonuçlarını detaylı olarak inceleyebileceğiniz `index.html` dosyası bulunmaktadır. Bu dosyayı bir tarayıcıda açarak
test
raporlarına göz atabilirsiniz.
  
---
<img src="https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExd2xla2c3OW00cWQzbDlpa2YzbDFkZ3l2a3I5NXVpNG01YTdtYzFycyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/ZVik7pBtu9dNS/giphy.webp" alt="Dans Eden Kedi GIF'i" />

## Görüşler

&rarr; Şu anda, iki test başarısız olmaktadır:


- **`testCreatePet_Negative()`** : Bu test, geçersiz detaylarla yeni bir evcil hayvan oluşturmayı denediğinde başarısız
  olmaktadır.
  API tarafında bir hata var. Beklenen yanıt kodu: 405, alınan: 200.
  <br>


- **`testUpdatePet_Negative()`** : Bu test, geçersiz detaylarla evcil hayvan bilgilerini güncellemeyi denediğinde başarısız
  olmaktadır. API tarafında bir hata var. Beklenen yanıt kodu: 405, alınan: 200.

<img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExMnpiaTNteGd3bGxsM3p0ZjdmeTE4dm40OHhoODVvc3prZzk2a2FuNCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/nrIj4ybdApT6zEtbtU/giphy.webp" alt="Dans Eden Kedi GIF'i" />
