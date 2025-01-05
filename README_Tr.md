# PetStoreAPITask

Bu proje, Pet Store API üzerinde otomatik test senaryoları oluşturmak ve çalıştırmak amacıyla geliştirilmiştir. Proje,
API testlerini gerçekleştirmek için Rest Assured ve TestNG kütüphanelerini kullanır.
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
|                   |   |-- PhotoUrls.java
|                   |   |-- Tags.java
|                   |-- methods
|                   |   |-- Methods.java
|                   |-- tests
|                       |-- PetstoreNegativeApiTests.java
|                       |-- PetstorePositiveApiTests.java
|-- pom.xml
```
---
# Sınıflar, Metotlar ve Fonksiyonlar

## BaseTest.java

- Bu sınıf, RestAssured tabanlı testlerin temellerini atan ve belirli yardımcı metotlar sağlayan bir taban sınıftır.

### Metotlar

- __createValidPet()__: Geçerli bir evcil hayvan nesnesi oluşturur ve döner.

- __createInvalidPet()__: Geçersiz bir evcil hayvan nesnesi oluşturur ve döner.

- __checkStatusCode(Response response, Integer expectedStatusCode)__: Gelen cevabın durum kodunu kontrol eder. Beklenen
  durum kodu ile karşılaştırır ve bir hata varsa bir mesajla bildirir.

- __validateErrorMessage(Response response, String expectedMessage)__ : Gelen cevaptaki hata mesajını kontrol eder. JSON
  formatında bir hata mesajı içerip içermediğini doğrular ve beklenen
  mesajla eşleşip eşleşmediğini kontrol eder.

- __setup()__ : Testler başlamadan önce çağrılır ve RestAssured'un temel URI'sini
  ayarlar (https://petstore.swagger.io/v2).

#### <u>Detaylı Açıklama</u>

Bu sınıf, API testleri yaparken kullanılacak geçerli ve geçersiz verileri oluşturma, yanıtların durum kodlarını ve hata
mesajlarını doğrulama gibi işlevler sağlar. Yardımcı metotlar, tekrar eden kodlardan kaçınılmasını ve testlerin daha
düzenli olmasını sağlar.

## Category.java

- Bu sınıf, evcil hayvanların kategorilerini tanımlamak için kullanılır ve id ve name özelliklerini içerir. Category
  sınıfı, evcil hayvanların hangi kategoriye ait olduklarını belirlemek için kullanışlıdır. Lombok kütüphanesi
  sayesinde, getter ve setter metotları otomatik olarak oluşturulur.

## Pet.java

- Bu sınıf, evcil hayvanların çeşitli özelliklerini tanımlamak için kullanılır ve id, category, name, photoUrls, tags,
  ve status özelliklerini içerir. Pet sınıfı, evcil hayvanların veritabanındaki veya API'deki temsilini sağlar. Lombok
  kütüphanesi sayesinde, getter ve setter metotları otomatik olarak oluşturulur.

## PhotoUrls.java

- Bu sınıf, evcil hayvanların fotoğraf URL'lerini tanımlamak için kullanılır ve photoUrls özelliğini içerir. PhotoUrls
  sınıfı, evcil hayvanların fotoğraflarını saklamak ve erişmek için kullanışlıdır. Lombok kütüphanesi sayesinde, getter
  ve setter metotları otomatik olarak oluşturulur.

## Tags.java

- Bu sınıf, evcil hayvanların etiketlerini tanımlamak için kullanılır ve id ve name özelliklerini içerir. Tags sınıfı,
  evcil hayvanlara ait etiketleri saklamak ve erişmek için kullanışlıdır. Lombok kütüphanesi sayesinde, getter ve setter
  metotları otomatik olarak oluşturulur.

## Methods.java

- Bu sınıf, RESTful API isteklerini gerçekleştirmek için çeşitli yardımcı metotlar sağlar ve RestAssured kütüphanesini
  kullanarak API'lerle etkileşimde bulunur.

### Metotlar

- __postMethod(Pet pet)__ : Bir Pet nesnesini JSON formatında POST isteği ile /pet endpoint'ine gönderir ve yanıtı
  döner.

- __getMethod(long id)__ : Belirtilen kimlik numarasına sahip evcil hayvanı GET isteği ile /pet/{id} endpoint'inden alır
  ve
  yanıtı döner.

- __putMethod(Pet pet)__ : Bir Pet nesnesini JSON formatında PUT isteği ile /pet endpoint'ine gönderir ve yanıtı döner.

- __deleteMethod(long id)__ : Belirtilen kimlik numarasına sahip evcil hayvanı DELETE isteği ile /pet/{id}
  endpoint'inden siler
  ve yanıtı döner.

- __deleteMethod(String id)__ : Belirtilen kimlik numarasına sahip evcil hayvanı DELETE isteği ile /pet/{id}
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

- __testCreatePet_Positive()__ : Geçerli detaylarla yeni bir evcil hayvan oluşturmak için bir POST isteği gönderir ve
  yanıttaki
  evcil hayvan adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __testGetPetById_Positive()__ : Evcil hayvanı kimlik numarasıyla almak için bir GET isteği gönderir ve yanıttaki evcil
  hayvan
  adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __testUpdatePet_Positive()__ : Evcil hayvanın adını değiştirir ve güncellemek için bir PUT isteği gönderir; yanıttaki
  güncellenmiş evcil hayvan adı ve durumunun beklenen değerlerle eşleştiğini doğrular.

- __testDeletePet_Positive()__ : Evcil hayvanı kimlik numarasıyla silmek için bir DELETE isteği gönderir ve yanıt
  mesajının
  evcil hayvanın kimlik numarasını içerdiğini doğrular.

#### <u>Detaylı Açıklama</u>

Bu sınıf, Petstore API'si üzerinde pozitif test senaryolarını gerçekleştirmek için kullanılır ve her test metodu belirli
API isteklerini gönderir ve yanıtları doğrular. Reporter sınıfı, test adımlarını raporlamak için kullanılır ve Assert
sınıfı, beklenen değerlerle karşılaştırmalar yapar.

## PetstoreNegativeApiTests.java

- Bu sınıf, Petstore API'si için negatif test senaryolarını içeren bir test sınıfıdır. TestNG ve RestAssured
  kütüphanelerini kullanarak API isteklerini ve yanıtlarını test eder.

### Metotlar

- __testCreatePet_Negative()__ : Geçersiz detaylarla yeni bir evcil hayvan oluşturmak için bir POST isteği gönderir ve
  yanıttaki evcil hayvan kimlik numarasının beklenen değeriyle eşleşmediğini doğrular. Ayrıca, yanıtın durum kodunu
  kontrol eder.

- __testGetPetById_Negative()__ : Geçersiz bir kimlik numarasıyla evcil hayvanı almak için bir GET isteği gönderir ve
  yanıtın
  durum kodunun 404 olduğunu doğrular. Ayrıca, yanıt mesajının "Pet not found" içerdiğini doğrular.

- __testUpdatePet_Negative()__ : Geçersiz detaylarla evcil hayvan bilgilerini güncellemek için bir PUT isteği gönderir
  ve
  yanıtın durum kodunun 405 olduğunu doğrular. Ayrıca, yanıttaki evcil hayvan kimlik numarasının beklenen değeriyle
  eşleşmediğini doğrular.

- __testDeletePet_Negative()__ : Geçersiz bir kimlik numarasıyla evcil hayvanı silmek için bir DELETE isteği gönderir ve
  yanıtın durum kodunun 404 olduğunu doğrular. Ayrıca, yanıt mesajının "Pet not found" içerdiğini doğrular.

- __testDeletePetWithLargeID_Negative()__ : Çok büyük bir kimlik numarasıyla evcil hayvanı silmek için bir DELETE isteği
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
 git clone https://github.com/kullaniciadi/proje-adi.git 
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
## Görüşler

&rarr; Şu anda, iki test başarısız olmaktadır:


- <span style="color: red;">testCreatePet_Negative()</span> : Bu test, geçersiz detaylarla yeni bir evcil hayvan oluşturmayı denediğinde başarısız
  olmaktadır.
  API tarafında bir hata var. Beklenen yanıt kodu: 405, alınan: 200.
<br>


- <span style="color: red;">testUpdatePet_Negative()</span> : Bu test, geçersiz detaylarla evcil hayvan bilgilerini güncellemeyi denediğinde başarısız
  olmaktadır. API tarafında bir hata var. Beklenen yanıt kodu: 405, alınan: 200.

