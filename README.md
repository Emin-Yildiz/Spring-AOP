# AOP (Aspect Oriented Programming)

AOP, yazılımın karmaşıklığını azaltmaya, modülariteyi artırmaya yarayan bir yaklaşımdır. AOP, yazılımın farklı katmanlarına dağılmış olan tekrar eden kodların ortak bir noktada toplanarak daha az kod yazılmasını sağlar. Bu sayede kodun okunabilirliği ve bakımı kolaylaşır.

Bu tekrar eden kodlar **Cross Cutting Concerns** olarak geçmektedir. Bunlar validation, Logging, veritabanı işlemleri gibi işlemler olabilir.

AOP ise bize kesişen bu ilgilerin birbirinden ayrılması gerektiğini söylemektedir. Bu sayede sınıfın kendi sorumluluğunu yerine getirmesini, kodun daha okunur ve anlaşılır yapıda olmasını, aynı kodları çok daha kısa ve kolay bir şekilde tekrar kullanılabilirliğini sağlayabiliriz.

## Spring Boot AOP Kullanımı

- AOP'nin projeye dahil edilmesi.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### Advice

Bir Aspect sınıfında belirli bir kesimde gerçekleşen olaylara müdahale etmek için kullanılan metotlardır. Advice'ler, Aspect sınıfında tanımlanır ve belirli bir kesimdeki olayların öncesinde, sonrasında veya her ikisinde çalışacak kodu içerir.

| Anotasyon    | Tanım                                                   |
|--------------|---------------------------------------------------------|
| **@Before**  | Method devreye girmeden önce çalışır.                   |
| **@AfterReturning**   |Metot başarıyla tamamlandıktan sonra çalışır. Bu advice, metotun dönüş değerini de yakalayabilir ve işleyebilir.                 |
| **@AfterThrowing** | Metodun exception döndürmesi sırasında çalışır.    |
| **@After**    | Metod ister başarılı ister başarısız olsun metod tamamlandıktan sonra çalışır.     |
|**@Around**|Metod devreye girmedne önce ve metod bittikten sonra çalışır.|

### Pointcut

Hangi metodların veya metod gruplarının aspect'e tabi tutulacağını belirlemek için kullanılır.

target: Metodumuzun çalışması hedeflenen beani ifade eder.
execution: Metodumuzun çalışacağı bölge belirtilir.
@annotation: Hedef anotasyon dahilinde çalışacağı anlamına gelir.

| Parametre|Tanım |
|-|-|
|**target**|Metodumuzun çalışması hedeflenen beani ifade eder.|
|**execution**|Metodumuzun çalışacağı bölge belirtilir.|
|**@annotation**|Hedef anotasyon dahilinde çalışacağı anlamına gelir.|
