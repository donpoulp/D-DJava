---
title: 🐉 6-Gestion des combats 🐉
---
# :dragon: **ITÉRATION 6** :dragon:

# Gestion des combats

## :green_book: Modalités

-   Travail en autonomie

-   Production individuelle

-   Durée : **2 jours**

## :sunny: Objectifs

-   Implémenter la logique de gestion des combats

-   Solidifier les compétences JAVA

## :dart: Compétences

- Manipuler les collections d'objets

- Modéliser avec UML les diagrammes de classe

## 1 - Combats simples

Maintenant que le plateau de jeu est complètement en place, vous devez
dans cette itération (lorsque le héro rencontre un ennemi) ajouter la
gestion des combats. Vous devez également gérer la fin de partie si le
joueur perd tous ses points de vie ou s\' il arrive victorieusement au
bout du plateau.

Lors d'une interaction avec un ennemi le personnage frappe l'ennemi avec
la force définie par son équipement (force de base + arme ou sort) et le
niveau de vie de l'ennemi diminue en conséquence.

-   Si le niveau de vie de l'ennemi atteint 0, ce dernier meurt.

-   Sinon l'ennemi réplique et le niveau de vie du personnage diminue en
    fonction de la force de frappe de l'ennemi. Ce dernier s'enfuit
    lorsqu'il vous a frappé.

-   **Note** : Le niveau de vie d'un même ennemi (sur une
    même case) doit être persistant d'un tour à l'autre. Si le joueur
    parvient à vaincre totalement un ennemi (niveau de vie à 0), cet
    ennemi doit disparaître du plateau.

### CONSEIL

Réfléchissez à l'endroit où "ranger" cette logique de code. Plusieurs
solutions sont possibles.

## 2 - Combats au tour par tour

Nous allons maintenant essayer de rendre les combats plus intéressants :

-   Le combat se jouera au tour par tour, votre personnage attaquera
    toujours le premier.

-   A chaque tour vous avez le choix entre attaquer et fuir.

-   L'ennemi ne peut qu'attaquer.

-   En cas de fuite, vous reculez d'un nombre de cases aléatoires (entre
    1 et 6).

# :gift: Livrables
- Codes des itérations à déposer sur GitHub.
- Un glossaire enrichi des différentes syntaxes utilisées est à déposer sur votre GitHub.

# :mag_right: Ressources

-   [Gérez les piles de données avec la bonne collection](https://openclassrooms.com/en/courses/6173501-debutez-la-programmation-avec-java/6458461-gerez-les-piles-de-donnees-avec-la-bonne-collection)

-   *Tutoriel d'Oracle pour Java* :

[Trail: Learning the Java Language (The Java™ Tutorials)](http://docs.oracle.com/javase/tutorial/java/index.html)

-   *Autre*

> [Java instanceof and its applications](https://www.geeksforgeeks.org/java-instanceof-and-its-applications/)
