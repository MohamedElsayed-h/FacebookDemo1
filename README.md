# FacebookDemo
Uppgiften består av att bygga Webservers app liksom Facebooks startsidan via Spring Boots programm.
## Uppgiften består av:
* projekt + kod: projektet ska ha backend, frontend och MySQL.
* Dokumentation + UML.

# Dependencies i programmet:
* Spring Boot:
* * Spring MVC
* Spring JPA.
* Koder i pom.xml är:
***
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

***

***
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

***

***
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

***


## KravLista:
###Programmet ska kunna:
* spara data i MySQL (registrera sig i databasen).
* logga i med usernamn och lösenord (bekräfta logga i).
* använda frontendlogik.
* visa användarensdata.

 
#### Scenarium:
* Skapa användare.
* Ta bort användare.
* Lägga till profilbild.
* Byta profilbild.
* Skapa inlägg.
* Läsa inlägg.
* Ta bort användare sina egna inlägg.

##### Use Cases:
* Use case 1: Registrera sig.
* Use case 2: Logga in.
* Use case 3: Skriva inlägg
* Use case 4: Se all inlägg.
* Use case 5: Se all användare.
* Use case 6: Radera inlägg.

*OBS*:-
* Det finns include och extend för både kontrollera lösenord och inkludera bild till inlägg.
* Aktörer är användare, admin och MySQL.
