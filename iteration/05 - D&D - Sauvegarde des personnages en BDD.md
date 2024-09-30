---
title: 🐉 5-Sauvegarde des personnages en BDD 🐉
---

# :dragon: **ITÉRATION 5** :dragon: 

# Sauvegarde en BDD

## :green_book: Modalités

-   Travail en autonomie

-   Production individuelle

-   Durée : **2 jours**

## :sunny: Objectifs

-   Afficher des données d'une base de données via un programme Java

-   Mettre à jour une base de données depuis un programme Java

## :dart: Compétences

-   Accéder aux données avec JDBC

# 1 - Récupération des Héros en BDD

Nous souhaitons maintenant que la liste des personnages disponibles et
leurs attributs soient stockés dans une base de données. Au démarrage du
jeu, vous devez récupérer toutes les informations nécessaires en base de
données pour instancier les personnages que le joueur pourra choisir en
début de partie.

Nous allons utiliser une base de données MySQL.

Si vous n'en avez pas, vous pouvez installer sur votre Ubuntu comme dans
le lien suivant :

<https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04>

Nous vous laisserons créer une base de données **DonjonsEtDragons**

Vous créerez ensuite la table *Hero* qui contiendra les données suivantes (ceci reste un exemple, adaptez selon votre code) :

-   Id

-   Type (Magicien/Guerrier)

-   Nom

-   NiveauVie

-   NiveauForce

-   Arme/Sort

-   Bouclier

Testez votre connexion à votre base de données depuis votre code.

Pour cela vous risquez d'avoir besoin du driver jdbc c'est une librairie
externe qui permet d'interagir avec les bases de données depuis Java: 

<https://dbschema.com/jdbc-drivers/MySqlJdbcDriver.zip> (lien de
téléchargement direct)

Cela vous donne une librairie externe au format jar (c'est comme un zip
avec plein de classes dedans).

Il faut maintenant créer un dossier lib à la racine de votre projet dans
lequel vous allez déposer votre fichier jar.

Il faut ensuite que vous ajoutiez la dépendance dans votre projet,
c'est-à-dire que vous précisiez à votre projet d'utiliser ce fichier jar
ce qui permettra à vos classes d'utiliser celles fournies par la
librairie.

<https://www.geeksforgeeks.org/how-to-add-external-jar-file-to-an-intellij-idea-project/>

Vous allez maintenant créer une Classe dans un package « db » qui va
gérer votre connexion et vos requêtes.

Réussissez une requête SELECT \* sur votre table.

Bonne chance !

*Si vous avez des soucis de connexion, un fichier de configuration peut
être ajouté voir :*

<https://dbschema.com/jdbc-driver/MySql.html>

Maintenant que la connexion fonctionne,

-   Créer la méthode *getHeroes(),* permettant d'afficher la liste de
    tous les personnages. L'affichage des résultats se fera en mode
    console.

-   Créer la méthode createHero(Personnage) qui permet d'enregistrer un
    personnage en base de données une fois que l'utilisateur l'a créé
    depuis le menu principal

-   Créer la méthode editHero(Personnage) pour modifier un personnage
    existant sélectionné par l'utilisateur

-   Créer la méthode changeLifePoints(Personnage) qui enregistre la
    nouvelle valeur du niveau de vie du personnage après un changement
    durant le jeu

-   (**Optionnel)** Créer une table et les méthodes associées qui
    permettent d'enregistrer/récupérer le plateau depuis la base de
    données. C'est à vous de concevoir la table (Playboard ou Boxes)
    avec ses attributs qui doit contenir les armes/sorts et utiliser la
    table Hero qui contiendra également les ennemis.

# 2 -(Optionnel) Utiliser GSON pour sauvegarder des classes et les charger

Vous avez probablement remarqué que la sauvegarde des
OffensiveEquipements et DefensiveEquipements est un peu fastidieuse.
Cela nécessite soit des colonnes pour chaque attribut soit l'insertion
dans des bases de données supplémentaires.

Pour des objets simples, nous pouvons les enregistrer dans une seule
colonne de notre table Hero.

Pour cela nous allons les mettre au format json.

Nous allons utiliser la librairie Gson ( Jackson fonctionne aussi)

Dans un premier temps, téléchargez le fichier jar de la dépendance gson

<https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar>

Ajoutez ensuite la dépendance dansIntelliJ

Exemple de transformation d'une classe en json :

```java
Gson gson = new Gson();

String json = gson.toJson(obj);
```

Exemple d'utilisation pour la création d'un objet de classe User avec
les champs userId, userName depuis un json
```java
Gson gson = new Gson();

String jsonInString = "{\"userId\":\"1\",\"userName\":\"Yasir\"}";

User user= gson.fromJson(jsonInString, User.class);
```

## :mag_right: Ressources :

- <https://github.com/google/gson/blob/main/UserGuide.md>

-   <https://www.jmdoudoux.fr/java/dej/chap-jdbc.htm>

-   <https://www.tutorialspoint.com/jdbc/index.htm>

-   <https://www.baeldung.com/java-jdbc>

-   <https://www.geeksforgeeks.org/how-to-add-external-jar-file-to-an-intellij-idea-project/>

-   <https://dbschema.com/jdbc-driver/MySql.html>

## :gift: Livrables
- Codes des itérations à déposer sur GitHub.
- Un glossaire enrichi des différentes syntaxes utilisées est à déposer sur votre GitHub.
