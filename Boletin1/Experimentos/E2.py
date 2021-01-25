cuentas = [(300,450),(400,300),(500,350),(450,300)]
# el primer numero indica ingresos, el segundo gastos. 
impares = cuentas[::3]
print(impares)
dosPrimeros = cuentas[:2]
print(dosPrimeros)
dosUltimos = cuentas[2:]
print(dosUltimos)
pares = cuentas[1::2]
print(pares)
primeroYultimo = cuentas[0], cuentas[-1]
print(primeroYultimo)