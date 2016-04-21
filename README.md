# Random-Recipes
This script will select random recipes to reach 14 or more servings from a folder of text files and compiles a shopping list for the ingredients.



## Setup
1. In the same location as the script create a folder named "recipes".
2. For each recipe create a .txt file in the recipes folder. The name of the file is the recipe's name, followed by the number of servings in parentheses. The file should contain only the list of ingredients with one ingredient per line (name of ingredient, followed by a tab, followed by the quantity).
3. Run the script.
4. Go shopping.
5. Prepare your meals and make your tummy happy :)



## Using the compiled JAR file
Download the JAR file from the [latest release](https://github.com/LenAnderson/Random-Recipes/releases).



## Sample
##### Input
Github / markdown replaces tabs with spaces. The spaces between the ingredients name and the quantity should be one single tab.

    [pancakes.txt]
    flour	250g
    eggs	3
    milk	250ml
    water	250ml
    butter	100g
    sugar	some
    vanilla sugar	1 package
    
    [pasta salad (8).txt]
    tomatoes	500g
    gouda	300g
    pasta	250g
    miracel whip	8 tablespoons
    ketchup	4 tablespoons
    garlic	1 clove
    
    [meatballs (6).txt]
    ground meat	750g
    onions	1
    eggs	1
    ketchup
    water	2 tablespoons
    breadcrumbs 5 tablespoons
    
    [zucchini-mushroom-pasta (7).txt]
    zucchini	1
    mushrooms	200g
    onions	2
    balsamico
    vegetable stock	1 teaspoon
    cream
    pasta	500g

##### Output
    [shopping.txt]
    pancakes
    meatballs (6)
    zucchini-mushroom-pasta (7)
    
    -------------- 14 servings --------------
    
    flour            250 g
    eggs             4 
    milk             250 ml
    water            250 ml
                     2 tablespoons
    butter           100 g
    sugar            some
    vanilla sugar    1 package
    ground meat      750 g
    onions           3 
    ketchup          some
    breadcrumbs      5 tablespoons
    zucchini         1 
    mushrooms        200 g
    balsamico        some
    vegetable stock  1 teaspoon
    cream            some
    pasta            500 g
