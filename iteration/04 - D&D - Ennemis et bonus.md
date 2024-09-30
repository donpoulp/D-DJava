---
title: 🐉 4-Ennemis et bonus (partie 1)🐉
---
# :dragon: **ITÉRATION 4** :dragon:

# Remplissage du plateau simplifié avec ennemis et bonus (partie 1)

## :green_book: Modalités

-   Travail en autonomie

-   Production individuelle

-   Durée : **2 jours**

## :sunny: Objectifs

-   Manipuler les collections JAVA

## :dart: Compétences

-   Manipuler les collections d'objets

-   Modéliser avec UML les diagrammes de classe

# 1 - Récapitulatif

Au stade où nous en sommes du projet vous avez/ allez avoir plusieurs
classes :

-   Vos classes concrètes ***Guerrier*** et ***Magicien*** héritent
    d'une classe abstraite ***Personnage***.

    -   Les attributs *noms*, *force*, *niveau de vie* et *arme* (et
        éventuellement *vie_max* et *attaque_max*) sont rangés dans la
        classe Personnage.

    -   La classe ***Personnage*** redéfinit la méthode toString() pour
        retourner une représentation en String de vos objets

> Par exemple : \"Personnage : Thor, Niveau de vie : 5, Force : 5\

-   Vos classes concrètes ***Arme, Sort, Bouclier et Philtre*** héritent
    des classes abstraites ***EquipementOffensif*** et
    ***EquipementDefensif***..

-   Une classe ***Menu*** qui permet d\'interagir avec l'utilisateur au
    travers de messages et d'objets de type Scanner (pour lire les
    entrées clavier). Cette classe ne possède pas d'attribut. Elle
    contient des méthodes telles que afficherMenuAccueil(),
    modifierInfoPerso(), afficherMsgQuitter(), etc\...

Si vous n'avez pas exactement la même structure, pas d'inquiétude.

Vous pouvez faire le diagramme UML de votre propre structure de code.

## :dart: Compétences

-   Modéliser avec UML les diagrammes de classe

# 2 - Le plateau du jeu

Nous devons nous poser la question de savoir où réside l'information
liée au plateau de jeu, ainsi que la position du ***Personnage*** sur ce
plateau. Je vous propose de créer une classe que nous appellerons
***Game***.

Cette classe aura plusieurs méthodes dont au minimum :

-   une méthode *jouer_un_tour()* qui sera en charge de lancer le dé,
    faire avancer le joueur, le faire interagir avec le plateau de jeu
    (s'équiper d'un bonus, lancer un combat, etc.), mettre à jour le
    statut d'avancement du jeu (en cours, quitter la partie, personnage
    mort, etc.). Et plus tard, de gérer plusieurs joueurs.

Cette classe aura plusieurs attributs dont au minimum :

-   Un attribut représentant le plateau ainsi qu'un attribut que nous
    pourrons appeler *positionJoueur*.

-   Un attribut représentant le plateau de jeu en lui-même. La manière
    la plus simple de le représenter étant sous la forme d'une ArrayList
    de Cases (oui, mais quel genre de Case ?)

## CONSEIL AVANT DE LIRE LA SUITE

-   Il est très important que vous réfléchissiez bien à la manière
    d'organiser les \"couches d'abstraction\" de votre programme.
    Qu'est-ce qu'une Case ? Comment est représenté le plateau ? Quelle
    est la relation entre un ennemi, un bonus et une case vide ?

-   Je vous donne la réponse à cette interrogation fondamentale deux
    pages après. Mais **essayez** d'y réfléchir 10 minutes avant de lire
    la solution.

![](./ressources/image4.png)
*Il pense très fort*



# 3- Le plateau du jeu (solution)

## 3.1 Solutions

-   Si vous avez pensé à créer une **classe abstraite *Case, ***c'est
    une très bonne idée! En effet, le plus simple est probablement de
    considérer un lien de parenté entre tous les objets qui vont résider
    sur le plateau : ***Caisses surprise***, ***Armes***,
    ***Bouclier***, ***Ennemis***, ***Case vide***, etc...

-   MAIS. Nous allons choisir une autre option. Nous vous proposons de
    créer plutôt une **Interface** Case.

-   Le plateau sera donc un ArrayList\<Case\> que vous remplirez avec
    des new Arme(),

> new Ennemi(), etc...

-   Vous n'avez pas d'autre choix que d'instancier votre plateau de jeu
    **en dur**. C\'est-à-dire rentrer les cases une à une avec leur
    position. Allez voir dans les ressources comment manipuler une
    ArrayList.

## 3-2 Description du plateau de jeu à créer (version simplifiée) :

On commencera par une version simplifiée du plateau (il ne contient que
4 cases) et un dé pipé (le dé renvoie toujours 1). On créera donc un
plateau de la forme suivante :

-   Case 1 : une case vide

-   Case 2 : un ennemi (nouvelle classe à créer)

-   Case 3 : une arme

-   Case 4 : une potion (nouvelle classe à créer)

Cela vous permettra de tester les interactions entre vos personnages et
les cases plus facilement.

Votre personnage devra donc se déplacer sur le plateau à chaque tour de
jeu, et interagir avec les ***Cases*** via la méthode *toString()* de
chacune d'entre elles (dans un premier temps).

# 4 - Etat des lieux de la classe main

Votre classe ***main*** ne doit pas être trop longue. Elle sert
uniquement à initialiser et lancer le jeu. Elle ressemblera à quelque
chose comme ceci :

![](./ressources/image5.png)
## :gift: Livrables
- Codes des itérations à déposer sur GitHub.
- Un glossaire enrichi des différentes syntaxes utilisées est à déposer sur votre GitHub.

## :mag_right: Ressources

-   *Openclassrooms*
    [https://openclassrooms.com/en/courses/6173501-debutez-la-programmation-avec-java/6458461-gerez-les-piles-de-donnees-avec-la-bonne-collection](https://openclassrooms.com/en/courses/6173501-debutez-la-programmation-avec-java/6458461-gerez-les-piles-de-donnees-avec-la-bonne-collection)

-   [https://www.codeurjava.com/p/java-les-collections.html](https://www.codeurjava.com/p/java-les-collections.html)

-   [https://medium.com/@tushar0618/java-collections-cheat-sheet-3ee5c4fc11d7](https://medium.com/@tushar0618/java-collections-cheat-sheet-3ee5c4fc11d7)
