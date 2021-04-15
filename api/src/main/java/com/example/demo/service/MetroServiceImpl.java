package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AgenciaDAO;
import com.example.demo.dao.AgenteDAO;
import com.example.demo.dao.AlquilerDAO;
import com.example.demo.dao.AsignaAgenciaDAO;
import com.example.demo.dao.AsignaPrestacionesDAO;
import com.example.demo.dao.AsignaPropiedadClienteDAO;
import com.example.demo.dao.ClienteDAO;
import com.example.demo.dao.CondicionDAO;
import com.example.demo.dao.ContactoDAO;
import com.example.demo.dao.DatosAdicionalesDAO;
import com.example.demo.dao.DetalleAlquilerAgenteDAO;
import com.example.demo.dao.DetalleAlquilerClienteDAO;
import com.example.demo.dao.DetalleAlquilerClienteDestinoDAO;
import com.example.demo.dao.DetalleAlquilerDocumentoDAO;
import com.example.demo.dao.DetalleFotosOportunidadDAO;
import com.example.demo.dao.DetalleFotosPropiedadDAO;
import com.example.demo.dao.DetallePedidoTipoDAO;
import com.example.demo.dao.DetallePedidoUbicacionDAO;
import com.example.demo.dao.DetallePropiedadDocumentoDAO;
import com.example.demo.dao.DetalleVentaAgenteDAO;
import com.example.demo.dao.DetalleVentaClienteDAO;
import com.example.demo.dao.DetalleVentaClienteDestinoDAO;
import com.example.demo.dao.DetalleVentaDocumentoDAO;
import com.example.demo.dao.EstadoDAO;
import com.example.demo.dao.MonedaDAO;
import com.example.demo.dao.OportunidadInversionDAO;
import com.example.demo.dao.PedidoDAO;
import com.example.demo.dao.PreferenciaDAO;
import com.example.demo.dao.PrestacionDAO;
import com.example.demo.dao.PropiedadDAO;
import com.example.demo.dao.SeguimientoDAO;
import com.example.demo.dao.TabladeTablaDAO;
import com.example.demo.dao.TipoDAO;
import com.example.demo.dao.UbicacionDAO;
import com.example.demo.dao.VentaDAO;
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

@Service
public class MetroServiceImpl implements MetroService{
	
	@Autowired
	private AgenteDAO agenteDAO;
	
	@Autowired
	private AlquilerDAO alquilerDAO;
	
	@Autowired
	private AsignaAgenciaDAO asignaAgenciaDAO;
	
	@Autowired
	private AsignaPrestacionesDAO asignaPrestacionesDAO;
	
	@Autowired
	private AsignaPropiedadClienteDAO asignaPropiedadClienteDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ContactoDAO contactoDAO;
	
	@Autowired
	private DatosAdicionalesDAO datosAdicionalesDAO;
	
	@Autowired
	private DetalleAlquilerAgenteDAO detalleAlquilerAgenteDAO;
	
	@Autowired
	private DetalleAlquilerClienteDAO detalleAlquilerClienteDAO;
	
	@Autowired
	private DetalleAlquilerClienteDestinoDAO detalleAlquilerClienteDestinoDAO;
	
	@Autowired
	private DetalleAlquilerDocumentoDAO detalleAlquilerDocumentoDAO;
	
	@Autowired
	private DetalleFotosOportunidadDAO detalleFotosOportunidadDAO;
	
	@Autowired
	private DetalleFotosPropiedadDAO detalleFotosPropiedadDAO;
	
	@Autowired
	private DetallePedidoTipoDAO detallePedidoTipoDAO;
	
	@Autowired
	private DetallePedidoUbicacionDAO detallePedidoUbicacionDAO;
	
	@Autowired
	private DetallePropiedadDocumentoDAO detallePropiedadDocumentoDAO;
	
	@Autowired
	private DetalleVentaAgenteDAO detalleVentaAgenteDAO;
	
	@Autowired
	private DetalleVentaClienteDAO detalleVentaClienteDAO;
	
	@Autowired
	private DetalleVentaClienteDestinoDAO detalleVentaClienteDestinoDAO;
	
	@Autowired
	private DetalleVentaDocumentoDAO detalleVentaDocumentoDAO;
	
	@Autowired
	private OportunidadInversionDAO oportunidadInversionDAO;
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private MonedaDAO monedaDAO;
	
	@Autowired
	private PreferenciaDAO preferenciaDAO;
	
	@Autowired
	private PrestacionDAO prestacionDAO;
	
	@Autowired
	private PropiedadDAO propiedadDAO;
	
	@Autowired
	private SeguimientoDAO seguimientoDAO;
	
	@Autowired
	private TabladeTablaDAO tabladeTablaDAO;
	
	@Autowired
	private VentaDAO ventaDAO;
	
	@Autowired
	private AgenciaDAO agenciaDAO;
	
	@Autowired
	private TipoDAO tipoDAO;
	
	@Autowired
	private CondicionDAO condicionDAO;
	
	@Autowired
	private UbicacionDAO ubicacionDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	
	@Override
	public List<Agente> listarAgente() {
		return agenteDAO.findAll();
	}

	@Override
	public Agente listarIdAgente(String id) {
		return agenteDAO.findById(id);
	}
	
	@Override
	public Agente login(String correo, String contra) {
		List<Agente> lista = listarAgente();
		for(Agente a:lista) {
			if(a.getCorreo().equals(correo) && a.getContrasena().equals(contra)) {
				return a;
			}
		}
		return new Agente();
	}
	
	@Override
	public Agente addAgente(Agente u) {
		return agenteDAO.save(u);
	}

	@Override
	public Agente editAgente(Agente u) {
		return agenteDAO.save(u);
	}

	@Override
	public Agente deleteAgente(String id) {
		Agente agente = listarIdAgente(id);
		agenteDAO.delete(agente);
		return agente;
	}

	@Override
	public List<Alquiler> listarAlquiler() {
		return alquilerDAO.findAll();
	}

	@Override
	public Alquiler listarIdAlquiler(String id) {
		return alquilerDAO.findById(id);
	}

	@Override
	public Alquiler addAlquiler(Alquiler u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdAlquiler(idOne.toString());
		return alquilerDAO.save(u);
	}

	@Override
	public Alquiler editAlquiler(Alquiler u) {
		return alquilerDAO.save(u);
	}

	@Override
	public Alquiler deleteAlquiler(String id) {
		Alquiler agente = listarIdAlquiler(id);
		alquilerDAO.delete(agente);
		return agente;
	}

	@Override
	public List<AsignaAgencia> listarAsignaAgencia() {
		return asignaAgenciaDAO.findAll();
	}

	@Override
	public AsignaAgencia listarIdAsignaAgencia(String id) {
		return asignaAgenciaDAO.findById(id);
	}

	@Override
	public AsignaAgencia addAsignaAgencia(AsignaAgencia u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdAsignaAgencia(idOne.toString());
		return asignaAgenciaDAO.save(u);
	}

	@Override
	public AsignaAgencia editAsignaAgencia(AsignaAgencia u) {
		return asignaAgenciaDAO.save(u);
	}

	@Override
	public AsignaAgencia deleteAsignaAgencia(String id) {
		AsignaAgencia AsignaAgencia = listarIdAsignaAgencia(id);
		asignaAgenciaDAO.delete(AsignaAgencia);
		return AsignaAgencia;
	}

	@Override
	public List<AsignaPrestaciones> listarAsignaPrestaciones() {
		return asignaPrestacionesDAO.findAll();
	}

	@Override
	public AsignaPrestaciones listarIdAsignaPrestaciones(String id) {
		return asignaPrestacionesDAO.findById(id);
	}

	@Override
	public AsignaPrestaciones addAsignaPrestaciones(AsignaPrestaciones u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdAsignaPrestacion(idOne.toString());
		return asignaPrestacionesDAO.save(u);
	}

	@Override
	public AsignaPrestaciones editAsignaPrestaciones(AsignaPrestaciones u) {
		return asignaPrestacionesDAO.save(u);
	}

	@Override
	public AsignaPrestaciones deleteAsignaPrestaciones(String id) {
		AsignaPrestaciones AsignaPrestaciones = listarIdAsignaPrestaciones(id);
		asignaPrestacionesDAO.delete(AsignaPrestaciones);
		return AsignaPrestaciones;
	}

	@Override
	public List<AsignaPropiedadCliente> listarAsignaPropiedadCliente() {
		return asignaPropiedadClienteDAO.findAll();
	}

	@Override
	public AsignaPropiedadCliente listarIdAsignaPropiedadCliente(String id) {
		return asignaPropiedadClienteDAO.findById(id);
	}

	@Override
	public AsignaPropiedadCliente addAsignaPropiedadCliente(AsignaPropiedadCliente u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdAsignaPropiedad(idOne.toString());
		return asignaPropiedadClienteDAO.save(u);
	}

	@Override
	public AsignaPropiedadCliente editAsignaPropiedadCliente(AsignaPropiedadCliente u) {
		return asignaPropiedadClienteDAO.save(u);
	}

	@Override
	public AsignaPropiedadCliente deleteAsignaPropiedadCliente(String id) {
		AsignaPropiedadCliente AsignaPropiedadCliente = listarIdAsignaPropiedadCliente(id);
		asignaPropiedadClienteDAO.delete(AsignaPropiedadCliente);
		return AsignaPropiedadCliente;
	}

	@Override
	public List<Cliente> listarCliente() {
		return clienteDAO.findAll();
	}

	@Override
	public Cliente listarIdCliente(String id) {
		return clienteDAO.findById(id);
	}

	@Override
	public Cliente addCliente(Cliente u) {
		return clienteDAO.save(u);
	}

	@Override
	public Cliente editCliente(Cliente u) {
		return clienteDAO.save(u);
	}

	@Override
	public Cliente deleteCliente(String id) {
		Cliente Cliente = listarIdCliente(id);
		clienteDAO.delete(Cliente);
		return Cliente;
	}
	
	
	@Override
	public List<Contacto> listarContacto() {
		return contactoDAO.findAll();
	}

	@Override
	public Contacto listarIdContacto(String id) {
		return contactoDAO.findById(id);
	}

	@Override
	public Contacto addContacto(Contacto u) {
		return contactoDAO.save(u);
	}

	@Override
	public Contacto editContacto(Contacto u) {
		return contactoDAO.save(u);
	}

	@Override
	public Contacto deleteContacto(String id) {
		Contacto contacto = listarIdContacto(id);
		contactoDAO.delete(contacto);
		return contacto;
	}

	@Override
	public List<DatosAdicionales> listarDatosAdicionales() {
		return datosAdicionalesDAO.findAll();
	}

	@Override
	public DatosAdicionales listarIdDatosAdicionales(String id) {
		return datosAdicionalesDAO.findById(id);
	}

	@Override
	public DatosAdicionales addDatosAdicionales(DatosAdicionales u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDatoAdicional(idOne.toString());
		return datosAdicionalesDAO.save(u);
	}

	@Override
	public DatosAdicionales editDatosAdicionales(DatosAdicionales u) {
		return datosAdicionalesDAO.save(u);
	}

	@Override
	public DatosAdicionales deleteDatosAdicionales(String id) {
		DatosAdicionales DatosAdicionales = listarIdDatosAdicionales(id);
		datosAdicionalesDAO.delete(DatosAdicionales);
		return DatosAdicionales;
	}

	@Override
	public List<DetalleAlquilerAgente> listarDetalleAlquilerAgente() {
		return detalleAlquilerAgenteDAO.findAll();
	}

	@Override
	public DetalleAlquilerAgente listarIdDetalleAlquilerAgente(String id) {
		return detalleAlquilerAgenteDAO.findById(id);
	}

	@Override
	public DetalleAlquilerAgente addDetalleAlquilerAgente(DetalleAlquilerAgente u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleAlquilerAgente(idOne.toString());
		return detalleAlquilerAgenteDAO.save(u);
	}

	@Override
	public DetalleAlquilerAgente editDetalleAlquilerAgente(DetalleAlquilerAgente u) {
		return detalleAlquilerAgenteDAO.save(u);
	}

	@Override
	public DetalleAlquilerAgente deleteDetalleAlquilerAgente(String id) {
		DetalleAlquilerAgente DetalleAlquilerAgente = listarIdDetalleAlquilerAgente(id);
		detalleAlquilerAgenteDAO.delete(DetalleAlquilerAgente);
		return DetalleAlquilerAgente;
	}

	@Override
	public List<DetalleAlquilerCliente> listarDetalleAlquilerCliente() {
		return detalleAlquilerClienteDAO.findAll();
	}

	@Override
	public DetalleAlquilerCliente listarIdDetalleAlquilerCliente(String id) {
		return detalleAlquilerClienteDAO.findById(id);
	}

	@Override
	public DetalleAlquilerCliente addDetalleAlquilerCliente(DetalleAlquilerCliente u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleAlquilerCliente(idOne.toString());
		return detalleAlquilerClienteDAO.save(u);
	}

	@Override
	public DetalleAlquilerCliente editDetalleAlquilerCliente(DetalleAlquilerCliente u) {
		return detalleAlquilerClienteDAO.save(u);
	}

	@Override
	public DetalleAlquilerCliente deleteDetalleAlquilerCliente(String id) {
		DetalleAlquilerCliente DetalleAlquilerCliente = listarIdDetalleAlquilerCliente(id);
		detalleAlquilerClienteDAO.delete(DetalleAlquilerCliente);
		return DetalleAlquilerCliente;
	}

	@Override
	public List<DetalleAlquilerClienteDestino> listarDetalleAlquilerClienteDestino() {
		return detalleAlquilerClienteDestinoDAO.findAll();
	}

	@Override
	public DetalleAlquilerClienteDestino listarIdDetalleAlquilerClienteDestino(String id) {
		return detalleAlquilerClienteDestinoDAO.findById(id);
	}

	@Override
	public DetalleAlquilerClienteDestino addDetalleAlquilerClienteDestino(DetalleAlquilerClienteDestino u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleAlquilerClienteDestino(idOne.toString());
		return detalleAlquilerClienteDestinoDAO.save(u);
	}

	@Override
	public DetalleAlquilerClienteDestino editDetalleAlquilerClienteDestino(DetalleAlquilerClienteDestino u) {
		return detalleAlquilerClienteDestinoDAO.save(u);
	}

	@Override
	public DetalleAlquilerClienteDestino deleteDetalleAlquilerClienteDestino(String id) {
		DetalleAlquilerClienteDestino DetalleAlquilerClienteDestino = listarIdDetalleAlquilerClienteDestino(id);
		detalleAlquilerClienteDestinoDAO.delete(DetalleAlquilerClienteDestino);
		return DetalleAlquilerClienteDestino;
	}

	@Override
	public List<DetalleAlquilerDocumento> listarDetalleAlquilerDocumento() {
		return detalleAlquilerDocumentoDAO.findAll();
	}

	@Override
	public DetalleAlquilerDocumento listarIdDetalleAlquilerDocumento(String id) {
		return detalleAlquilerDocumentoDAO.findById(id);
	}

	@Override
	public DetalleAlquilerDocumento addDetalleAlquilerDocumento(DetalleAlquilerDocumento u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleDocumentoAlquiler(idOne.toString());
		return detalleAlquilerDocumentoDAO.save(u);
	}

	@Override
	public DetalleAlquilerDocumento editDetalleAlquilerDocumento(DetalleAlquilerDocumento u) {
		return detalleAlquilerDocumentoDAO.save(u);
	}

	@Override
	public DetalleAlquilerDocumento deleteDetalleAlquilerDocumento(String id) {
		DetalleAlquilerDocumento DetalleAlquilerDocumento = listarIdDetalleAlquilerDocumento(id);
		detalleAlquilerDocumentoDAO.delete(DetalleAlquilerDocumento);
		return DetalleAlquilerDocumento;
	}

	@Override
	public List<DetalleFotosOportunidad> listarDetalleFotosOportunidad() {
		return detalleFotosOportunidadDAO.findAll();
	}

	@Override
	public DetalleFotosOportunidad listarIdDetalleFotosOportunidad(String id) {
		return detalleFotosOportunidadDAO.findById(id);
	}

	@Override
	public DetalleFotosOportunidad addDetalleFotosOportunidad(DetalleFotosOportunidad u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalle(idOne.toString());
		return detalleFotosOportunidadDAO.save(u);
	}

	@Override
	public DetalleFotosOportunidad editDetalleFotosOportunidad(DetalleFotosOportunidad u) {
		return detalleFotosOportunidadDAO.save(u);
	}

	@Override
	public DetalleFotosOportunidad deleteDetalleFotosOportunidad(String id) {
		DetalleFotosOportunidad DetalleFotosOportunidad = listarIdDetalleFotosOportunidad(id);
		detalleFotosOportunidadDAO.delete(DetalleFotosOportunidad);
		return DetalleFotosOportunidad;
	}

	@Override
	public List<DetalleFotosPropiedad> listarDetalleFotosPropiedad() {
		return detalleFotosPropiedadDAO.findAll();
	}
	
	@Override
	public List<DetalleFotosPropiedad> listarDetalleporPropiedad(String id) {
		List<DetalleFotosPropiedad> lista = detalleFotosPropiedadDAO.findAll();
		List<DetalleFotosPropiedad> resultado = new ArrayList<>();
		for(DetalleFotosPropiedad det: lista) {
			if(det.getPropiedad().getIdPropiedad().equals(id)) {
				resultado.add(det);
			}
		}
		return resultado;
	}

	@Override
	public DetalleFotosPropiedad listarIdDetalleFotosPropiedad(String id) {
		return detalleFotosPropiedadDAO.findById(id);
	}

	@Override
	public DetalleFotosPropiedad addDetalleFotosPropiedad(DetalleFotosPropiedad u) {
		return detalleFotosPropiedadDAO.save(u);
	}

	@Override
	public DetalleFotosPropiedad editDetalleFotosPropiedad(DetalleFotosPropiedad u) {
		return detalleFotosPropiedadDAO.save(u);
	}

	@Override
	public DetalleFotosPropiedad deleteDetalleFotosPropiedad(String id) {
		DetalleFotosPropiedad DetalleFotosPropiedad = listarIdDetalleFotosPropiedad(id);
		detalleFotosPropiedadDAO.delete(DetalleFotosPropiedad);
		return DetalleFotosPropiedad;
	}

	@Override
	public List<DetallePedidoTipo> listarDetallePedidoTipo() {
		return detallePedidoTipoDAO.findAll();
	}

	@Override
	public DetallePedidoTipo listarIdDetallePedidoTipo(String id) {
		return detallePedidoTipoDAO.findById(id);
	}

	@Override
	public DetallePedidoTipo addDetallePedidoTipo(DetallePedidoTipo u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleTipo(idOne.toString());
		return detallePedidoTipoDAO.save(u);
	}

	@Override
	public DetallePedidoTipo editDetallePedidoTipo(DetallePedidoTipo u) {
		return detallePedidoTipoDAO.save(u);
	}

	@Override
	public DetallePedidoTipo deleteDetallePedidoTipo(String id) {
		DetallePedidoTipo DetallePedidoTipo = listarIdDetallePedidoTipo(id);
		detallePedidoTipoDAO.delete(DetallePedidoTipo);
		return DetallePedidoTipo;
	}

	@Override
	public List<DetallePedidoUbicacion> listarDetallePedidoUbicacion() {
		return detallePedidoUbicacionDAO.findAll();
	}

	@Override
	public DetallePedidoUbicacion listarIdDetallePedidoUbicacion(String id) {
		return detallePedidoUbicacionDAO.findById(id);
	}

	@Override
	public DetallePedidoUbicacion addDetallePedidoUbicacion(DetallePedidoUbicacion u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetallePedidoUbicacion(idOne.toString());
		return detallePedidoUbicacionDAO.save(u);
	}

	@Override
	public DetallePedidoUbicacion editDetallePedidoUbicacion(DetallePedidoUbicacion u) {
		return detallePedidoUbicacionDAO.save(u);
	}

	@Override
	public DetallePedidoUbicacion deleteDetallePedidoUbicacion(String id) {
		DetallePedidoUbicacion DetallePedidoUbicacion = listarIdDetallePedidoUbicacion(id);
		detallePedidoUbicacionDAO.delete(DetallePedidoUbicacion);
		return DetallePedidoUbicacion;
	}

	@Override
	public List<DetallePropiedadDocumento> listarDetallePropiedadDocumento() {
		return detallePropiedadDocumentoDAO.findAll();
	}

	@Override
	public DetallePropiedadDocumento listarIdDetallePropiedadDocumento(String id) {
		return detallePropiedadDocumentoDAO.findById(id);
	}

	@Override
	public DetallePropiedadDocumento addDetallePropiedadDocumento(DetallePropiedadDocumento u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetallePropiedadDocumentos(idOne.toString());
		return detallePropiedadDocumentoDAO.save(u);
	}

	@Override
	public DetallePropiedadDocumento editDetallePropiedadDocumento(DetallePropiedadDocumento u) {
		return detallePropiedadDocumentoDAO.save(u);
	}

	@Override
	public DetallePropiedadDocumento deleteDetallePropiedadDocumento(String id) {
		DetallePropiedadDocumento DetallePropiedadDocumento = listarIdDetallePropiedadDocumento(id);
		detallePropiedadDocumentoDAO.delete(DetallePropiedadDocumento);
		return DetallePropiedadDocumento;
	}

	@Override
	public List<DetalleVentaAgente> listarDetalleVentaAgente() {
		return detalleVentaAgenteDAO.findAll();
	}

	@Override
	public DetalleVentaAgente listarIdDetalleVentaAgente(String id) {
		return detalleVentaAgenteDAO.findById(id);
	}

	@Override
	public DetalleVentaAgente addDetalleVentaAgente(DetalleVentaAgente u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalle(idOne.toString());
		return detalleVentaAgenteDAO.save(u);
	}

	@Override
	public DetalleVentaAgente editDetalleVentaAgente(DetalleVentaAgente u) {
		return detalleVentaAgenteDAO.save(u);
	}

	@Override
	public DetalleVentaAgente deleteDetalleVentaAgente(String id) {
		DetalleVentaAgente DetalleVentaAgente = listarIdDetalleVentaAgente(id);
		detalleVentaAgenteDAO.delete(DetalleVentaAgente);
		return DetalleVentaAgente;
	}

	@Override
	public List<DetalleVentaCliente> listarDetalleVentaCliente() {
		return detalleVentaClienteDAO.findAll();
	}

	@Override
	public DetalleVentaCliente listarIdDetalleVentaCliente(String id) {
		return detalleVentaClienteDAO.findById(id);
	}

	@Override
	public DetalleVentaCliente addDetalleVentaCliente(DetalleVentaCliente u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalle(idOne.toString());
		return detalleVentaClienteDAO.save(u);
	}

	@Override
	public DetalleVentaCliente editDetalleVentaCliente(DetalleVentaCliente u) {
		return detalleVentaClienteDAO.save(u);
	}

	@Override
	public DetalleVentaCliente deleteDetalleVentaCliente(String id) {
		DetalleVentaCliente DetalleVentaCliente = listarIdDetalleVentaCliente(id);
		detalleVentaClienteDAO.delete(DetalleVentaCliente);
		return DetalleVentaCliente;
	}

	@Override
	public List<DetalleVentaClienteDestino> listarDetalleVentaClienteDestino() {
		return detalleVentaClienteDestinoDAO.findAll();
	}

	@Override
	public DetalleVentaClienteDestino listarIdDetalleVentaClienteDestino(String id) {
		return detalleVentaClienteDestinoDAO.findById(id);
	}

	@Override
	public DetalleVentaClienteDestino addDetalleVentaClienteDestino(DetalleVentaClienteDestino u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleVentaClienteDestino(idOne.toString());
		return detalleVentaClienteDestinoDAO.save(u);
	}

	@Override
	public DetalleVentaClienteDestino editDetalleVentaClienteDestino(DetalleVentaClienteDestino u) {
		return detalleVentaClienteDestinoDAO.save(u);
	}

	@Override
	public DetalleVentaClienteDestino deleteDetalleVentaClienteDestino(String id) {
		DetalleVentaClienteDestino DetalleVentaClienteDestino = listarIdDetalleVentaClienteDestino(id);
		detalleVentaClienteDestinoDAO.delete(DetalleVentaClienteDestino);
		return DetalleVentaClienteDestino;
	}

	@Override
	public List<DetalleVentaDocumento> listarDetalleVentaDocumento() {
		return detalleVentaDocumentoDAO.findAll();
	}

	@Override
	public DetalleVentaDocumento listarIdDetalleVentaDocumento(String id) {
		return detalleVentaDocumentoDAO.findById(id);
	}

	@Override
	public DetalleVentaDocumento addDetalleVentaDocumento(DetalleVentaDocumento u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdDetalleDocumentoVenta(idOne.toString());
		return detalleVentaDocumentoDAO.save(u);
	}

	@Override
	public DetalleVentaDocumento editDetalleVentaDocumento(DetalleVentaDocumento u) {
		return detalleVentaDocumentoDAO.save(u);
	}

	@Override
	public DetalleVentaDocumento deleteDetalleVentaDocumento(String id) {
		DetalleVentaDocumento DetalleVentaDocumento = listarIdDetalleVentaDocumento(id);
		detalleVentaDocumentoDAO.delete(DetalleVentaDocumento);
		return DetalleVentaDocumento;
	}


	@Override
	public List<OportunidadInversion> listarOportunidadInversion() {
		return oportunidadInversionDAO.findAll();
	}

	@Override
	public OportunidadInversion listarIdOportunidadInversion(String id) {
		return oportunidadInversionDAO.findById(id);
	}

	@Override
	public OportunidadInversion addOportunidadInversion(OportunidadInversion u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdOportunidadInversion(idOne.toString());
		return oportunidadInversionDAO.save(u);
	}

	@Override
	public OportunidadInversion editOportunidadInversion(OportunidadInversion u) {
		return oportunidadInversionDAO.save(u);
	}

	@Override
	public OportunidadInversion deleteOportunidadInversion(String id) {
		OportunidadInversion OportunidadInversion = listarIdOportunidadInversion(id);
		oportunidadInversionDAO.delete(OportunidadInversion);
		return OportunidadInversion;
	}

	@Override
	public List<Pedido> listarPedido() {
		return pedidoDAO.findAll();
	}

	@Override
	public Pedido listarIdPedido(String id) {
		return pedidoDAO.findById(id);
	}

	@Override
	public Pedido addPedido(Pedido u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdPedido(idOne.toString());
		return pedidoDAO.save(u);
	}

	@Override
	public Pedido editPedido(Pedido u) {
		return pedidoDAO.save(u);
	}

	@Override
	public Pedido deletePedido(String id) {
		Pedido Pedido = listarIdPedido(id);
		pedidoDAO.delete(Pedido);
		return Pedido;
	}

	@Override
	public List<Moneda> listarPrecio() {
		return monedaDAO.findAll();
	}

	@Override
	public Moneda listarIdPrecio(String id) {
		return monedaDAO.findById(id);
	}

	@Override
	public Moneda addPrecio(Moneda u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdMoneda(idOne.toString());
		return monedaDAO.save(u);
	}

	@Override
	public Moneda editPrecio(Moneda u) {
		return monedaDAO.save(u);
	}

	@Override
	public Moneda deletePrecio(String id) {
		Moneda Precio = listarIdPrecio(id);
		monedaDAO.delete(Precio);
		return Precio;
	}

	@Override
	public List<Preferencia> listarPreferencia() {
		return preferenciaDAO.findAll();
	}

	@Override
	public Preferencia listarIdPreferencia(String id) {
		return preferenciaDAO.findById(id);
	}

	@Override
	public Preferencia addPreferencia(Preferencia u) {
		return preferenciaDAO.save(u);
	}

	@Override
	public Preferencia editPreferencia(Preferencia u) {
		return preferenciaDAO.save(u);
	}

	@Override
	public Preferencia deletePreferencia(String id) {
		Preferencia Preferencia = listarIdPreferencia(id);
		preferenciaDAO.delete(Preferencia);
		return Preferencia;
	}

	@Override
	public List<Prestacion> listarPrestacion() {
		return prestacionDAO.findAll();
	}

	@Override
	public Prestacion listarIdPrestacion(String id) {
		return prestacionDAO.findById(id);
	}

	@Override
	public Prestacion addPrestacion(Prestacion u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdPrestacion(idOne.toString());
		return prestacionDAO.save(u);
	}

	@Override
	public Prestacion editPrestacion(Prestacion u) {
		return prestacionDAO.save(u);
	}

	@Override
	public Prestacion deletePrestacion(String id) {
		Prestacion Prestacion = listarIdPrestacion(id);
		prestacionDAO.delete(Prestacion);
		return Prestacion;
	}

	@Override
	public List<Propiedad> listarPropiedad() {
		return propiedadDAO.findAll();
	}
	
	@Override
	public int contarPropiedad() {
		List<Propiedad> lista = propiedadDAO.findAll();
		return lista.size();
	}
	
	@Override
	public Propiedad listarIdPropiedad(String id) {
		return propiedadDAO.findById(id);
	}

	@Override
	public Propiedad addPropiedad(Propiedad u) {
		return propiedadDAO.save(u);
	}

	@Override
	public Propiedad editPropiedad(Propiedad u) {
		return propiedadDAO.save(u);
	}

	@Override
	public Propiedad deletePropiedad(String id) {
		Propiedad Propiedad = listarIdPropiedad(id);
		propiedadDAO.delete(Propiedad);
		return Propiedad;
	}

	@Override
	public List<Seguimiento> listarSeguimiento() {
		return seguimientoDAO.findAll();
	}

	@Override
	public Seguimiento listarIdSeguimiento(String id) {
		return seguimientoDAO.findById(id);
	}

	@Override
	public Seguimiento addSeguimiento(Seguimiento u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdSeguimiento(idOne.toString());
		return seguimientoDAO.save(u);
	}

	@Override
	public Seguimiento editSeguimiento(Seguimiento u) {
		return seguimientoDAO.save(u);
	}

	@Override
	public Seguimiento deleteSeguimiento(String id) {
		Seguimiento Seguimiento = listarIdSeguimiento(id);
		seguimientoDAO.delete(Seguimiento);
		return Seguimiento;
	}

	@Override
	public List<TabladeTabla> listarTabladeTabla() {
		return tabladeTablaDAO.findAll();
	}
	
	
	@Override
	public List<TabladeTabla> listarTiposTabladeTabla(String tip) {
		List<TabladeTabla> lista = tabladeTablaDAO.findAll();
		List<TabladeTabla> resultado = null;
		for(TabladeTabla obj: lista) {
			if(obj.getTipo().equals(tip)) {
				resultado.add(obj);
			}
		}
		return resultado;
	}

	@Override
	public TabladeTabla listarIdTabladeTabla(String id) {
		return tabladeTablaDAO.findById(id);
	}

	@Override
	public TabladeTabla addTabladeTabla(TabladeTabla u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdTablaTabla(idOne.toString());
		return tabladeTablaDAO.save(u);
	}

	@Override
	public TabladeTabla editTabladeTabla(TabladeTabla u) {
		return tabladeTablaDAO.save(u);
	}

	@Override
	public TabladeTabla deleteTabladeTabla(String id) {
		TabladeTabla TabladeTabla = listarIdTabladeTabla(id);
		tabladeTablaDAO.delete(TabladeTabla);
		return TabladeTabla;
	}

	@Override
	public List<Venta> listarVenta() {
		return ventaDAO.findAll();
	}

	@Override
	public Venta listarIdVenta(String id) {
		return ventaDAO.findById(id);
	}

	@Override
	public Venta addVenta(Venta u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdVenta(idOne.toString());
		return ventaDAO.save(u);
	}

	@Override
	public Venta editVenta(Venta u) {
		return ventaDAO.save(u);
	}

	@Override
	public Venta deleteVenta(String id) {
		Venta Venta = listarIdVenta(id);
		ventaDAO.delete(Venta);
		return Venta;
	}
	
	
	
	@Override
	public List<Agencia> listarAgencia() {
		return agenciaDAO.findAll();
	}

	@Override
	public Agencia listarIdAgencia(String id) {
		return agenciaDAO.findById(id);
	}

	@Override
	public Agencia addAgencia(Agencia u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdAgencia(idOne.toString());
		return agenciaDAO.save(u);
	}

	@Override
	public Agencia editAgencia(Agencia u) {
		return agenciaDAO.save(u);
	}

	@Override
	public Agencia deleteAgencia(String id) {
		Agencia agencia = listarIdAgencia(id);
		agenciaDAO.delete(agencia);
		return agencia;
	}
	
	@Override
	public List<Tipo> listarTipo() {
		return tipoDAO.findAll();
	}

	@Override
	public Tipo listarIdTipo(String id) {
		return tipoDAO.findById(id);
	}

	@Override
	public Tipo addTipo(Tipo u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdTipo(idOne.toString());
		return tipoDAO.save(u);
	}

	@Override
	public Tipo editTipo(Tipo u) {
		return tipoDAO.save(u);
	}

	@Override
	public Tipo deleteTipo(String id) {
		Tipo tipo = listarIdTipo(id);
		tipoDAO.delete(tipo);
		return tipo;
	}
	
	
	@Override
	public List<Ubicacion> listarUbicacion() {
		return ubicacionDAO.findAll();
	}

	@Override
	public Ubicacion listarIdUbicacion(String id) {
		return ubicacionDAO.findById(id);
	}

	@Override
	public Ubicacion addUbicacion(Ubicacion u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdUbicacion(idOne.toString());
		return ubicacionDAO.save(u);
	}

	@Override
	public Ubicacion editUbicacion(Ubicacion u) {
		return ubicacionDAO.save(u);
	}

	@Override
	public Ubicacion deleteUbicacion(String id) {
		Ubicacion ubicacion = listarIdUbicacion(id);
		ubicacionDAO.delete(ubicacion);
		return ubicacion;
	}
	
	@Override
	public List<Condicion> listarCondicion() {
		return condicionDAO.findAll();
	}

	@Override
	public Condicion listarIdCondicion(String id) {
		return condicionDAO.findById(id);
	}

	@Override
	public Condicion addCondicion(Condicion u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdCondicion(idOne.toString());
		return condicionDAO.save(u);
	}

	@Override
	public Condicion editCondicion(Condicion u) {
		return condicionDAO.save(u);
	}

	@Override
	public Condicion deleteCondicion(String id) {
		Condicion condicion = listarIdCondicion(id);
		condicionDAO.delete(condicion);
		return condicion;
	}
	
	
	@Override
	public List<Estado> listarEstado() {
		return estadoDAO.findAll();
	}

	@Override
	public Estado listarIdEstado(String id) {
		return estadoDAO.findById(id);
	}

	@Override
	public Estado addEstado(Estado u) {
		String idOne = UUID.randomUUID().toString();
		idOne=idOne.replaceAll("-","");
		u.setIdEstado(idOne.toString());
		return estadoDAO.save(u);
	}

	@Override
	public Estado editEstado(Estado u) {
		return estadoDAO.save(u);
	}

	@Override
	public Estado deleteEstado(String id) {
		Estado estado = listarIdEstado(id);
		estadoDAO.delete(estado);
		return estado;
	}

}
