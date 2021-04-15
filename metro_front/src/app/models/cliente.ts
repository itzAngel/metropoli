import { Agente } from './agente';
import { AsignaPropiedadCliente } from './asigna-propiedad-cliente';
import { DetalleAlquilerCliente } from './detalle-alquiler-cliente';
import { DetalleAlquilerClienteDestino } from './detalle-alquiler-cliente-destino';
import { DetalleVentaCliente } from './detalle-venta-cliente';
import { DetalleVentaClienteDestino } from './detalle-venta-cliente-destino';
import { Imagen } from './imagen';
import { Pedido } from './pedido';
import { Preferencia } from './preferencia';
import { Seguimiento } from './seguimiento';

export class Cliente {
    idCliente: string = null;
	nombre: string = null;
	apellido: string= null;
	estadoCliente: string= null;
    foto: string= null;
	telefono: string= null; 
	correo: string= null;
	dni: string= null;
    fechaIngreso: Date= null;
    fechaActualizacion: Date= null;
	comentario: string= null;
    preferencia: Preferencia = new  Preferencia();
    agente: Agente = new  Agente();
    modoCaptacion: string= null;
    empresa: string= null;
    habilitado: string= null;
    listaAsignaPropiedadCliente: AsignaPropiedadCliente[]= [];
    listaSeguimiento: Seguimiento[]= [];
    listaPedido: Pedido[]= [];
    listaDetalleVentaCliente: DetalleVentaCliente[] = [];
    listaDetalleVentaClienteDestino: DetalleVentaClienteDestino[]= [];
    listaDetalleAlquilerCliente: DetalleAlquilerCliente[]= [];
    listaDetalleAlquilerClienteDestino: DetalleAlquilerClienteDestino[]= [];
}
