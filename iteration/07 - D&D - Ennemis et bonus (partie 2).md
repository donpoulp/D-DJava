---
title: 🐉 7-Ennemis et bonus (partie 2)🐉
---
# :dragon: **ITÉRATION 7** :dragon:

# Remplissage du plateau complet (partie 2)

## :green_book: Modalités

-   Travail en autonomie

-   Production individuelle

-   Durée : **2 jours**

## :sunny: Objectifs

-   Manipuler les collections JAVA

## :dart: Compétences

-   Manipuler les collections d'objets

-   Modéliser avec UML les diagrammes de classe

## 1 - Diversification des ennemis et caisses surprises

Avant d'en arriver à pouvoir créer le plateau complet il nous manque
encore pas mal de classes différentes :

-   Les dragons

-   Les sorciers

-   les gobelins

-   les massues

-   les épées

-   les éclairs

-   les boules de feu

-   les potions standards

-   les grandes potions

Pour cela :

-   Créez ces classes en leur donnant les bonnes relations d'héritage
    avec vos classes existantes. Implémentez la méthode toString() de
    chacune de ces classes.

-   Agrandissez le mini plateau à 4 cases.

-   Rajoutez une instance de chacune des classes précédentes

-   Parcourez le plateau obtenu en appelant la méthode toString() de
    chacune des cases.

-   Vérifiez que les résultats soient cohérents.


## 2 - Interaction fine entre les personnages et les cases

A la lecture des règles il est écrit que le Guerrier peut ramasser des
armes mais pas de sorts. Le Magicien quant à lui peut ramasser des sorts
mais pas d'arme. Il va nous falloir gérer ces subtilités.

1.  Il va falloir commencer par créer une méthode *interaction*() dans
    la classe ***Case.*** Elle prendra en paramètre un ***Personnage*** !

2.  Pour pouvoir gérer les interactions en fonction des classes. Vous
    pouvez aller voir le mot clé *instanceof* : [Java instanceof and its applications](https://www.geeksforgeeks.org/java-instanceof-and-its-applications/)
    Cela vous permettra de tester la classe de l'objet reçu et d'adapter
    le comportement en conséquence. Pour vous assurer que la structure
    générale fonctionne, vous pouvez d'abord coder un comportement très
    simple (un simple print suffira).

3.  Une fois la structure mise en place. Vous pourrez coder les
    comportement appropriés pour les caisses surprise et armes
    (augmentation de la vie ou force dans les limites des capacités des
    héros). Pour les combats, un simple print suffira pour commencer.

4.  Créez le plateau complet et pensez à le dé :

-   24 ennemis:

    -   4 Dragons (case 45, 52, 56 et 62)

    -   10 Sorciers (case 10, 20, 25, 32, 35, 36, 37, 40, 44 et 47)

    -   10 Gobelins(case 3, 6, 9 , 12, 15, 18, 21, 24, 27 et 30)

-   24 caisses surprises:

    -   5 Massues (case 2, 11, 5, 22, 38)

    -   4 Epées (case 19, 26, 42 et 53)

    -   5 Sorts \"éclair\" ( case 1, 4 , 8, 17 et 23)

    -   2 Sorts "boules de feu" (case 48 et 49)

    -   6 Potions standards (case 7, 13, 31, 33, 39, 43)

    -   2 grandes Potions (case 28, 41)

Ces données sont un point de départ, n'hésitez pas à les adapter selon
la jouabilité. Vous avez une grande latitude sur l'interprétation des
règles dans ce module. Utilisez là et prenez des initiatives !



## 3 - Cases aléatoires

Dans cette itération, les cases ne sont plus placées de manières fixes
mais de manière aléatoire. Attention cependant le nombre d'ennemis et
d'équipement doit rester le même que précédemment.

# :gift: Livrables
- Codes des itérations à déposer sur GitHub.
- Un glossaire enrichi des différentes syntaxes utilisées est à déposer sur votre GitHub.

# :mag_right: Ressources
-   [Gérez les piles de données avec la bonne collection]( https://www.geeksforgeeks.org/java-instanceof-and-its-applications/)

-   *Tutoriel d'Oracle pour Java* :

[Trail: Learning the Java Language (The Java™ Tutorials)](http://docs.oracle.com/javase/tutorial/java/index.html)

-   *Autre* :

[Java instanceof and its applications]( https://www.geeksforgeeks.org/java-instanceof-and-its-applications/)
