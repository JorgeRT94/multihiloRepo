cuentas = {("sevilla",41013) : [300,450,True], ("madrid",18650) : [400,300,False], ("segovia",28901) : [500,350,False], ("segovia",28902) : [450,500,True]} 

balancesPositivos = []

for x in cuentas.values(): 
    if (x[-1] == False):
        balancesPositivos.append(x[0] - x[1])

print(balancesPositivos)

umbral = int(input("Indique el umbral minimo de balance de positivo para buscar: "))

encontrado = False
i = 0
while i < umbral:
    
    if (balancesPositivos[i] >= umbral):
        encontrado = True
    else :
        i += 1

if (encontrado):
    print("Se ha encontrado este balance: " +str(balancesPositivos[i]))
else:
    print("No se ha encontrado ningun balance.") 