from ventas.presupuesto import Cliente, ModeloPresupuesto

cliente = Cliente ("Jorge", "Richarte Torres")
modeloPresupuesto = ModeloPresupuesto(cliente, "Medac", "23/11/2021", "Reparacion", 159.99, "23/11/2022")
print(modeloPresupuesto)
