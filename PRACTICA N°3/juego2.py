class Sensor:
    
    tipo: str = "Genérico"

    def __init__(self, id_sensor: str):
    
        self.id: str = id_sensor
        self.encendido: bool = False

    def activar(self):
        self.encendido = True
        print(f"Sensor {self.id} activado.")

    def desactivar(self):
        self.encendido = False
        print(f"Sensor {self.id} desactivado.")


class Camara(Sensor):

    tipo: str = "Cámara"

    def __init__(self, id_sensor: str, resolucion: str):
        Sensor.__init__(self, id_sensor)
    
        self.resolucion: str = resolucion


class SensorLuzLaser(Sensor):
    
    tipo: str = "Luz Laser"

    def __init__(self, id_sensor: str, alcance: int):
        Sensor.__init__(self, id_sensor)
    
        self.alcance: int = alcance


class VehiculoAutonomo(Camara, SensorLuzLaser):
    
    tipo: str = "Vehículo Autónomo"

    def __init__(self, id_sensor: str, resolucion: str, alcance: int):
    
        Sensor.__init__(self, id_sensor)
        self.resolucion = resolucion
        self.alcance = alcance

    def mostrar_info(self):
        print(f"=== Información del Vehículo Autónomo ===")
        print(f"Tipo: {self.tipo}")
        print(f"ID: {self.id}")
        print(f"Resolución de Cámara: {self.resolucion}")
        print(f"Alcance de Láser: {self.alcance} metros")
        print(f"Estado: {'Encendido' if self.encendido else 'Apagado'}")


if __name__ == "__main__":
    vehiculo = VehiculoAutonomo("VA-2026", "4K Ultra HD", 250)
    vehiculo.activar()
    vehiculo.mostrar_info()
    vehiculo.desactivar()