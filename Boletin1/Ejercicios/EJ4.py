import sqlite3
# Crear conexión
conn = sqlite3.connect('mydatabase.db')
# Obtener cursor
cursor = conn.cursor()
# Ejecutar sentencia de creación de tabla
#cursor.execute("CREATE TABLE IF NOT EXISTS employees(id integer PRIMARY KEY, name text, salary real)")
#conn.commit()
# Ejecutar sentencia de inserción
# cursor.execute("INSERT INTO  employees VALUES(1, 'U', 700)") 
#conn.commit()
# cursor.execute("INSERT INTO employees VALUES(2, 'RE', 700)") 
#conn.commit()
# cursor.execute("INSERT INTO employees VALUES(3, 'LIO', 700)") 
#conn.commit()

# Recorriendo las filas devueltas por fetchall
cursor.execute('SELECT salary FROM employees') 
rows = cursor.fetchall()
salarios  = 0

for x in rows:
    salarios += x[0]
    x = rows

cursor.execute('SELECT name FROM employees')
rows = cursor.fetchall()
nombres = ""

for x in rows:
    nombres += x[0] + ", "

print("La suma de los salarios es de los empleados " + nombres + " es: " + str(salarios))
conn.close()
