import { Estado } from './estado';
import { Moneda } from './moneda';
import { Tipo } from './tipo';
import { Ubicacion } from './ubicacion';

export class Preferencia {
    idPreferencia: string = null;
    tipo: Tipo = new  Tipo();
	estado: Estado = new  Estado();
	ubicacion: Ubicacion = new  Ubicacion();
    monedamenor: Moneda = new  Moneda();
	preciomenor: number= null;
	monedamayor: Moneda = new  Moneda();
	preciomayor: number= null;
}
