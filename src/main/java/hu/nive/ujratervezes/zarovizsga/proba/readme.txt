•	Metóduson belül lehet bárhol, bárhány darab a visszatérési típushoz illő return. (Itt van típuskonverzió is.)
•	Primitív->referencia típusnál nem implicit konverzió, hanem autoboxing van.
•	Blokkon belül (pl. for ciklus, if ágak) létrehozott változók a blokkon kívül már nem léteznek!
•	tömb.length  és  lista.size()   sztring.length()
•	tömb[0. index]  és  lista.get(0. elem)   és   String.charAt(0-tól)
•	string.equals()   !!! soha nem == !!!
•	int = (int) double    !!! kasztolás nélkül nem lehet int=double !!!
•	double = int / 2  !!! előbb egész részt vesz !!!
•	s.lowerCase()   !!! s értéke nem változik !!!
•	attribútumot elfedi a paraméter változó, és a lokálos változó is. (Ez utóbbit ne tegyük!)
•	paraméterrel azonos nevű lokális változó --> fordítási idejű hiba !!!
•	elfedett attribútum így elérhető: this.neve
•	átadott primitív paramétert hiába változtatunk meg, nem hat vissza a hívóban marad a változó "eredeti" értéke
•	lokális változóknak nincs default kezdőértéke (tömb elemeinek van)
•	switch - case   !!! break; nélkül folytatja a következő case parancsaival !!!
•	statikus metódusból csak példányosítás után hívható nem statikus
       csak így: psvm(){ new Osztály().nemstatikus(); }  !!! new Osztály nélkül nem megy !!!
•	package csomag.*   A * csak az adott csomagra vonatkozik, az alcsomagokra nem!!!
•	public static void main(String args[]){ }    Csak ez a "szó" sorrend a helyes. (args lehet más)
•	ha van abstract metódus, akkor az osztály is abstract kell legyen. (Fordítva nem áll fent.)
•	abstract void metódus();    vs.  nem absztrakt void metódus(){} mert van törzse!
•	final változó a deklarálás és a "használat" között bárhol kaphat, de valamikor maximum egyszer kell is értéket kapjon
•	Ha a final változó attribútum, akkor legkésőbb a konstruktorban értéket kell kapjon.
•	Konstruktorok SOHA, de SOHA NEM öröklődnek.
•	Konstruktor megadásakor megszűnik létezni a default paraméternélküli konstruktor. (Kézzel lehet/kellhet újra megírni.)
•	Konstruktornak CSAK az első sorában szerepelhet a this. vagy  super. hívása. Ha mi nem írjuk oda egyiket sem, a fordító akkor oda teszi a supert! (Ebből lehet baj, ha nincs paraméter nélküli a szülőben.)
•	A Map interfész NEM a Collection interfész leszarmazottja!!!
•	VARARGS csak utolsó paraméter lehet, és ekkor sem egyezhet más paraméter sorrenddel (Pl.: metódus(String a, String... b), metódus(String... c) hibát eredményez, mert csak 1 sztringgel hívás esetén nem eldönthető melyiket hívja.)

•	final osztályból nem lehet leszármaztatni másik osztályt
•	final metódust nem lehet override-olni
•	final attribútumnak egyetlen-egyszer lehet csak értéket adni: vagy a deklaráláskor, vagy a konstruktorban.

Absztrakt osztály:
Egy osztály attól és csak attól absztrakt, hogy én az elejére kiírtam az "abstract" szócskát.
Az absztrakt osztálynak nincs kötelezően absztrakt metódusa.
Viszont ha egy osztálynak van absztrakt metódusa, akkor maga az osztály is kötelezően absztrakt kell, hogy legyen.

Interface metódusok:
•	Alapból public abstract minden metódus, ami elé nem írok másmilyen láthatósági vagy egyéb módosítószót. Ezt a két szót nem kötelező kiírni, a fordító anélkül is tudja, hogy ez esetben neki public abstract-ként kell értelmeznie a metódust. Ki lehet írni ezt a két szót, tehát ez nem hiba, de fölösleges.
•	default metódus: kötelező implementálni az interfészben (hiszen pont ez a lényege, hogy eleve adunk neki egy default működést)
•	private metódus: kötelező implementálni az interfészben (lévén nem is hívható más osztályokból közvetlenül)
•	static metódus: kötelező implementálni az interfészben, csak public lehet, nem lehet default és nem öröklődik; csak az interfész nevével minősítve hívható.

try-catch-finally:
•	try {} önmagában nem állhat, kell utána catch blokk
•	catch úgy néz ki, hogy: catch () {}, ahol a sima zárójelben az elkapni akart kivétel van (típus és szabadon választott változónév), a kapcsos zárójelben pedig utasítások, hogy mit csináljon a program akkor, ha elkap egy ilyen típusú kivételt.
•	catch sima zárójelében lehet 1 fajta kivételtípus + változónév, vagy többfajta (2 vagy több, multi catch) úgy, hogy (XException | YException |ZException ex), vagyis a változónevet csak egyszer kell megadni.
•	Ha a catch-nek a törzsében nem dobódik valamilyen módon új Exception, akkor a program futása nem áll meg, hanem továbblép a következő utasításokra.
•	finally ágat nem kötelező írni
•	finally ág mindig lefut (akkor is, ha nem írtunk, és akkor is, ha a catch-ben kivétel dobódik és leáll a program futása)

try-with-resources
•	úgy néz ki, hogy: try () {}
•	állhat önmagában, de írhatunk utána catch ágat is (ld. előző hsz)
•	finally ága is van (ld. előző hsz)
•	a try után a sima zárójelbe beleírt erőforrásra automatikusan meghívja annak a close() metódusát (pont ezért találták ki, hogy nehogy véletlenül lezáratlanul maradjon egy erőforrás azért, mert a feledékeny ember elfelejti manuálisan leírni azt, hogy erőforrás.close())
•	sokszor eleve a try fejében hozzuk létre az erőforrást, de megkaphatja kívülről is


A Map interfész nem a Collection interfész leszarmazottja.
 
Metódus túlterhelés (method overloading):
•	a metódus neve ugyanaz
•	a parameterlista eltérő (parameterek típusa és/vagy száma)
•	a visszatérési érték mindegy

static metódusok meghívása lehetséges:
•	osztalynevvel minősítve (pl. Assertions.assertEquals()), ekkor az osztalynevet importálni kell
•	osztalynev nélkül (pl. simán assertEquals()), ekkor az import statikus import és magát a metódus nevét kell importálni, vagy a metódust tartalmazó Osztalynev.* - ot (ez utóbbival az adott osztály összes statikus tagját importálom)
•	példányon is meg lehet hívni (pl. new Assertions.assertEquals()), ez működik, de TILOS használni.

példány és statikus:
•	példány attribútumból elérem a statikus attribútumot
•	példány metódusból elérem a statikus attribútumot
•	példány metódusból elérem a statikus metódust
•	statikus attribútum eléri a statikus attribútumot
•	statikus attribútum eléri a statikus metódust
•	statikus metódusból elérem a statikus attribútumot
•	statikus metódusból elérem a statikus metódust
•	DE NEM LEHET statikus bármiből elérni a példány bármit

Konstruktorok nem  öröklődnek. SOHA. Nem, extrán csűrt-csavart körülmények között sem.

Metódusok öröklődése:
•	A láthatóság nem lehet szűkebb
•	A visszatérés típusa nem lehet általánosabb (tehát referencia tipus esetén valamelyik ős osztályba tartozó)
•	A dobható kivételek nem lehetnek bővebbek (csak ugyanazok, szűkebb, vagy 0)


public static void main(String... args) {}
public static void main(String args[])

public void iterateUsingEntrySet(Map<String, Integer> map) { for (Map.Entry<String, Integer> entry : map.entrySet()) { System.out.println(entry.getKey() + ":" + entry.getValue()); } }

"áéíóöőúüű".contains(String.valueOf(c).toLowercase)
https://github.com/kovacseni/kepesitovizsga-gyakorlas-v6.0
https://github.com/manikola/arraysexercises
konzol kvíz:
https://github.com/exylaci/training-solutions/commit/b5e96a960fff12560cbc7b63eb39c8bbab8160e0
Mi hamis a lokális változókkal kapcsolatban?
A) A nem `null` értékû referencia típusú lokális változók egy heapen elhelyezkedő objektumra mutatnak
B) A lokális változók a stacken helyezkednek el
C) A `final` kulcsszóval ellátott lokális változónak a deklarálás sorában értéket kell adni (pl. `final int i = 5;`)
D) A lokális változók nem kapnak kezdőértéket
Mi hamis a típuskonverzióval kapcsolatban?
A) `int` típusból `Integer` típussá alakításkor implicit típuskonverzió van (ez autoboxing, nem típuskonv)
B) A típuskonverzió értelmezett primitív és referencia típusok esetén is
C) A típuskonverzió implicit, ha nem írjuk ki, explicit ha kiíírjuk és kerek zárójeleket alkalmazunk
D) Típuskonverzió operátorok alkalmazásakor, paraméterátadáskor, metódus visszatéréskor történhet

# Vizsga kérdések

## Java, Maven, GIT

### Melyik állítás hamis az alábbiak közül? JAVA

1.  A szemétgyűjtő mechanizmust a virtuális gép biztosítja.

2. A lefordított bájtkód platform független.

3. Az Oracle szállítja a JDK-t, mely a JRE és olyan (főleg) parancssori fejlesztőeszközök, mint a fordító. A JRE-nek része a virtuális gép és az osztálykönyvtár.

4. **A virtuális gép elemzi a forráskódot, és soronként futtatja.**

   Válasz: 4 A JVM feladata a bytekód futtatása

### Melyik állítás hamis az alábbiak közül? MAVEN

1.  Java-ban nincs standard projektstruktúra

2.  A Maven alapelve a convention over configuration

3. **Az IDE nem tud Maven nélkül működni**

4.  A Maven parancssorból indítható, nem szükséges fejlesztőeszköz a használatához

   Válasz: maven egy szabvány eszköz amit a build folyamatot segíti elő

### Melyik könyvtárba kell elhelyezni a fájlokat Maven esetén? A megadott könyvtárnevek mindig a projekt főkönyvtárától értelmezendőek. MAVEN könyvtár struktúra

1.  **Az src/main/java könyvtárba kell elhelyezni a Java forrásfájlokat és az src/test/java könyvtárba a teszteseteket**

2.  A main könyvtárba kell elhelyezni a Java forrásfájlokat és a test könyvtárba a teszteseteket

3. A main/src/java könyvtárba kell elhelyezni a Java forrásfájlokat és a test/src/java könyvtárba a teszteseteket

4.  A java könyvtárba kell elhelyezni a Java forrásfájlokat és a java/test könyvtárba a teszteseteket

###  Mi azonosítja a Maven projektet (koordináták)?

1.  A projekt neve
2.  A projekt csomagneve és neve
3.  A projekt groupId, artifactId tulajdonsága
4.  **A projekt groupId, artifactId és version tulajdonsága**

### Válaszd ki az igaz állítást! GIT

1. **A push művelettel lehet a lokális repository-ból a commitokat feljuttatni a távoli repository-ba.**
2.  A push művelettel lehet a lokális repository-ba a commitokat bejuttatni.
3.  A commit adja hozzá a fájlokat a Githez, hogy arról tudjon a verziókezelő, de hogy bekerüljön, még egy plusz műveletet el kell végezni.
4.  Ha kitörlünk egy állományt, az automatikusan eltűnik a Git repo-ból, nem kell commit művelet.

## Csomagok

### 1. Melyik állítás igaz?

1.  **Nem érdemes a forrásállományokat csomagokon kívül elhelyezni**

2.  Ha az A osztályból el akarjuk érni egy másik csomagban lévő B osztályt, akkor csak importálással tudjuk azt elérni

3.  A csomag neve és a könyvtár neve eltérhet

4. Az A osztályból csak akkor használható a B osztály, ha beimportáljuk

   Válasz: csomag neve és könyvtár neve nem térhet el, tudjuk minősített névvel is elérni, nem kell az import

### 2. Melyik csomag osztályai kerülnek automatikusan importálására, így azokat használhatjuk import nélkül is?

1. Nincs ilyen csomag, mindig importálni kell

2. **A java.lang csomag automatikusan importálásra kerül**

3.  A String csomag automatikusan importálásra kerül

4.  A common csomag automatikusan importálásra kerül

## Java alapok

### Melyik hamis a következő állítások közül?

1.  Az osztály fő építőelemei a konstruktorok, metódusok és attribútumok

2. **Konstruktor megadása kötelező**

3. A getterek és setterek metódusok

4.  Az osztály publikus metódusai adják annak interfészét (attribútumokat ne tegyük publikusra)

   Válasz: Default Konstruktor
### Melyik helyes main() deklaráció? MAIN

1.  public static int main(String[] args)
2.  public final int main(String args)
3.  public final void main(String args[])
4.  **public static void main(String[] args)**



### Melyik írja ki a konzolra azt, hogy Hello World? SOUT

1. **System.out.println("Hello World")**
2.  print("Hello World")
3.  System.console.print("Hello World")
4. println("Hello World")

### Melyik hamis a kódolási konvenciókkal kapcsolatban? KONVEKCIÓ

1. Változónevek első karaktere, ha betű, kisbetű legyen

2. Metódusnevek első karaktere, ha betű, kisbetű legyen

3. **Osztálynevek első karaktere, ha betű, kisbetű legyen**

4. A konstans értékek nevei csupa nagybetűvel és a szavak között aláhúzás karakterrel szerepeljenek

   Válasz Osztályneve első karaktere ha betű mindig nagy betű

### Melyik változónév helyes a Clean Code alapelvek szerint? CLEAN CODE KONVENKCIÓK

1. **firstName**
2.  cc
3.  last_name
4.  FirstName

### Adott két változó: ADATTÍPÚS

int a = 2;
int b = 4;
Milyen adattípusban tárolható a következő kifejezés értéke: b % a == 0?

1. **boolean**
2. int
3.  Integer
4.  false

### Melyik igaz az alábbi állítások közül? INT Típus

1.  Egész literálok megadása csak tizes számrendszerben történhet

2.  Változót a következőképpen deklarálunk: let a = 0;

3.  Változót a következőképpen deklarálunk: var a = 0;

4.  **Változót a következőképpen deklarálunk: int a = 0;**

   Válasz: egész literált meglehet adni 8,16 és 2 számrendszerben is, a let és a var másik programozási nyelv. bár a var az létezik itt is talán

### Melyik nem primitív típus? TÍPUS

1. **String**
2.  int
3.  char
4.  double

### Melyik helyes definíció, amennyiben csak a beépített osztálykönyvtárt használjuk?

1.  Int i = 0;

2. **int i = 0;**

3.  arraylist names = new List

4.  char c = null;

   Válasz: Int az nincs, helyesen list names = new arraylist, char az primitív nem lehet null
### Mely állítás igaz a következők közül? FINAL
1.  Ha final kulcsszóval deklarálunk egy lokális változót, akkor annak a deklarációkor értéket kell adni
2.  Ha final kulcsszóval deklarálunk egy lokális változót, akkor bármikor adhatunk neki értéket a metóduson belül
3.  **Ha final kulcsszóval deklarálunk egy lokális változót, akkor az első használat előtt adnunk kell neki értéket**
4.  Ha final kulcsszóval deklarálunk egy lokális változót, akkor int típus esetén az értéke mindig 0

### Melyik hamis az alábbiak közül az attribútumokra vonatkozóan? ATTRIBÚTUMOK
1.  Az attribútumok kezdőértékkel rendelkeznek, pl. egész számok esetén ez 0
2.  **A lokális változók kezdőértékkel rendelkeznek, pl. egész számok esetén ez 0**
3.  Deklaráljuk az attribútumokat private módosítószóval, és csak metódusokon (pl. getter és setter) keresztül férjünk hozzá
4.  Attribútumok értékei pl. konstruktorban is inicializálhatóak

### A példányváltozók elrejtésének több előnye is van. Az alábbiak közül melyik NEM az? ATTRIBÚTUMOK

1. **A privát változókat titkosítja a JVM, így egyesetleges hacker-támadás során nagyobb biztonságban vannak az adataink.**
2.  A privát változókat nem tudjuk véletlenül módosítani egy másik osztályból, így könnyebb ügyelnünk az adataink koherenciájára.
3.  Az osztályunk belső szerkezetét meg tudjuk úgy változtatni, hogy ez más osztályban levő kódra ne legyen hatással, ez által könnyebben karbantartható lesz a kódbázisunk.
4.  Ha csak metóduson keresztül van lehetőség módosítani egy változó értékét, akkor be tudunképíteni extra validációkat.

### Mely igaz a következő állítások közül? KONSTRUKTOR
1. Kötelező minden osztályban konstruktort megadni
2.  **A konstruktor neve meg kell, hogy egyezzen az osztály nevével**
3. A konstruktor visszatérési értéke lehet void
4.  A konstruktort a példányosítás után is meg lehet   hívni

### Mely állítás igaz az implicit (default) konstruktorral kapcsolatban? KONSTRUKTOR
1.  Fogadhat paramétereket
2.  private módosítószóval rendelkezik
3.  Amennyiben definiálunk egy paraméteres konstruktort, az implicit (default) konstruktor továbbra is hívható
4. **Törzsében szerepel egy super() hívás**

### Melyik metódussal lehet túlterhelni (overload) a következő metódust? METHOD OVERLOADING
public Course createCourse(String name) {}

1. public Course create(String name) {}

2. public SpecificCourse createCourse(String name){}

3.  **public Course createCourse(String name, Level level) {}**

4.  public Course createCourse(String name) {}

   Válasz: 1 nem ugyan az a method név, 2 visszatérésiérték különböző, 4 ugyanaz mint az eredeti fordítási hiba



### Melyik állítás NEM igaz? METHOD OVERLOADING

1. **Ha egy metódust túltöltünk (overload-olunk), azaz több különböző változatot deklarálunk belőle, amik csak a paraméterlistában térnek el, azt jelölhetjük a @Overload annotációval.**
2.  Ha egy metódust túltöltünk (overload-olunk), azaz több különböző változatot deklarálunk belőle, amik csak a paraméterlistában térnek el, azt jelölhetjük a @Overload annotációval.
3.  Metódusok túltöltése (overload-olása) esetén a paraméterek neve nem számít, csak a paraméterek típusa azok sorrendjében nézve.
4.  Egy örökölt metódust csak akkor kötelező felülírni (override-olni), ha az az ősosztályban absztraktként van deklarálva, a leszármazott osztály pedig nem absztrakt.




### Melyik hamis a Java memóriakezelésével kapcsolatban? STAC,HEAP
1.  **Az objektumok a stacken jönnek létre**
2.  A lokális változók, ha referenciák, a referencia a stacken jön létre, az objektum a heapen
3.  A primitív típusú lokális változók a stacken jönnek létre
4.  Minden metódushívás kap egy külön területet a stacken, melybe a lokális változók értékei kerülnek

### Melyik állítás hamis az immutable osztályokkal kapcsolatban? IMMUTABLE OSZTÁLY
1.  Érdemes az attribútumait final kulcsszóval ellátni, hogy csak egyszer lehessen neki értéket adni.
2.  Használatuk azért is hasznos, mert paraméterként átadva biztosak lehetünk benne, hogy a hívás során nem változik az értéke.
3. A String osztály immutable
4.  **A metódusai módosíthatják az attribútumok értékét, csak a paraméterek értékét nem módosíthatják**

### Mely deklaráció fordul le? ABSTRACT
1.  public abstract class Canine { public void speak(); }

2.  public class Canine abstract { public abstract void speak(); }

3.  public class Canine { public abstract void speak(); }

4.  public abstract class Canine { public void speak(){ } }

   Válasz:

   1. hiányzik abstract a metódusból
   2. abstract a class előtt van fordítási hiba amúgy jó lenne
   3. nem abstract a class
   4. Ez a jó hisz a metódus nem absztrakt és van törzse (jelen esetben ez üres)



### Válaszd ki a Building osztály House alosztályának megfelelő definiálását! ÖRÖKLŐDÉS

1. **public class House extends Building {}**
2. public subclass House extends Building {}
3.  public class House subclass of Building {}
4. public class Building.House {}



### Az alábbiak közül melyik igaz az absztrakt osztályokra?

1. **Származhatnak egy másik absztrakt osztályból.**
2.  Nem lehetnek példányváltozóik.
3.  Absztrakt osztályból való leszármazáshoz az implements kulcsszót használjuk.
4.  Csak absztrakt metódusokat tartalmazhatnak.

### Adottak a következő állítások. Az A és E osztály. A B és D interfész. A C absztrakt osztály. IMPLEMETS EXTENDS

Melyik helytelen a következő megadások közül?

1.  class F implements B { }

2.  **class F extends A, E { }**

3.  class F extends E { }

4.  class F implements B,D { }

   Válasz: Java-ban csak egyszeres öröklődés van

### Melyik helyes deklaráció interfészen belül? INTERFACE

1. **public void doMore(long bow);**

2.  public void doMore(long bow) {}

3.  private short hop = 23;

4.  public Name();

   Válasz:

   1. helyes
   2. metódus törzs nem kell
   3. private változó nem lehetséges
   4. visszatérési tipus kell, nincs konstruktor

### Mely igaz a JavaBeans konvenciókkal kapcsolatban? JAVABEANS
1.  Minden Java osztálynak JavaBeansnek kell lennie

2.  Kötelezően lenniük kell getter és setter metódusainak

3.  Minden típus esetén ugyanazt az elnevezést kell alkalmaznunk, get prefix, utána az attribútum neve, aminek az első karaktere nagybetű, pl. getName()

4. **Attribútum, és a hozzá tartozó metódusok összefoglaló neve property**

   Válasz: private, getter, setter, üres konstruktor


## String
### Melyik típus a leginkább alkalmas szöveg tárolására?

1. **String**
2.  char
3. Integer
4.  Character

### Mely állítás igaz a String osztályra?

1. Hosszát a size() metódussal lehet lekérni

2. **Állapota nem módosítható**

3.  A toUpperCase() metódus az objektum állapotát módosítja úgy, hogy a kisbetűket nagybetűkre cseréli

4.  Értéke nem lehet null

   Válasz: a String immutable, méretét a .length(), toUpperCase() objektum állapotát nem módosítja hisz immutable

### Válaszd ki, hogy melyik értékadás a helyes!

1.  String s = 5;

2. String s = '5';

3.  **String s = "";**

4.  String s = (String) 5;

   Válasz: 5 az int, '5' az char, ilyen meg nem létezik (String)

### Melyik kód megfelelő Java String-ek összehasonlítására?

1.  s1 = s2
2.  s1 == s2
3.  **s1.equals(s2)**
4. Mindhárom

### Mit ír ki az alábbi kódrészlet?
String s = "dog";
s.toUpperCase();
System.out.println(s);

1.  **dog**

2.  DOG

3.  Nem fordul le

4.  Üres string-et

   Válasz: immutable .toUC nem változtat az objektumon

### Hogyan lehet egy szövegben sortörést elhelyezni?
1.  Csak System.out.println() használatával
2.  **String s = "a\nb";**
3.  String s = "a\BRCRb";
4.  String s = "a" + \n + "b";
5. Válasz: "\n"-nel lehet, 3,4 nem fordul le



### Ha String word = "banana", akkor melyik kifejezés adja vissza az első a betű helyét?

1. **word.indexOf("a")**
2.  word.charAt(2)
3.  word.lastIndexOf("a")
4.  indexOf(word, "a")

## Enum
### Melyik hamis a felsorolásos típusokkal kapcsolatban?
1. A felsorolásos típus elemeihez egy egész szám van rendelve
2.  String alapján is lehet a felsorolásos típus egy elemét elkérni
3.  switch szerkezetben használható
4.  **Felsorolásos típusnak nem lehet konstruktora**

### Melyik utasítással lehet végigmenni a felsorolásos típus elemein?
public enum Day {
FIRST, SECOND
}

1.  for (Day day: Day) {}
2.  **for (Day day: Day.values()) {}**
3.  for (Day day : Day.items()) {}
4.  for (Day day: Day.values) {}

## Kollekciók, tömb

### Milyen módon hivatkozhatunk az int[] numbers tömb első elemére? TÖMB

1. **numbers[0]**
2. numbers(0)
3.  numbers[1]
4.  numbers(i)

### Melyik utasítással lehet egy ötelemű tömböt definiálni? TÖMB

1.  **int[] x = {0, 1, 2, 3, 4};**

2. int[4] x;

3.  int array[] = int{5};

4.  int array[5] = new int[];

   Válasz: 2 nincs ilyen fordítási hiba, 3 egy elemű tömb, 4 fordítási hiba

### Mit ír ki az alábbi kódrészlet? TÖMB
int[] i = {1, 2, 3, 4};
System.out.println(i[4]);

1.  Nem fordul le

2.  0

3.  4

4. **IndexOutOfBoundsException kivétel keletkezik**

   Válasz: indexelés 0-tól kezdődik

### Mit ír ki az alábbi kódrészlet? TÖMB
`int[][] i = new int[3][3];`
`System.out.println(i[2][2]);`

1. Nem fordul le

2.  **0**

3.  2

4.  IndexOutOfBoundsException kivétel keletkezik

   Válasz: mindig kapnak kezdő értéket int -> 0, double -> 0.0, boolean -> false, referenciánál -> null;

### Milyen módon lehet egy listát feltölteni elemekkel? LISTA

1.  List names = {"Joe", "John"};

2.  **List names = Arrays.asList("Joe", "John");**

3. List names = new List

4. List names = new ArrayList

   Válasz: 1 fordítási hiba, 3-4 nem tölt fel listát
### Melyik állítás hamis a következők közül? TÖMB,LISTA
1.  A következő utasítás egy üres listát hoz létre: List names = new ArrayList
2. **A lista elemeit a következőképp adhatjuk meg: List names = {"Joe", "Jane"};**
3.  A lista mérete a size() metódussal kérdezhető le
4.  A listába új elemeket lehet hozzáadni, és elemeket lehet törölni

### Az alábbiak közül melyik állítás igaz? LISTA

1. **Több elemet egyszerre törölni a List names-ből az names.removeAll(namesToRemove) metódussal**
   **lehet, ahol az namesToRemove a törlendő elemek listája.**
2.  Az ArrayList belsejében egy tömb van, ezért a tömbökhöz hasonlóan előre meg kell adni a méretét
   létrehozáskor.
3.  Az List names legelső elemét az names.get(1) metódussal lehet elkérni.
4.  Bármilyen típusú érték kerülhet egy ArrayList-be, például: ArrayList integers = new ArrayList


### Melyik hamis a következő állítások közül? MÉRET
1.  A tömb mérete a következőképp kérdezhető le: names.length

2.  A String hossz a következőképp kérdezhető le: name.length()

3.  **Egy lista mérete a következőképp kérdezhető le: names.length()**

4.  A tömb és a lista indexelése nullától kezdődik

   Válasz: .size()

### Melyik állítás igaz a következők közül? Tömb,Lista
1. A tömb második eleméhez hozzáférhetünk a következő módon: names.get(1)

2.  A lista harmadik eleméhez hozzáférhetünk a következő módon: names.get(3)

3.  **A lista kiírása esetén (System.out.println) a lista elemei vesszővel elválasztva kerülnek kiírásra (toString metódus tehát helyesen implementált)**

4.  A tömb contains() metódusával lehet megnézni, hogy egy elem szerepel-e a tömbben

   Válasz: 1 helyesen names[1], 2 az a 4. elem, 4 contains() nincs a listánál

### Hogyan járjuk be egy lista elemeit? LISTA BEJÁRÁS
1. **for (String s: list) {System.out.println(s);}**
2. for (String s in list) {System.out.println(s);}
3. for each (String s: list) {System.out.println(s);}
4.  for (int i = 0; i



## Kivételezés
### Melyik igaz a kivételkezelésre?
1.  Csak beépített kivételeket használhatunk

2.  A keletkezett kivételt minden esetben kezelnünk kell a metódusban

3.  **A kivételt tovább dobhatjuk a hívónak**

4.  Az összes kivétel unchecked kivétel

   Válasz: lehet saját kivételt használni, tovább lehet dobni a kivételt, kivételek lehetnek checked is

### Melyik nem a kivétel kezeléshez kapcsolódó kulcsszó?

1. final
2. **try**
3.  catch
4.  throws

### Hogyan dobható Exception kézzel?

1. **throw new MyException();**

2.  throw MyException;

3.  throws new MyException();

4.  throws myException;




## KÓDRÉSZLET
### Mit ír ki az alábbi kódrészlet? OSZTÁLY HÍVÁS

```java
public class Incrementer {

    public int inc(int i) {
	return i + 1;
	}

public static void main(String[] args) {
int i = 5;
System.out.println(inc(i));
}
}
```

1.  **Nem fordul le**

2.  5

3.  6

4. Kivételt dob

   Válasz: new Incrementer.int(i) esetben fordult volna le, amugy fordítási hiba

### Mit ír ki az alábbi kódrészlet? KONSTRUKTOR
```java
public class WithName {
private String name;
public WithName(String name) {
name = name;
}
public String getName() {
return name;
}
public static void main(String[] args) {
WithName withName = new WithName("Joe");
System.out.println(withName.getName());
}
}
```
1.  Nem fordul le

2.  **null**

3. Joe

4.  IllegalArgumentException kivétel keletkezik

   Válasz: a konstruktorban nem a attribútumnak állítottuk be az értékét, igy maradt az alapértelmezett értéke ami null. Helyesen this.name = name.

### Mit ír ki az alábbi kódrészlet? PARAMÉTERÁTADÁS PRIMITIV TÍPÚS
```java
public class Incrementer {
public void inc(int i) {
i++;
}
public static void main(String[] args) {
int i = 5;
new Incrementer().inc(i);
System.out.println(i);
}
}
```
1.  **5**

2.  6

3.  Nem fordul le

4.  Kivételt dob

   Válasz: azért nem 6 mivel javában értékszerinti paraméter átadás van, és a primitivnél nincs visszahatás.

### Mi az értéke a következő kifejezésnek? OR OPERATOR
(3 > 5) || (1/0 == 0)

1.  true

2.  false

3.  **java.lang.ArithmeticException hiszen nullával való osztás van**

4.  0

   Válasz: ha 3<5 lenne akkor true lenne!!!

### Melyik kódrészlet nem helyes? + OPERÁTOR
1.  int a = 0; int b = 1; int c = a + b;

2.  Integer a = 0; Integer b = 1; Integer c = a + b;

3.  **BigInteger a = new BigInteger(0); BigInteger b = new BigInteger(1); BigInteger c = a + b;**

4.  String a = "0"; String b = "1"; String c = a + b;

   Válasz:a.add(b);

### Melyik értékadás helyes az alábbiak közül? KONVERZIÓ CASTOLÁS
1.  byte b = 300;

2.  long k = 10; int i = k;

3.  **long k = 10; int i = (int) k;**

4. long l = 2.5;

   Válasz: 1 fordítási hiba, ha castolnánk akkor 300-256=44 lenne, 2 fordítási hiba: castolni kell, 4 fordítási hiba ha castolnánk akkor 2 lenne

### Mit ír ki az alábbi kód? TÖMB WHILE
```java
public static void main(String[] args) {
int []a = {1,2,3,4,5,6};
int i = a.length - 1;
while(i>=0){
System.out.print(a[i]);
i--;
}
}
```
1.  123456
2.  **654321**
3.  65432
4.  IndexOutOfBoundsException

### Mit ír ki az alábbi kód? SCOPE
```java
public static void main(String[] args) {
for(int i = 0; i <= 5; i++){
System.out.print(i);
}
System.out.print(i);
}
```
1.  012345

2.  0123455

3.  **Nem fordul le**

4. IndexOutOfBoundsException

   Válasz: nem látja az i-t

### Mit ír ki az alábbi kód? SWITCH
```java
String s = "aaa";
switch (s) {
case "bbb":
System.out.print("3b");
case "aaa":
System.out.print("3a");
case "ccc":
System.out.print("3c");
}
```
1.  Nem fordul le, hiszen String van a switch
   feltételben

2.  3a

3.  **3a3c**

4. Kivétel keletkezik

   Válasz: mivel nincs break ezért tovább megy a következőre

### Mennyivel tér vissza az alábbi metódus, ha a következőképp hívjuk boolean isValid = isValidNumber("5");?
```java
public boolean isValidNumber(String number) {
try {
int value = Integer.parseInt(number);
if (value < 0 && value > 10) {
return true;
}
return false;
} catch (NumberFormatException nfe) {
return false;
}
}
```
1.  true
2.  **false**
3.  NumberFormatException keletkezik a hívás helyén
4.  Nem fordul le a kód

### Adott az alábbi kódrészlet: IMMUTABLE PARAMÉTER ÁTADÁS
```java
private String name;
private List<String> courses;
public TrainerData(String name, List<String> courses) {
this.name = name;
this.courses = new ArrayList<>(courses);
}
public String getName() {
return name;
}
public List<String> getCourses() {
return courses;
}
}
```
Melyik hamis az alábbi állítások közül?

1.  A TrainerData osztály name attribútuma osztályon kívülről módosítható, ugyanis nincs final módosítószóval ellátva

2.  A TrainerData immutable, még a courses lista tartalma sem változtatható kívülről

3.  A name attribútum módosítható,
   pl. így: new TrainerData("John Doe", Arrays.asList("Biology")).getName().toUpperCase();

4. **Mindhárom hamis**

   Válasz:1 hamis, mivel nincs setter és private, 2 hamis mivel a referenciáját nem változhatom de  tartalmát igen trainerData.courses.add("sör"); megoldás új referenciaként visszaadni, 3 hamis String immutable

### Mit ír ki az alábbi kódrészlet? THIS VISSZATÉRÉSI ÉRTÉK
```java
public class WithName {
private String name;
public WithName(String name) {
this.name = name;
}
public void modifyName(String name) {
return this.name;
}
public static void main(String[] args) {
System.out.println(new WithName("John Doe").modifyName("Jack Doe"));
}
}
```
1.  John Doe

2. Jack Doe

3. null

4. **Nem fordul le**

   Válasz: modifíName() az void de közben vissza add egy Stringet. Helyesen public String  modifíName()

### Mit ír ki az alábbi kódrészlet?
```java
public class Numbers {
public String addFive(String s) {
return s + 5;
}
public static void main(String[] args) {
System.out.println(new Numbers().addFive(10));
}
}
```
1.  105

2.  15

3.  **Nem fordul le**

4.  Futás közben kivételt dob

   Válasz: 10 az int és nem String. helyesen "10";

### Mit ír ki az alábbi kódrészlet? STRING LIST IMMUTABLE
```java
public class NameConverter {
public void convertNames(String name, List<String> otherNames) {
name = name.toUpperCase();
for (int i = 0; i < otherNames.size(); i++) {
otherNames.set(i, otherNames.get(i).toUpperCase());
}
}
public static void main(String[] args) {
String name = "John Doe";
List<String> names = new ArrayList<>(Arrays.asList("Jane Doe"));
new NameConverter().convertNames(name, names);
System.out.print(name);
System.out.print(" ");
System.out.print(names);
}
}
```
1.  **John Doe [JANE DOE]**

2.  JOHN DOE [JANE DOE]

3.  John Doe [Jane Doe]

4.  [John Doe, Jane Doe]

   Válasz: String immutable, a list tartalmán lehet változtatni

### Mit ír ki az alábbi kódrészlet? RETURN
```java
public class NameConverter {
public String convertName(String name) {
if (name.equals("")) {
return;
}
return name.toUpperCase();
}
public static void main(String[] args) {
System.out.println(new NameConverter().convertName(""));
}
}
```
1.  **Nem fordul le**

2.  Üres string, azaz ""

3.  null

4. Futás közben hiba keletkezik

   Válasz: nincs visszatérési érték.

### Mit ír ki az alábbi kódrészlet? Bejárás
```java
public List<Course> createCourses(String... names) {
List<Course> courses = new ArrayList<>();
// Bejárás
}
```
Melyik a helytelen módja a paraméterek bejárásának?

1.  for (String name: names) { courses.add(new Course(name)); }

2. for (int i = 0; i

3.  **for (int i = 0; i**

4.  Egyik megadási mód sem helyes

   Válasz: Hibás a pdf

### Mit ír ki az alábbi kódrészlet? THIS
```java
public class Builder {
private String name;
public Builder setName(String name) {
this.name = name;
return this;
}
public String build() {
return name;
}
public static void main(String[] args) {
System.out.print(new Builder().build());
System.out.print(" ");
System.out.print(new Builder().setName("John Doe").setName("Jack Doe").build());
}
}
```
1. Nem fordul le

2. **null Jack Doe**

3.  Jack Doe

4. null John Doe

### Adott az alábbi kódrészlet. STATIC METHOD
```java
public class Concatenator {
public static String convert(int a, int b) {
return Integer.toString(a) + Integer.toString(b);
}
public static void main(String[] args) {
// ???
}
}
```
A main metódusból hogyan lehet meghívni a convert metódust?

1.  Csak a Concatenator.convert(5, 6); utasítással
2.  Csak a convert(5, 6); utasítással
3.  Csak a new Concatenator().convert(5, 6); utasítással
4.  **Mindhárom utasítással, de nem mindegyik javasolt**

### Mit ír ki az alábbi kódrészlet? STATIC ATTRIBUTUM
```java
public class State {
private static int instance = 0;
public State() {
instance ++;
}
public static void main(String[] args) {
new State();
new State();
System.out.println(instance);
}
}
```
1.  Nem fordul le
2.  0
3.  1
4.  **2**

### Mit ír ki az alábbi kódrészlet? Feltételezzük, hogy a két osztály két külön .java fájlban van deklarálva, a megfelelő könyvtárakban. STATIC IMPORT
```java
package foo;
public class Foo {
public static int value = 10;
}
package bar;
import static foo.Foo;
public class Bar {
public static void main(String[] args) {
System.out.println(value);
}
}
```

1.  **Nem fordul le**

2. 10

3. 0

4. Futás közben hiba

   Válasz: Helyesen inport static foo.Foo.value vagy wildcar

### Adott a következő kódrészlet: KONSTRUKTOR
```java
public class Trainer {
private String name;
public Trainer(String name) {
this.name = name;
}
}
```
Mely állítás hamis az alábbiak közül?

1.  **Az osztály példányosítható a következő módon:**
   **Trainer t = new Trainer();**

2.  Az osztály példányosítható a következő módon:
   Trainer t = new Trainer("Anonymous");

3. Az osztály példányosítható a következő módon:
   Trainer t = new Trainer(null);

4. Nem kerül legenerálásra paraméter nélküli implicit konstruktor, hiszen van explicit konstruktor

### Adott a következő kódrészlet: KONSTRUKTOR
```java
public class Trainer {
private String name;
private int age;
public Trainer(String name) {
this(name, 0);
}
public Trainer(String name, int age) {
this.name = name;
this.age = age;
}
}
```
Az alábbi konstruktorok melyik nem illeszhető be a fenti osztályba harmadik konstruktorként?

1.  public Trainer() {this(null, 0);}

2.  public Trainer() {super();}

3.  **public Trainer() {String name = "anonymous"; this(name);}**

4.  public Trainer(int age) { this(null, age); }

   Válasz: this mindig a legelső

### Mit ír ki az alábbi kódrészlet? ÖRÖKLŐDÉS KONSTRUKTOR
```java
class A {
String s = "-";
protected A() { this("d"); s += "a"; }
private A(String e) { s += "d"; }
}
class B extends A {
B() { super(); s += "b"; }
}
class C extends B {
C() { s += "c"; }
public static void main(String... boo) {
System.out.println((new C()).s);
}
}
```
1.  **-dabc**

2.  -abc

3.  -adbc

4.  -cba

   Válasz: Konstruktorok nem öröklődnek, mindig az ős konstruktor hivódik meg előszőr vagyis C() -ben van egy rejtett super() ezért meghivja B() ami meghivja protected A()-at ami meg private A()-t igy akkor -+d+a+b+c = -dabc

### Mit ír ki az alábbi kódrészlet? INSTANCEOF
```java
class Ex1 {
public static void main(String[] args) {
int a[] = { 1,2,3,4}; // 1
System.out.print(a instanceof Object); // 2
}
}
```
1.  **true**

2. false

3. Nem fordul le az egyessel jelölt sor

4. Nem fordul le a kettessel jelölt sor

### Adott a következő kódrészlet: ÖRÖKLŐDÉS LÁTHATÓSÁG
```java
public class Human {
private String name;
}
```
Ha létrehozunk egy leszármazottat (Trainer extends Human), melyik állítás hamis?

1.  Leszármazottban elérhető a name attribútum, ha a Human osztályban protected láthatósági módosítóval látjuk el

2. Definiáljunk egy publikus gettert az attribútumnak, és akkor a leszármazottban is hozzá lehet férni a getterrel

3.  **A super.name hívással is hozzá lehet férni a leszármazottban**

4.  A protected módosítószó a package private kiterjesztése, használatakor nem csak az azonos csomagban lévő osztályok, hanem bármely leszármazott eléri az adott tagot

   Válasz: 1 igaz, 2 igaz, 3 hamis private nem látjuk, 4 igaz

### Adott a következő kódrészlet: ÖRÖKLŐDÉS
```java
class Mid {
public int findMid(int n1, int n2) {
return (n1 + n2) / 2;
}
}
public class Calc extends Mid {
public static void main(String[] args) {
int n1 = 22, n2 = 2;
// Egészítsd ki
System.out.println(n3);
}
}
```
Mit kell a megjegyzés helyére írni, hogy 12 értéket írja ki?

1.  **Calc c = new Calc(); int n3 = c.findMid(n1,n2);**

2.  int n3 = super.findMid(n1,n2);

3.  Calc c = new Mid(); int n3 = c.findMid(n1, n2);

4. int n3 = this.findMid(n1,n2);

   Válasz: 1 mivel public és nincs felülirva ezért látja, 2 nem fordul le, 3 se fordul le, 4 se fordul le

### Adott az alábbi kódrészlet: ÖRÖKLŐDÉS
```java
class Plant {
String getName() { return "plant"; }
Plant getType() { return this; }
}
class Flower extends Plant {
// Hiányzó kód
}
class Tulip extends Plant { }
```
Melyik sor nem illeszthető a hiányzó kód helyére?

1. Tulip getType() { return new Tulip(); }

2. Plant getType() { return this; }

3. **Object getType() { return this; }**

4. Flower getType() { return this; }

   Válasz:

    1 Tulipán típust vár vissza tulipánt kap vissza,

    2 Plant típust vár vissza Flower egy Plant

   3 Objectet vár vissza, Flowert kap fordítási hiba

   4 Flowert vár vissza Flowert kap

### Adottak a következő kódrészletek. ABSTRACT INTERFACE

```java
abstract class X {
public abstract void methodX();
}
interface Y {
}
```

Melyik kódrészlet helytelen?

1. class Z extends X implements Y { public void methodZ(); }

2. abstract class Z extends X implements Y { public void methodZ() {} }

3. class Z extends X implements Y { public void methodX() {} }

4. abstract class Z extends X implements Y { }

   Válasz:

   1. nem fordul le methodX() nincs felülírva vagy az osztály abstractá téve
   2. jó abstract ezért nem kötelező felülírnia
   3. felül van írva
   4. jó abstract ezért nem kötelező felülírnia

