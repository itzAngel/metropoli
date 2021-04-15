import { DetalleAlquilerAgente } from './detalle-alquiler-agente';
import { DetalleAlquilerCliente } from './detalle-alquiler-cliente';
import { DetalleAlquilerClienteDestino } from './detalle-alquiler-cliente-destino';
import { DetalleAlquilerDocumento } from './detalle-alquiler-documento';
import { Moneda } from './moneda';
import { Propiedad } from './propiedad';

export class Alquiler {
    idAlquiler: string = null;
    propiedad: Propiedad = new  Propiedad();
    fechaContrato: Date = null;
    fechaInicio: Date = null;
    fechaFin: Date = null;
    moneda: Moneda = new  Moneda();
	precio: number = null;
	tipoComision: string = null;
	comisionTotal: number = null;
	comentario: string = null;
    listaDetalleAlquilerAgente: DetalleAlquilerAgente[] = [];
    listaDetalleAlquilerCliente: DetalleAlquilerCliente[] = [];
    listaDetalleAlquilerClienteDestino: DetalleAlquilerClienteDestino[] = [];
    listaDetalleAlquilerDocumento: DetalleAlquilerDocumento[] = [];
}
