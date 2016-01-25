#Teoria

##Algorytmy heurystyczne vs Algorymtmy ewolucyjne

Działanie **algortmów heurystycznych** polega na znajdowaniu rozwiązań, jednak bez gwarancji znalezienia optymalnego rozwiązania. Przeszukiwanie rozwiązań w zadanej przestrzeni nie jest przeszukiwaniem ślepym tj. proces przeszukiwania jest oceniany pod względem zlanezionego rozwiązania.
**Algorytmy ewolucyjne** inspirowane są teoriami doboru naturalnego, pozwalają na "wychodowanie" najlepszego rozwiązania. Wyszukiwanie postawionego problemu polega na zestawieniu ze sobą różnych możliwych rozwiązań, krzyżowaniu, rozmnażaniu, ocenie ich i wyborze najlepszego.

###Angorytm wspinaczkowy
 Należący do zbioru algorymów heurystycznych algorytm, którego działanie oparte jest na iteracyjnym poprawianiu otrzymywanych rozwiązań, jego ogólna zasada dziłania polega na wystartowaniu z losowego punktu, przeglądu oraz wyboru sąsiada który ma najlepszą wartość rozwiązania, działanie powtarzamy do osiągnięcia lokalnego maximum.

Ogólny szkielet algorymu wspinaczki:

       Choose randomly initial solution x
        Do
          best <- first neighbor of x
          For all y in the neighborhood of x
             If (f(y) > f(best))
                best <- y
             endif
          endfor
          If (f(x) < f(best))
             x <- best
             continue <- true
          else
             continue <- false
          endif
          While continue == true

####Pojęcie sąsiedztwa

Ważne dla zrozumienia tego algorytmu jest pojęcie sąsiada. Sąsiedztwo jest zdefiniowane na przestrzeni stanów jako podobieństwo kompletnych rozwiązań. 

![alt text](http://paradiseo.gforge.inria.fr/pub/img/schemaLS.jpg "http://paradiseo.gforge.inria.fr/pub/img/schemaLS.jpg")

W podejmowanym problemie (problem komiwojażera) przestrzenią stanów (rozwiązań) są kompletne ścieżki, podobieństwo kompletnych ścieżek (rozwiązań) polega na np. zamianie kolejności poszczególnych miast, czyli nie wielkiej modyfikacji poszczególnych rozwiązań (lokalne przeszukiwanie i poprawa rozwiązań)
Do zdefiniowania lokalnego wyszukiwania i poprawiania trzeba zdefiniować:

1. reprezentacje rozwiązania

2. reprezentacje sąsiada

3. funkcję oceny rozwiązania

4. funkcję oceny sąsiada

5. sąsiedztwo (generowanie sąsiadów)

###Algorymt genetyczny (klasyczny)
 By zrozumieć zasadę działania tego algorytmu, trzeba przedstawić podstawowe pojęcia z dziedziny algorytmów ewolucyjnych:

- Osobnik - przykładowe rozwiązanie zadania (punkt z przestrzeni stanów)

- Populacja - zespół osobników zamieszkujących wspólne środowisko i konkurujących o jego zasoby.

- Fenotyp - parametry (cechy) rozwiązania, które podlegają ocenie.

- Genotyp - cechy rozwiązania (punktu z przestrzeni stanów) kodowane są w określony sposób, np. za pomocą ciągów binarnych ustalonej długości (odpowiednikiem genotypu osobnika jest w tym przypadku ciąg bitów).

- Chromosom - miejsce przechowywania genotypu osobnika.

- Kodowanie rozwiązań - sposób zapisania dowolnego dopuszczalnego rozwiązania problemu w postaci genotypu osobnika (np. ciągu bitów). Kodowanie musi zapewniać jednoznaczność dekodowania - każdemu genotypowi (np. każdej kombinacji bitów) musi odpowiadać pewne rozwiązanie zadania, czyli punkt z przestrzeni stanów. Musimy też się postarać, by każde rozwiązanie dało się zapisać w postaci genotypu.

- Funkcja przystosowania (fitness) - funkcja pozwalająca dla danego osobnika określić jego jakość (z punktu widzenia rozwiązywanego problemu). Zakładamy, że jej wartości są rzeczywiste nieujemne oraz że wyższa wartość funkcji oznacza zawsze, że dany osobnik jest lepszy. W przypadku ewolucji naturalnej odpowiednikiem takiej funkcji jest ogólna ocena przystosowania osobnika do danego środowiska. W praktyce funkcja ta jest zwykle niewielką modyfikacją funkcji celu rozwiązywanego problemu

- Funkcja celu - funkcja dla której szukane jest optymalne rozwiązanie

Etapy które można wyznaczyć w tym algorytmie to :

1. Kodowanie problemu

2. Dobieranie populacji początkowej

3. Stosowanie operatorów genetycznych - mutacji i krzyżowania

4. Liczenie wartości funkji celu osobników

5. Dokonanie selekcji osobników

6. Populacja końcowa staje się bieżącą, wracamy do punktu drugiego

Ogólny szkielet klasycznego algorytmu genetycznego:

    losuj populacje();
    for (...){ // po pokoleniach
        sortuj populacje();
        usuń najgorszych();
        skrzyżuj najlepszych();
        sortuj populacje(); //musimy posortować tutaj gdyż zwykle nie mutuje się najlepszego osobnika;
        mutuj();
    } //koniec pętli po pokoleniach


#Implementacja


**Funkcja celu: [problem komiwojażera](https://pl.wikipedia.org/wiki/Problem_komiwoja%C5%BCera)**

Celem jest znalezienie najkrótszej drogi łączącej wszystkie miasta zaczynającej się i kończącej się w określonym punkcie.


![alt text](https://github.com/marcinsirocki/Genetic-vs-Hil-Climbing/blob/master/resources/schemat.png?raw=true "")

Powyższy rysunek ma na celu przedstawienie kilku założeń:

 - każdy punkt jest ze sobą połączony
 - punkty na siatce odpowiadają wartością w zaimlementowanej macierzy
 - dla tras jest liczona tylko odległość (bez kosztów i czasu)
 
Przed implementacją warto zapoznać się ze wzorem na odległość dwóch punktów na płaszczyźnie:

    Dla punktu z [Ux,Uy] do [Vx,Vy] wzór jest zdefiniowany sqrt((Ux-Vx)^2 + (Uy-Vy)^2)
 
**Wyniki:**

**Podsumowanie:**

**Źródła**

[http://edu.pjwstk.edu.pl/wyklady/nai/scb/wyklad5/w5.htm](http://edu.pjwstk.edu.pl/wyklady/nai/scb/wyklad5/w5.htm)

[http://edu.pjwstk.edu.pl/wyklady/nai/scb/wyklad10/w10.htm](http://edu.pjwstk.edu.pl/wyklady/nai/scb/wyklad10/w10.htm)

[http://paradiseo.gforge.inria.fr/index.php?n=Doc.TutoMOLesson1](http://paradiseo.gforge.inria.fr/index.php?n=Doc.TutoMOLesson1)