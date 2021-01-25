class Cliente:
    
    def __init__(self, nombre, apellidos):
        self.__nombre = nombre
        self.__apellidos = apellidos

    @property
    def nombre (self):
        return self.__nombre
    
    @nombre.setter 
    def setNombre (self, nombre):
        self.__nombre = nombre

    @property
    def apellidos (self):
        return self.__apellidos

    @apellidos.setter 
    def setApellidos (self, apellidos):
        self.__apellidos = apellidos

    def __str__(self):
        txt = "Nombre: " +self.__nombre
        txt += "\nApellidos: " +self.__apellidos
        return txt

class ModeloPresupuesto:

    titulo = "PRESUPUESTO"
    encabezado_nombre = "Eugenia Bahit" 
    encabezado_web = "www.eugeniabahit.com.ar" 
    encabezado_email = "mail@mail.com"
    IVA = 21
    divline = "="*80

    def __init__(self, cliente, empresa, fecha, servicio, importe, vencimiento):
        self.__cliente = cliente
        self.__empresa = empresa
        self.__fecha = fecha
        self.__servicio = servicio
        self.__importe = importe
        self.__vencimiento = vencimiento
        self.calcular_iva()
        self.calcular_neto()


    @property
    def cliente(self):
        return self.__cliente

    @cliente.setter
    def setCliente(self, cliente):
        self.__cliente = cliente
    
    @property
    def empresa(self):
        return self.__empresa

    @empresa.setter
    def setEmpresa (self, empresa):
        self.__empresa = empresa

    @property
    def fecha (self):
        return self.__fecha
    
    @fecha.setter
    def setFecha (self, fecha):
        self.__fecha = fecha
    
    @property
    def servicio (self):
        return self.__servicio

    @servicio.setter 
    def setServicio (self, servicio):
        self.__servicio = servicio

    @property
    def importe (self):   
        return self.__importe

    @importe.setter
    def importe (self, importe):
        self.__importe = importe

    @property
    def vencimiento (self):
        return self.__vencimiento

    @vencimiento.setter
    def vencimiento (self, vencimiento):
        self.__venimiento = vencimiento

    @property 
    def neto (self):
        return self.neto

    @property
    def monto_iva (self):
        return self.monto_iva

    def calcular_iva(self):
        self.__monto_iva = float(self.importe) * float(self.IVA/100)
        
    def calcular_neto( self):
        self.__neto = float(self.importe) + float(self.__monto_iva)

    def __str__(self):
        
        txt = '\n'+self.divline+'\n'
        txt += '\t'+self.encabezado_nombre+'\n'
        txt += '\tWeb Site: '+self.encabezado_web+' | '
        txt += 'E-mail: '+self.encabezado_email+'\n'
        txt += self.divline+'\n'
        txt += '\t'+self.titulo+'\n'
        txt += self.divline+'\n\n'
        txt += '\tFecha: '+self.__fecha+'\n'
        txt += '\tEmpresa: '+self.__empresa+'\n'
        txt += '\tCliente: '+self.__cliente.nombre+'\n'
        txt += self.divline+'\n\n'
        txt += '\tDetalle del servicio:\n'
        txt += '\t'+self.__servicio+'\n\n'
        txt += '\tImporte: €%0.2f | IVA: €%0.2f\n' % (float(self.__importe), float(self.__monto_iva))
        txt += '-' * 80
        txt += '\n\tMONTO TOTAL: €%0.2f\n' % (float(self.__neto))
        txt += self.divline+'\n'
        print (txt)