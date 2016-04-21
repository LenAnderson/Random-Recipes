def recipes = new File("recipes").listFiles() as List
Collections.shuffle(recipes)

def shopping = [:]
def servings = 0
def output = ""

recipes.find { recipe ->
    output += "${recipe.name[0..-5]}\r\n"
    servings += (recipe.name.replaceAll(~/^.+?( \((\d+)\))?\.txt$/, '$2')?:1) as Integer
    def ingredients = recipe.text.split("\r?\r\n")*.split("\t")
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
    servings >= 14
}
output += "\r\n-------------- $servings servings --------------\r\n\r\n"

def pad = shopping.keySet()*.length().max()
shopping.each { ingredient, quantities ->
    output += "$ingredient"
    quantities.eachWithIndex { uom, qty, idx ->
        if (idx > 0)
            output += " ".multiply(ingredient.length())
        output += " ".multiply(pad-ingredient.length()) + "  ${qty?qty+' ':''}$uom\r\n"
    }
}

new File("shopping.txt").text = output
