element = input("Enter an element: ")

match element:
    case "Hydrogen":
        type = "Gas"
    case "Helium":
        type = "Gas"
    case "Nitrogen":
        type = "Gas"
    case "Oxygen":
        type = "Gas"
    case "Fluorine":
        type = "Gas"
    case "Neon":
        type = "Gas"
    case "Lithium":
        type = "Metal"
    case "Beryllium":
        type = "Semi-conductor"
    case "Boron":
        type = "Non-metal"
    case "Carbon":
        type = "Non-metal"
    case _:
        type = "Not one of the first ten elements"

print(type)