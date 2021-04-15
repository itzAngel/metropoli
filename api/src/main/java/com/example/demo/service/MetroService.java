package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Agencia;
import com.example.demo.model.Agente;
import com.example.demo.model.Alquiler;
import com.example.demo.model.AsignaAgencia;
import com.example.demo.model.AsignaPrestaciones;
import com.example.demo.model.AsignaPropiedadCliente;
import com.example.demo.model.Cliente;
import com.example.demo.model.Condicion;
import com.example.demo.model.Contacto;
import com.example.demo.model.DatosAdicionales;
import com.example.demo.model.DetalleAlquilerAgente;
import com.example.demo.model.DetalleAlquilerCliente;
import com.example.demo.model.DetalleAlquilerClienteDestino;
import com.example.demo.model.DetalleAlquilerDocumento;
import com.example.demo.model.DetalleFotosOportunidad;
import com.example.demo.model.DetalleFotosPropiedad;
import com.example.demo.model.DetallePedidoTipo;
import com.example.demo.model.DetallePedidoUbicacion;
import com.example.demo.model.DetallePropiedadDocumento;
import com.example.demo.model.DetalleVentaAgente;
import com.example.demo.model.DetalleVentaCliente;
import com.example.demo.model.DetalleVentaClienteDestino;
import com.example.demo.model.DetalleVentaDocumento;
import com.example.demo.model.Estado;
import com.example.demo.model.Moneda;
import com.example.demo.model.OportunidadInversion;
import com.example.demo.model.Pedido;
import com.example.demo.model.Preferencia;
import com.example.demo.model.Prestacion;
import com.example.demo.model.Propiedad;
import com.example.demo.model.Seguimiento;
import com.example.demo.model.TabladeTabla;
import com.example.demo.model.Tipo;
import com.example.demo.model.Ubicacion;
import com.example.demo.model.Venta;

public interface MetroService {
	//Agente
		List<Agente> listarAgente();
		
		Agente listarIdAgente(String id);
		
		Agente login(String correo, String contra);
		
		Agente addAgente(Agente u);
		
		Agente editAgente(Agente u);
		
		Agente deleteAgente(String id);
		
	//Alquiler
		List<Alquiler> listarAlquiler();
		
		Alquiler listarIdAlquiler(String id);
		
		Alquiler addAlquiler(Alquiler u);
		
		Alquiler editAlquiler(Alquiler u);
		
		Alquiler deleteAlquiler(String id);
		
	//AsignaAgencia
		List<AsignaAgencia> listarAsignaAgencia();
		
		AsignaAgencia listarIdAsignaAgencia(String id);
		
		AsignaAgencia addAsignaAgencia(AsignaAgencia u);
		
		AsignaAgencia editAsignaAgencia(AsignaAgencia u);
		
		AsignaAgencia deleteAsignaAgencia(String id);
			
	//AsignaPrestaciones
		List<AsignaPrestaciones> listarAsignaPrestaciones();
		
		AsignaPrestaciones listarIdAsignaPrestaciones(String id);
		
		AsignaPrestaciones addAsignaPrestaciones(AsignaPrestaciones u);
		
		AsignaPrestaciones editAsignaPrestaciones(AsignaPrestaciones u);
		
		AsignaPrestaciones deleteAsignaPrestaciones(String id);
	
	//AsignaPropiedadCliente
		List<AsignaPropiedadCliente> listarAsignaPropiedadCliente();
		
		AsignaPropiedadCliente listarIdAsignaPropiedadCliente(String id);
		
		AsignaPropiedadCliente addAsignaPropiedadCliente(AsignaPropiedadCliente u);
		
		AsignaPropiedadCliente editAsignaPropiedadCliente(AsignaPropiedadCliente u);
		
		AsignaPropiedadCliente deleteAsignaPropiedadCliente(String id);
	
	//Cliente
		List<Cliente> listarCliente();
		
		Cliente listarIdCliente(String id);
		
		Cliente addCliente(Cliente u);
		
		Cliente editCliente(Cliente u);
		
		Cliente deleteCliente(String id);
		
	//Contacto
		List<Contacto> listarContacto();
		
		Contacto listarIdContacto(String id);
		
		Contacto addContacto(Contacto u);
		
		Contacto editContacto(Contacto u);
		
		Contacto deleteContacto(String id);
	
	//DatosAdicionales
		List<DatosAdicionales> listarDatosAdicionales();
		
		DatosAdicionales listarIdDatosAdicionales(String id);
		
		DatosAdicionales addDatosAdicionales(DatosAdicionales u);
		
		DatosAdicionales editDatosAdicionales(DatosAdicionales u);
		
		DatosAdicionales deleteDatosAdicionales(String id);
	
	//DetalleAlquilerAgente
		List<DetalleAlquilerAgente> listarDetalleAlquilerAgente();
		
		DetalleAlquilerAgente listarIdDetalleAlquilerAgente(String id);
		
		DetalleAlquilerAgente addDetalleAlquilerAgente(DetalleAlquilerAgente u);
		
		DetalleAlquilerAgente editDetalleAlquilerAgente(DetalleAlquilerAgente u);
		
		DetalleAlquilerAgente deleteDetalleAlquilerAgente(String id);
	
	//DetalleAlquilerCliente
		List<DetalleAlquilerCliente> listarDetalleAlquilerCliente();
		
		DetalleAlquilerCliente listarIdDetalleAlquilerCliente(String id);
		
		DetalleAlquilerCliente addDetalleAlquilerCliente(DetalleAlquilerCliente u);
		
		DetalleAlquilerCliente editDetalleAlquilerCliente(DetalleAlquilerCliente u);
		
		DetalleAlquilerCliente deleteDetalleAlquilerCliente(String id);
	
	//DetalleAlquilerClienteDestino
		List<DetalleAlquilerClienteDestino> listarDetalleAlquilerClienteDestino();
		
		DetalleAlquilerClienteDestino listarIdDetalleAlquilerClienteDestino(String id);
		
		DetalleAlquilerClienteDestino addDetalleAlquilerClienteDestino(DetalleAlquilerClienteDestino u);
		
		DetalleAlquilerClienteDestino editDetalleAlquilerClienteDestino(DetalleAlquilerClienteDestino u);
		
		DetalleAlquilerClienteDestino deleteDetalleAlquilerClienteDestino(String id);
		
		//DetalleAlquilerDocumento
		List<DetalleAlquilerDocumento> listarDetalleAlquilerDocumento();
		
		DetalleAlquilerDocumento listarIdDetalleAlquilerDocumento(String id);
		
		DetalleAlquilerDocumento addDetalleAlquilerDocumento(DetalleAlquilerDocumento u);
		
		DetalleAlquilerDocumento editDetalleAlquilerDocumento(DetalleAlquilerDocumento u);
		
		DetalleAlquilerDocumento deleteDetalleAlquilerDocumento(String id);
		
		//DetalleFotosOportunidad
		List<DetalleFotosOportunidad> listarDetalleFotosOportunidad();
		
		DetalleFotosOportunidad listarIdDetalleFotosOportunidad(String id);
		
		DetalleFotosOportunidad addDetalleFotosOportunidad(DetalleFotosOportunidad u);
		
		DetalleFotosOportunidad editDetalleFotosOportunidad(DetalleFotosOportunidad u);
		
		DetalleFotosOportunidad deleteDetalleFotosOportunidad(String id);
		
		//DetalleFotosPropiedad
		List<DetalleFotosPropiedad> listarDetalleFotosPropiedad();
		
		List<DetalleFotosPropiedad> listarDetalleporPropiedad(String id);
		
		DetalleFotosPropiedad listarIdDetalleFotosPropiedad(String id);
		
		DetalleFotosPropiedad addDetalleFotosPropiedad(DetalleFotosPropiedad u);
		
		DetalleFotosPropiedad editDetalleFotosPropiedad(DetalleFotosPropiedad u);
		
		DetalleFotosPropiedad deleteDetalleFotosPropiedad(String id);
		
		//DetallePedidoTipo
		List<DetallePedidoTipo> listarDetallePedidoTipo();
		
		DetallePedidoTipo listarIdDetallePedidoTipo(String id);
		
		DetallePedidoTipo addDetallePedidoTipo(DetallePedidoTipo u);
		
		DetallePedidoTipo editDetallePedidoTipo(DetallePedidoTipo u);
		
		DetallePedidoTipo deleteDetallePedidoTipo(String id);
		
		//DetallePedidoUbicacion
		List<DetallePedidoUbicacion> listarDetallePedidoUbicacion();
		
		DetallePedidoUbicacion listarIdDetallePedidoUbicacion(String id);
		
		DetallePedidoUbicacion addDetallePedidoUbicacion(DetallePedidoUbicacion u);
		
		DetallePedidoUbicacion editDetallePedidoUbicacion(DetallePedidoUbicacion u);
		
		DetallePedidoUbicacion deleteDetallePedidoUbicacion(String id);
		
		//DetallePropiedadDocumento
		List<DetallePropiedadDocumento> listarDetallePropiedadDocumento();
		
		DetallePropiedadDocumento listarIdDetallePropiedadDocumento(String id);
		
		DetallePropiedadDocumento addDetallePropiedadDocumento(DetallePropiedadDocumento u);
		
		DetallePropiedadDocumento editDetallePropiedadDocumento(DetallePropiedadDocumento u);
		
		DetallePropiedadDocumento deleteDetallePropiedadDocumento(String id);
		
		//DetalleVentaAgente
		List<DetalleVentaAgente> listarDetalleVentaAgente();
		
		DetalleVentaAgente listarIdDetalleVentaAgente(String id);
		
		DetalleVentaAgente addDetalleVentaAgente(DetalleVentaAgente u);
		
		DetalleVentaAgente editDetalleVentaAgente(DetalleVentaAgente u);
		
		DetalleVentaAgente deleteDetalleVentaAgente(String id);
		
		//DetalleVentaCliente
		List<DetalleVentaCliente> listarDetalleVentaCliente();
		
		DetalleVentaCliente listarIdDetalleVentaCliente(String id);
		
		DetalleVentaCliente addDetalleVentaCliente(DetalleVentaCliente u);
		
		DetalleVentaCliente editDetalleVentaCliente(DetalleVentaCliente u);
		
		DetalleVentaCliente deleteDetalleVentaCliente(String id);
		
		//DetalleVentaClienteDestino
		List<DetalleVentaClienteDestino> listarDetalleVentaClienteDestino();
		
		DetalleVentaClienteDestino listarIdDetalleVentaClienteDestino(String id);
		
		DetalleVentaClienteDestino addDetalleVentaClienteDestino(DetalleVentaClienteDestino u);
		
		DetalleVentaClienteDestino editDetalleVentaClienteDestino(DetalleVentaClienteDestino u);
		
		DetalleVentaClienteDestino deleteDetalleVentaClienteDestino(String id);
		
		//DetalleVentaDocumento
		List<DetalleVentaDocumento> listarDetalleVentaDocumento();
		
		DetalleVentaDocumento listarIdDetalleVentaDocumento(String id);
		
		DetalleVentaDocumento addDetalleVentaDocumento(DetalleVentaDocumento u);
		
		DetalleVentaDocumento editDetalleVentaDocumento(DetalleVentaDocumento u);
		
		DetalleVentaDocumento deleteDetalleVentaDocumento(String id);
		
		//DetalleVentaClienteDestino
		List<OportunidadInversion> listarOportunidadInversion();
		
		OportunidadInversion listarIdOportunidadInversion(String id);
		
		OportunidadInversion addOportunidadInversion(OportunidadInversion u);
		
		OportunidadInversion editOportunidadInversion(OportunidadInversion u);
		
		OportunidadInversion deleteOportunidadInversion(String id);
		
		//DetalleVentaClienteDestino
		List<Pedido> listarPedido();
		
		Pedido listarIdPedido(String id);
		
		Pedido addPedido(Pedido u);
		
		Pedido editPedido(Pedido u);
		
		Pedido deletePedido(String id);
		
		//DetalleVentaClienteDestino
		List<Moneda> listarPrecio();
		
		Moneda listarIdPrecio(String id);
		
		Moneda addPrecio(Moneda u);
		
		Moneda editPrecio(Moneda u);
		
		Moneda deletePrecio(String id);
		
		//DetalleVentaClienteDestino
		List<Preferencia> listarPreferencia();
		
		List<TabladeTabla> listarTiposTabladeTabla(String tip);
		
		Preferencia listarIdPreferencia(String id);
		
		Preferencia addPreferencia(Preferencia u);
		
		Preferencia editPreferencia(Preferencia u);
		
		Preferencia deletePreferencia(String id);
		
		//DetalleVentaClienteDestino
		List<Prestacion> listarPrestacion();
		
		Prestacion listarIdPrestacion(String id);
		
		Prestacion addPrestacion(Prestacion u);
		
		Prestacion editPrestacion(Prestacion u);
		
		Prestacion deletePrestacion(String id);
		
		//DetalleVentaClienteDestino
		
		int contarPropiedad();
		
		List<Propiedad> listarPropiedad();
		
		Propiedad listarIdPropiedad(String id);
		
		Propiedad addPropiedad(Propiedad u);
		
		Propiedad editPropiedad(Propiedad u);
		
		Propiedad deletePropiedad(String id);
		
		//DetalleVentaClienteDestino
		List<Seguimiento> listarSeguimiento();
		
		Seguimiento listarIdSeguimiento(String id);
		
		Seguimiento addSeguimiento(Seguimiento u);
		
		Seguimiento editSeguimiento(Seguimiento u);
		
		Seguimiento deleteSeguimiento(String id);
		
		//DetalleVentaClienteDestino
		List<TabladeTabla> listarTabladeTabla();
		
		TabladeTabla listarIdTabladeTabla(String id);
		
		TabladeTabla addTabladeTabla(TabladeTabla u);
		
		TabladeTabla editTabladeTabla(TabladeTabla u);
		
		TabladeTabla deleteTabladeTabla(String id);
		
		//Agencia
		List<Agencia> listarAgencia();
		
		Agencia listarIdAgencia(String id);
		
		Agencia addAgencia(Agencia u);
		
		Agencia editAgencia(Agencia u);
		
		Agencia deleteAgencia(String id);
		
		//Tipo
		List<Tipo> listarTipo();
		
		Tipo listarIdTipo(String id);
		
		Tipo addTipo(Tipo u);
		
		Tipo editTipo(Tipo u);
		
		Tipo deleteTipo(String id);
		
		//Ubicacion
		List<Ubicacion> listarUbicacion();
		
		Ubicacion listarIdUbicacion(String id);
		
		Ubicacion addUbicacion(Ubicacion u);
		
		Ubicacion editUbicacion(Ubicacion u);
		
		Ubicacion deleteUbicacion(String id);
		
		//Condicion
		List<Condicion> listarCondicion();
		
		Condicion listarIdCondicion(String id);
		
		Condicion addCondicion(Condicion u);
		
		Condicion editCondicion(Condicion u);
		
		Condicion deleteCondicion(String id);
		
		//Estado
		List<Estado> listarEstado();
		
		Estado listarIdEstado(String id);
		
		Estado addEstado(Estado u);
		
		Estado editEstado(Estado u);
		
		Estado deleteEstado(String id);
		
		//Venta
		List<Venta> listarVenta();
		
		Venta listarIdVenta(String id);
		
		Venta addVenta(Venta u);
		
		Venta editVenta(Venta u);
		
		Venta deleteVenta(String id);

}
