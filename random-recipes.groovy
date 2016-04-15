def recipes = new File("recipes").listFiles() as List
Collections.shuffle(recipes)
recipes = recipes[0..Math.min(recipes.size()-1,13)]

def shopping = [:]

recipes.each { recipe ->
    println recipe.name[0..-5]
    def ingredients = recipe.text.split("\r?\n")*.split("\t")
    ingredients.each { ingredient ->
        def qty = 0
        def uom = "some"
        if (ingredient.length > 1) {
            qty = (ingredient[1].replaceAll(~/^(\d+(\.\d+)?)?\s*([^\d]+)?$/, "\$1")?:0) as Integer
            uom = ingredient[1].replaceAll(~/^(\d+(\.\d+)?)?\s*([^\d]+)?$/, "\$3")
        }
        if (!shopping[ingredient[0]]) {
            shopping[ingredient[0]] = [:]
        }
        if (!shopping[ingredient[0]][uom]) {
            shopping[ingredient[0]][uom] = qty
        } else {
            shopping[ingredient[0]][uom] += qty
        }
    }
}
println "\n--------------------------\n"

def pad = shopping.keySet()*.length().max()
shopping.each { ingredient, quantities ->
    print "$ingredient"
    quantities.eachWithIndex { uom, qty, idx ->
        if (idx > 0)
            print " ".multiply(ingredient.length())
        print " ".multiply(pad-ingredient.length()) + "  ${qty?qty+' ':''}$uom\n"
    }
}
System.console().readLine "\n\nPress any key to continue."
